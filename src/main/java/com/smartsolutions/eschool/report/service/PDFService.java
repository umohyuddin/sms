package com.smartsolutions.eschool.report.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.smartsolutions.eschool.academic.entity.mapping.StudentExamMarksEntity;
import com.smartsolutions.eschool.academic.entity.master.ExamEntity;
import com.smartsolutions.eschool.academic.entity.master.GradeScaleEntity;
import com.smartsolutions.eschool.academic.repository.ExamRepository;
import com.smartsolutions.eschool.academic.repository.GradeScaleRepository;
import com.smartsolutions.eschool.academic.repository.StudentExamMarksRepository;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.repository.CampusRepository;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import com.smartsolutions.eschool.sclass.model.SectionEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;
import com.smartsolutions.eschool.sclass.repository.SectionRepository;
import com.smartsolutions.eschool.sclass.repository.StandardRepository;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.student.repository.StudentRepository;
import com.smartsolutions.eschool.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PDFService {

    private final InstituteRepository instituteRepository;
    private final StudentRepository studentRepository;
    private final ExamRepository examRepository;
    private final StudentExamMarksRepository marksRepository;
    private final CampusRepository campusRepository;
    private final StandardRepository standardRepository;
    private final SectionRepository sectionRepository;
    private final GradeScaleRepository gradeScaleRepository;

    /**
     * Entry-point called by the controller.
     */
    @Transactional(readOnly = true)
    public byte[] generatePdf(String docType, Long studentId, Long examId, Long campusId, Long standardId, Long sectionId, Long examTermId) {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        Optional<InstituteEntity> instituteOpt = instituteRepository.findById(orgId);
        InstituteEntity institute = instituteOpt.orElse(null);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4, 36, 36, 36, 36);

        try {
            PdfWriter.getInstance(document, baos);
            document.open();

            List<GradeScaleEntity> gradeScales = gradeScaleRepository.findAllByOrgId(orgId);
            gradeScales.sort((a, b) -> b.getMinPercentage().compareTo(a.getMinPercentage()));

            if ("RESULT_GAZETTE".equalsIgnoreCase(docType)) {
                generateResultGazette(document, campusId, standardId, sectionId, examId, examTermId);
            } else {
                addHeader(document, institute);

                if ("ADMISSION_FORM".equalsIgnoreCase(docType)) {
                    generateAdmissionForm(document);
                } else if ("RESULT_CARD".equalsIgnoreCase(docType)) {
                    generateResultCard(document, studentId, examId, gradeScales);
                } else {
                    document.add(new Paragraph("Document Type not supported: " + docType));
                }
            }

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return baos.toByteArray();
    }

    // ── Header ────────────────────────────────────────────────────────────────
    private void addHeader(Document document, InstituteEntity institute) throws DocumentException {
        PdfPTable headerTable = new PdfPTable(2);
        headerTable.setWidthPercentage(100);
        headerTable.setWidths(new float[]{1, 3});

        PdfPCell logoCell = new PdfPCell();
        if (institute != null && institute.getLogo() != null) {
            try {
                Image logo = Image.getInstance(institute.getLogo());
                logo.scaleToFit(80, 80);
                logoCell.addElement(logo);
            } catch (Exception e) {
                // skip logo on error
            }
        }
        logoCell.setBorder(Rectangle.NO_BORDER);
        headerTable.addCell(logoCell);

        PdfPCell infoCell = new PdfPCell();
        infoCell.setBorder(Rectangle.NO_BORDER);
        infoCell.setHorizontalAlignment(Element.ALIGN_CENTER);

        String schoolName = institute != null ? institute.getName() : "SCHOOL NAME";
        Font nameFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 22, BaseColor.DARK_GRAY);
        Paragraph namePara = new Paragraph(schoolName, nameFont);
        namePara.setAlignment(Element.ALIGN_CENTER);
        infoCell.addElement(namePara);

        String address = institute != null ? institute.getAddress() : "Address not available";
        Font detailFont = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.GRAY);
        Paragraph addrPara = new Paragraph(address, detailFont);
        addrPara.setAlignment(Element.ALIGN_CENTER);
        infoCell.addElement(addrPara);

        String contact = "Phone: " + (institute != null ? institute.getContactNumber() : "N/A") +
                " | Website: " + (institute != null ? institute.getWebsite() : "N/A");
        Paragraph contactPara = new Paragraph(contact, detailFont);
        contactPara.setAlignment(Element.ALIGN_CENTER);
        infoCell.addElement(contactPara);

        headerTable.addCell(infoCell);
        document.add(headerTable);
        document.add(new Paragraph("\n"));
    }

    // ── Result Card (dynamic) ─────────────────────────────────────────────────
    private void generateResultCard(Document document, Long studentId, Long examId, List<GradeScaleEntity> gradeScales) throws DocumentException {
        Font sectionFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, BaseColor.WHITE);
        BaseColor sectionBg = new BaseColor(31, 56, 100);

        // Title bar
        PdfPTable titleTable = new PdfPTable(1);
        titleTable.setWidthPercentage(100);
        PdfPCell titleCell = new PdfPCell(new Phrase("Result Card", sectionFont));
        titleCell.setBackgroundColor(sectionBg);
        titleCell.setPadding(5);
        titleCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        titleTable.addCell(titleCell);
        document.add(titleTable);
        document.add(new Paragraph("\n"));

        // ── Resolve entities ──────────────────────────────────────────────────
        StudentEntity student = studentId != null
                ? studentRepository.findById(studentId).orElse(null)
                : null;

        ExamEntity exam = examId != null
                ? examRepository.findByIdAndDeletedFalse(examId).orElse(null)
                : null;

        // ── Student Info ──────────────────────────────────────────────────────
        addSectionHeader(document, "STUDENT INFORMATION");
        PdfPTable stdInfoTable = new PdfPTable(2);
        stdInfoTable.setWidthPercentage(100);
        stdInfoTable.setWidths(new float[]{1, 3});

        String studentName = student != null ? student.getFullName() : "";
        String studentCode = student != null ? student.getStudentCode() : "";
        String campusName  = (student != null && student.getCampus() != null)
                ? student.getCampus().getCampusName() : "";
        String className   = (student != null && student.getStandard() != null)
                ? student.getStandard().getStandardName() : "";
        String sectionName = (student != null && student.getSection() != null)
                ? student.getSection().getSectionName() : "";
        String examTermName = (exam != null && exam.getExamTerm() != null)
                ? exam.getExamTerm().getName() : "";
        String examName    = exam != null ? exam.getName() : "";

        addFullWidthRow(stdInfoTable, "Name",      studentName);
        addFullWidthRow(stdInfoTable, "Roll / Code", studentCode);
        addFullWidthRow(stdInfoTable, "Campus",    campusName);
        addFullWidthRow(stdInfoTable, "Class",     className);
        addFullWidthRow(stdInfoTable, "Section",   sectionName);
        addFullWidthRow(stdInfoTable, "Exam Term", examTermName);
        addFullWidthRow(stdInfoTable, "Exam",      examName);
        document.add(stdInfoTable);
        document.add(new Paragraph("\n"));

        // ── Fetch marks ───────────────────────────────────────────────────────
        List<StudentExamMarksEntity> marksList = (studentId != null && examId != null)
                ? marksRepository.findByStudentIdAndExamId(studentId, examId)
                : List.of();

        // ── Summary calculation ───────────────────────────────────────────────
        BigDecimal totalObtained = BigDecimal.ZERO;
        BigDecimal totalMax      = BigDecimal.ZERO;
        boolean anyFail          = false;

        for (StudentExamMarksEntity m : marksList) {
            BigDecimal obtained  = m.getObtainedMarks()  != null ? m.getObtainedMarks()  : BigDecimal.ZERO;
            BigDecimal maxMarks  = m.getExamSubject().getTotalMarks()   != null ? m.getExamSubject().getTotalMarks()   : BigDecimal.ZERO;
            BigDecimal passMarks = m.getExamSubject().getPassingMarks() != null ? m.getExamSubject().getPassingMarks() : BigDecimal.ZERO;
            totalObtained = totalObtained.add(obtained);
            totalMax      = totalMax.add(maxMarks);
            if (maxMarks.compareTo(BigDecimal.ZERO) > 0 && obtained.compareTo(passMarks) < 0) {
                anyFail = true;
            }
        }

        double pct = totalMax.compareTo(BigDecimal.ZERO) > 0
                ? totalObtained.doubleValue() / totalMax.doubleValue() * 100 : 0;
        String overallGrade  = calcGradeFromScales(pct, gradeScales);
        String overallStatus = (anyFail || pct < 50) ? "Fail" : "Pass";

        // ── Overall Summary ───────────────────────────────────────────────────
        addSectionHeader(document, "OVERALL SUMMARY");
        PdfPTable summaryTable = new PdfPTable(4);
        summaryTable.setWidthPercentage(100);
        summaryTable.setWidths(new float[]{1, 1, 1, 1});

        Font boldFont  = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10);
        Font labelFont = FontFactory.getFont(FontFactory.HELVETICA, 8, BaseColor.GRAY);

        addSummaryLabelCell(summaryTable, "Subjects",   labelFont);
        addSummaryLabelCell(summaryTable, "Marks",      labelFont);
        addSummaryLabelCell(summaryTable, "Percentage", labelFont);
        addSummaryLabelCell(summaryTable, "Grade",      labelFont);

        addSummaryValueCell(summaryTable, String.valueOf(marksList.size()), boldFont);
        addSummaryValueCell(summaryTable, totalObtained.stripTrailingZeros().toPlainString()
                + "/" + totalMax.stripTrailingZeros().toPlainString(), boldFont);
        addSummaryValueCell(summaryTable, String.format("%.1f%%", pct), boldFont);
        addSummaryValueCell(summaryTable, overallGrade, boldFont);

        BaseColor statusBg = "Pass".equals(overallStatus)
                ? new BaseColor(40, 167, 69) : new BaseColor(220, 53, 69);
        PdfPCell statusCell = new PdfPCell(
                new Phrase(overallStatus, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, BaseColor.WHITE)));
        statusCell.setBackgroundColor(statusBg);
        statusCell.setColspan(4);
        statusCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        statusCell.setPadding(4);
        summaryTable.addCell(statusCell);

        document.add(summaryTable);
        document.add(new Paragraph("\n"));

        // ── Subject Details ───────────────────────────────────────────────────
        addSectionHeader(document, "SUBJECT DETAILS");
        PdfPTable subjectTable = new PdfPTable(8);
        subjectTable.setWidthPercentage(100);
        subjectTable.setWidths(new float[]{0.5f, 2.5f, 1f, 1f, 1.2f, 1f, 1f, 1.5f});

        Font headerFont   = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 9, BaseColor.WHITE);
        BaseColor tblBg   = new BaseColor(50, 50, 50);
        Font rowFont      = FontFactory.getFont(FontFactory.HELVETICA, 9);
        Font failFont     = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 9, new BaseColor(220, 53, 69));
        Font passMarkFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 9, new BaseColor(40, 167, 69));

        String[] headers = {"#", "Subject / Book", "Obtained", "Total", "Pass Marks", "Percentage", "Grade", "Status"};
        for (String h : headers) {
            PdfPCell hCell = new PdfPCell(new Phrase(h, headerFont));
            hCell.setBackgroundColor(tblBg);
            hCell.setPadding(4);
            hCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            subjectTable.addCell(hCell);
        }

        if (marksList.isEmpty()) {
            PdfPCell noDataCell = new PdfPCell(new Phrase("", rowFont));
            noDataCell.setColspan(8);
            noDataCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            noDataCell.setPadding(6);
            subjectTable.addCell(noDataCell);
        } else {
            int rowNum = 1;
            for (StudentExamMarksEntity m : marksList) {
                String subjectName = (m.getExamSubject() != null && m.getExamSubject().getSubject() != null)
                        ? m.getExamSubject().getSubject().getName() : "";
                BigDecimal obtained  = m.getObtainedMarks()  != null ? m.getObtainedMarks()  : BigDecimal.ZERO;
                BigDecimal maxMarks  = m.getExamSubject().getTotalMarks()   != null ? m.getExamSubject().getTotalMarks()   : BigDecimal.ZERO;
                BigDecimal passMarks = m.getExamSubject().getPassingMarks() != null ? m.getExamSubject().getPassingMarks() : BigDecimal.ZERO;
                double subPct = maxMarks.compareTo(BigDecimal.ZERO) > 0
                        ? obtained.doubleValue() / maxMarks.doubleValue() * 100 : 0;
                boolean passed = obtained.compareTo(passMarks) >= 0;
                String grade  = passed ? calcGradeFromScales(subPct, gradeScales) : "F";
                String status = passed ? "Pass" : "Fail";

                addSubjectRow(subjectTable,
                        String.valueOf(rowNum++),
                        subjectName,
                        obtained.stripTrailingZeros().toPlainString(),
                        maxMarks.stripTrailingZeros().toPlainString(),
                        passMarks.stripTrailingZeros().toPlainString(),
                        String.format("%.1f%%", subPct),
                        grade,
                        status,
                        rowFont, failFont, passMarkFont);
            }
        }

        document.add(subjectTable);
        document.add(new Paragraph("\n"));

        // ── Remarks & Signatures ──────────────────────────────────────────────
        addSectionHeader(document, "REMARKS");
        PdfPTable remarksTable = new PdfPTable(1);
        remarksTable.setWidthPercentage(100);
        PdfPCell remarksCell = new PdfPCell();
        remarksCell.setMinimumHeight(50);
        remarksTable.addCell(remarksCell);
        document.add(remarksTable);
        document.add(new Paragraph("\n\n"));

        Font declFont = FontFactory.getFont(FontFactory.HELVETICA, 8);
        PdfPTable signTable = new PdfPTable(3);
        signTable.setWidthPercentage(100);
        signTable.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        signTable.addCell(new Phrase("____________________\nClass Teacher", declFont));
        signTable.addCell(new Phrase("____________________\nPrincipal", declFont));
        signTable.addCell(new Phrase("____________________\nParent / Guardian", declFont));
        document.add(signTable);
    }

    // ── Grade helper ──────────────────────────────────────────────────────────
    private String calcGrade(double pct) {
        if (pct >= 90) return "A+";
        if (pct >= 80) return "A";
        if (pct >= 70) return "B+";
        if (pct >= 60) return "B";
        if (pct >= 50) return "C";
        if (pct >= 40) return "D";
        return "F";
    }

    private String calcGradeFromScales(double pct, List<GradeScaleEntity> gradeScales) {
        if (gradeScales == null || gradeScales.isEmpty()) {
            return calcGrade(pct);
        }
        BigDecimal pctVal = BigDecimal.valueOf(pct);
        for (GradeScaleEntity gs : gradeScales) {
            BigDecimal min = gs.getMinPercentage() != null ? gs.getMinPercentage() : BigDecimal.ZERO;
            BigDecimal max = gs.getMaxPercentage() != null ? gs.getMaxPercentage() : BigDecimal.ZERO;
            if (pctVal.compareTo(min) >= 0 && pctVal.compareTo(max) <= 0) {
                return gs.getGrade();
            }
        }
        // Fallback: search for first where pctVal >= min
        for (GradeScaleEntity gs : gradeScales) {
            BigDecimal min = gs.getMinPercentage() != null ? gs.getMinPercentage() : BigDecimal.ZERO;
            if (pctVal.compareTo(min) >= 0) {
                return gs.getGrade();
            }
        }
        return "F";
    }

    // ── Cell helpers ──────────────────────────────────────────────────────────
    private void addSummaryLabelCell(PdfPTable table, String text, Font font) {
        PdfPCell c = new PdfPCell(new Phrase(text, font));
        c.setHorizontalAlignment(Element.ALIGN_CENTER);
        c.setBorder(Rectangle.NO_BORDER);
        table.addCell(c);
    }

    private void addSummaryValueCell(PdfPTable table, String text, Font font) {
        PdfPCell c = new PdfPCell(new Phrase(text, font));
        c.setHorizontalAlignment(Element.ALIGN_CENTER);
        c.setBorder(Rectangle.NO_BORDER);
        table.addCell(c);
    }

    private void addSubjectRow(PdfPTable table, String num, String subject, String obtained,
                               String total, String passMarks, String percentage, String grade,
                               String status, Font rowFont, Font failFont, Font passMarkFont) {
        Font statusFont = status.equalsIgnoreCase("Fail") ? failFont : rowFont;

        PdfPCell c1 = new PdfPCell(new Phrase(num, rowFont));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER); c1.setPadding(4); table.addCell(c1);
        PdfPCell c2 = new PdfPCell(new Phrase(subject, rowFont));
        c2.setPadding(4); table.addCell(c2);
        PdfPCell c3 = new PdfPCell(new Phrase(obtained, rowFont));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER); c3.setPadding(4); table.addCell(c3);
        PdfPCell c4 = new PdfPCell(new Phrase(total, rowFont));
        c4.setHorizontalAlignment(Element.ALIGN_CENTER); c4.setPadding(4); table.addCell(c4);
        PdfPCell c5 = new PdfPCell(new Phrase(passMarks, passMarkFont));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER); c5.setPadding(4); table.addCell(c5);
        PdfPCell c6 = new PdfPCell(new Phrase(percentage, rowFont));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER); c6.setPadding(4); table.addCell(c6);
        PdfPCell c7 = new PdfPCell(new Phrase(grade, rowFont));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER); c7.setPadding(4); table.addCell(c7);
        PdfPCell c8 = new PdfPCell(new Phrase(status, statusFont));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER); c8.setPadding(4); table.addCell(c8);
    }

    private void addSectionHeader(Document document, String title) throws DocumentException {
        Font sectionFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, BaseColor.WHITE);
        BaseColor sectionBg = new BaseColor(31, 56, 100);
        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);
        PdfPCell cell = new PdfPCell(new Phrase(title, sectionFont));
        cell.setBackgroundColor(sectionBg);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setPadding(3);
        table.addCell(cell);
        document.add(table);
    }

    private void addLabelAndValue(PdfPTable table, String label, String value) {
        Font labelFont = FontFactory.getFont(FontFactory.HELVETICA, 9);
        PdfPCell labelCell = new PdfPCell(new Phrase(label, labelFont));
        labelCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(labelCell);
        PdfPCell valueCell = new PdfPCell(new Phrase(value, labelFont));
        table.addCell(valueCell);
    }

    private void addFullWidthRow(PdfPTable table, String label, String value) {
        Font labelFont = FontFactory.getFont(FontFactory.HELVETICA, 9);
        PdfPCell labelCell = new PdfPCell(new Phrase(label, labelFont));
        labelCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        labelCell.setMinimumHeight(20);
        table.addCell(labelCell);
        PdfPCell valueCell = new PdfPCell(new Phrase(value, labelFont));
        valueCell.setMinimumHeight(20);
        table.addCell(valueCell);
    }

    // ── Admission Form (unchanged) ────────────────────────────────────────────
    private void generateAdmissionForm(Document document) throws DocumentException {
        Font sectionFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, BaseColor.WHITE);
        BaseColor sectionBg = new BaseColor(31, 56, 100);

        PdfPTable titleTable = new PdfPTable(1);
        titleTable.setWidthPercentage(100);
        PdfPCell titleCell = new PdfPCell(new Phrase("Admission Form O Level", sectionFont));
        titleCell.setBackgroundColor(sectionBg);
        titleCell.setPadding(5);
        titleCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        titleTable.addCell(titleCell);
        document.add(titleTable);
        document.add(new Paragraph("\n"));

        addSectionHeader(document, "ADMISSION DETAILS");
        PdfPTable admTable = new PdfPTable(4);
        admTable.setWidthPercentage(100);
        admTable.setWidths(new float[]{1, 2, 1, 2});
        addLabelAndValue(admTable, "Date", "");
        addLabelAndValue(admTable, "Class Applied for", "Class X [ ] Class XI [ ]");
        document.add(admTable);
        document.add(new Paragraph("\n"));

        addSectionHeader(document, "STUDENT DETAILS");
        PdfPTable stdTable = new PdfPTable(2);
        stdTable.setWidthPercentage(100);
        stdTable.setWidths(new float[]{1, 3});
        addFullWidthRow(stdTable, "Family Name", "");
        addFullWidthRow(stdTable, "Name", "");
        document.add(stdTable);

        PdfPTable stdDetailsTable = new PdfPTable(4);
        stdDetailsTable.setWidthPercentage(100);
        stdDetailsTable.setWidths(new float[]{1, 1, 1, 1});
        addLabelAndValue(stdDetailsTable, "Date of Birth", "");
        addLabelAndValue(stdDetailsTable, "Gender", "Male [ ] Female [ ]");
        document.add(stdDetailsTable);

        PdfPTable langTable = new PdfPTable(4);
        langTable.setWidthPercentage(100);
        langTable.setWidths(new float[]{1, 2, 1, 1});
        addLabelAndValue(langTable, "Family Language", "");
        addLabelAndValue(langTable, "Nationality", "");
        document.add(langTable);

        PdfPTable emailTable = new PdfPTable(2);
        emailTable.setWidthPercentage(100);
        emailTable.setWidths(new float[]{1, 3});
        addFullWidthRow(emailTable, "Email", "");
        document.add(emailTable);
        document.add(new Paragraph("\n"));

        addSectionHeader(document, "PARENTS DETAILS");
        PdfPTable parentTable = new PdfPTable(2);
        parentTable.setWidthPercentage(100);
        parentTable.setWidths(new float[]{1, 3});
        addFullWidthRow(parentTable, "Father's Name", "");
        addFullWidthRow(parentTable, "CNIC", " [ ][ ][ ][ ][ ] - [ ][ ][ ][ ][ ][ ][ ] - [ ] ");
        addFullWidthRow(parentTable, "Business Address", "");
        addFullWidthRow(parentTable, "Residential Address", "");
        document.add(parentTable);

        PdfPTable parentContactTable = new PdfPTable(4);
        parentContactTable.setWidthPercentage(100);
        parentContactTable.setWidths(new float[]{1, 1, 1, 1});
        addLabelAndValue(parentContactTable, "Occupation", "");
        addLabelAndValue(parentContactTable, "Email", "");
        addLabelAndValue(parentContactTable, "Office Phone", "");
        addLabelAndValue(parentContactTable, "Mobile No", "");
        document.add(parentContactTable);

        document.add(new Paragraph("\n"));
        PdfPTable motherTable = new PdfPTable(2);
        motherTable.setWidthPercentage(100);
        motherTable.setWidths(new float[]{1, 3});
        addFullWidthRow(motherTable, "Mother's Name", "");
        addFullWidthRow(motherTable, "CNIC", " [ ][ ][ ][ ][ ] - [ ][ ][ ][ ][ ][ ][ ] - [ ] ");
        document.add(motherTable);

        document.add(new Paragraph("\n"));
        addSectionHeader(document, "EMERGENCY CONTACT DETAILS");
        PdfPTable emgTable = new PdfPTable(4);
        emgTable.setWidthPercentage(100);
        addLabelAndValue(emgTable, "Doctor's Name", "");
        addLabelAndValue(emgTable, "Phone", "");
        addLabelAndValue(emgTable, "Relative's Name", "");
        addLabelAndValue(emgTable, "Mobile", "");
        document.add(emgTable);

        Font declFont = FontFactory.getFont(FontFactory.HELVETICA, 8);
        document.add(new Paragraph("\n\n"));
        PdfPTable signTable = new PdfPTable(3);
        signTable.setWidthPercentage(100);
        signTable.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        signTable.addCell(new Phrase("____________________\nSignature of Applicant", declFont));
        signTable.addCell(new Phrase("____________________\nDate", declFont));
        signTable.addCell(new Phrase("____________________\nSignature of Parent/Guardian", declFont));
        document.add(signTable);
    }

    private void generateResultGazette(Document document, Long campusId, Long standardId, Long sectionId, Long examId, Long examTermId) throws DocumentException {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        InstituteEntity institute = instituteRepository.findById(orgId).orElse(null);
        CampusEntity campus = campusId != null ? campusRepository.findById(campusId).orElse(null) : null;
        StandardEntity standard = standardId != null ? standardRepository.findById(standardId).orElse(null) : null;
        SectionEntity section = sectionId != null ? sectionRepository.findById(sectionId).orElse(null) : null;
        ExamEntity exam = examId != null ? examRepository.findByIdAndDeletedFalse(examId).orElse(null) : null;

        String schoolName = institute != null ? institute.getName() : "SCHOOL SYSTEM";
        String campusName = campus != null ? campus.getCampusName() : "N/A";
        String standardName = standard != null ? standard.getStandardName() : "N/A";
        String sectionName = section != null ? section.getSectionName() : "N/A";
        String examName = exam != null ? exam.getName() : "N/A";
        String academicYear = (exam != null && exam.getExamTerm() != null && exam.getExamTerm().getAcademicYear() != null)
                ? exam.getExamTerm().getAcademicYear().getName() : "N/A";

        // Fetch marks matching standard/section/exam
        List<StudentExamMarksEntity> marksList = marksRepository.searchMarks(campusId, standardId, sectionId, examId, null);

        // Group marks by Student ID to find overall pass/fail status and students list
        Map<Long, List<StudentExamMarksEntity>> studentMarksMap = marksList.stream()
                .filter(m -> m.getStudent() != null)
                .collect(Collectors.groupingBy(m -> m.getStudent().getId()));

        // Fetch grade scales to construct the grading formula table
        List<GradeScaleEntity> gradeScales = gradeScaleRepository.findAllByOrgId(orgId);
        // Sort grade scales from highest to lowest range
        gradeScales.sort((a, b) -> b.getMinPercentage().compareTo(a.getMinPercentage()));

        // ================= PAGE 1: TITLE/COVER PAGE =================
        Font mainTitleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 28, BaseColor.DARK_GRAY);
        Font subtitleFont = FontFactory.getFont(FontFactory.HELVETICA, 16, BaseColor.GRAY);
        Font boldSubtitleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, BaseColor.DARK_GRAY);
        Font bodyBold = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.DARK_GRAY);

        document.add(new Paragraph("\n\n\n"));
        Paragraph pBoard = new Paragraph("BOARD OF", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 32, BaseColor.DARK_GRAY));
        pBoard.setAlignment(Element.ALIGN_CENTER);
        document.add(pBoard);

        Paragraph pSchool = new Paragraph(schoolName.toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 22, BaseColor.DARK_GRAY));
        pSchool.setAlignment(Element.ALIGN_CENTER);
        document.add(pSchool);

        Paragraph pCampus = new Paragraph("CAMPUS: " + campusName.toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.GRAY));
        pCampus.setAlignment(Element.ALIGN_CENTER);
        document.add(pCampus);
        document.add(new Paragraph("\n\n"));

        // Logo in the center
        if (institute != null && institute.getLogo() != null) {
            try {
                Image logo = Image.getInstance(institute.getLogo());
                logo.scaleToFit(140, 140);
                logo.setAlignment(Element.ALIGN_CENTER);
                document.add(logo);
            } catch (Exception e) {
                // skip logo
            }
        }
        document.add(new Paragraph("\n\n\n"));

        Paragraph pGazette = new Paragraph("RESULT GAZETTE", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 26, new BaseColor(31, 56, 100)));
        pGazette.setAlignment(Element.ALIGN_CENTER);
        document.add(pGazette);

        Paragraph pDetails1 = new Paragraph("CLASS: " + standardName.toUpperCase() + "  |  SECTION: " + sectionName.toUpperCase(), boldSubtitleFont);
        pDetails1.setAlignment(Element.ALIGN_CENTER);
        document.add(pDetails1);

        Paragraph pDetails2 = new Paragraph("EXAMINATION: " + examName.toUpperCase() + " (" + academicYear + ")", boldSubtitleFont);
        pDetails2.setAlignment(Element.ALIGN_CENTER);
        document.add(pDetails2);

        document.newPage();

        // ================= PAGE 2: GRADING FORMULA & PASS PERCENTAGE =================
        Paragraph pHeader2 = new Paragraph("MAXIMUM MARKS GENERAL / SCIENCE GROUP", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
        pHeader2.setAlignment(Element.ALIGN_LEFT);
        document.add(pHeader2);
        document.add(new Paragraph("\n"));

        // Get subjects from the exam
        BigDecimal examTotalMaxMarks = BigDecimal.ZERO;
        if (!marksList.isEmpty()) {
            Map<Long, BigDecimal> subjectMaxMarksMap = marksList.stream()
                    .filter(m -> m.getExamSubject() != null)
                    .collect(Collectors.toMap(
                            m -> m.getExamSubject().getId(),
                            m -> m.getExamSubject().getTotalMarks() != null ? m.getExamSubject().getTotalMarks() : BigDecimal.ZERO,
                            (existing, replacement) -> existing
                    ));
            for (BigDecimal val : subjectMaxMarksMap.values()) {
                examTotalMaxMarks = examTotalMaxMarks.add(val);
            }
        }
        if (examTotalMaxMarks.compareTo(BigDecimal.ZERO) == 0) {
            examTotalMaxMarks = new BigDecimal("100");
        }

        Paragraph pPart = new Paragraph("Part System = " + examTotalMaxMarks.stripTrailingZeros().toPlainString(), FontFactory.getFont(FontFactory.HELVETICA, 10));
        pPart.setAlignment(Element.ALIGN_LEFT);
        document.add(pPart);
        document.add(new Paragraph("\n"));

        Paragraph pGradingFormula = new Paragraph("GRADING FORMULA", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
        document.add(pGradingFormula);
        document.add(new Paragraph("\n"));

        // Grade scale table
        PdfPTable gradeTable = new PdfPTable(4);
        gradeTable.setWidthPercentage(100);
        gradeTable.setWidths(new float[]{3f, 3f, 2f, 3f});
        
        Font tblHeaderFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, BaseColor.DARK_GRAY);
        Font tblBodyFont = FontFactory.getFont(FontFactory.HELVETICA, 9);

        addCellWithBg(gradeTable, "Percentage of Marks", tblHeaderFont, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER);
        addCellWithBg(gradeTable, "Marks Range", tblHeaderFont, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER);
        addCellWithBg(gradeTable, "Grade", tblHeaderFont, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER);
        addCellWithBg(gradeTable, "Remarks", tblHeaderFont, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER);

        for (int i = 0; i < gradeScales.size(); i++) {
            GradeScaleEntity gs = gradeScales.get(i);
            BigDecimal minPct = gs.getMinPercentage();
            BigDecimal maxPct = gs.getMaxPercentage();
            
            BigDecimal minMarks = minPct.multiply(examTotalMaxMarks).divide(new BigDecimal("100"));
            BigDecimal maxMarks = maxPct.multiply(examTotalMaxMarks).divide(new BigDecimal("100"));
            
            String pctStr;
            String marksStr;
            
            boolean isLowest = (i == gradeScales.size() - 1);
            boolean isHighest = (i == 0);
            
            if (isLowest) {
                pctStr = "Below " + maxPct.stripTrailingZeros().toPlainString() + "% to minimum pass marks";
                marksStr = "Below " + maxMarks.stripTrailingZeros().toPlainString() + " to minimum pass marks";
            } else if (isHighest) {
                pctStr = minPct.stripTrailingZeros().toPlainString() + "% and above";
                marksStr = minMarks.stripTrailingZeros().toPlainString() + " or more marks";
            } else {
                pctStr = minPct.stripTrailingZeros().toPlainString() + "% and above but below " + maxPct.stripTrailingZeros().toPlainString() + "%";
                marksStr = minMarks.stripTrailingZeros().toPlainString() + " to " + maxMarks.stripTrailingZeros().toPlainString() + " marks";
            }

            addCellWithBg(gradeTable, pctStr, tblBodyFont, BaseColor.WHITE, Element.ALIGN_LEFT);
            addCellWithBg(gradeTable, marksStr, tblBodyFont, BaseColor.WHITE, Element.ALIGN_LEFT);
            addCellWithBg(gradeTable, gs.getGrade(), tblBodyFont, BaseColor.WHITE, Element.ALIGN_CENTER);
            addCellWithBg(gradeTable, gs.getRemarks(), tblBodyFont, BaseColor.WHITE, Element.ALIGN_LEFT);
        }
        document.add(gradeTable);
        document.add(new Paragraph("\n\n\n"));

        // PASS PERCENTAGE Section
        Paragraph pPassPercentageTitle = new Paragraph("PASS PERCENTAGE", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
        pPassPercentageTitle.setAlignment(Element.ALIGN_LEFT);
        document.add(pPassPercentageTitle);
        document.add(new Paragraph("\n"));

        int totalApplied = studentMarksMap.size();
        int totalAppeared = 0;
        int totalPassed = 0;

        for (List<StudentExamMarksEntity> studentMarks : studentMarksMap.values()) {
            if (studentMarks.isEmpty()) continue;
            totalAppeared++;
            
            boolean studentPassed = true;
            BigDecimal studentObtained = BigDecimal.ZERO;
            BigDecimal studentMax = BigDecimal.ZERO;
            for (StudentExamMarksEntity m : studentMarks) {
                BigDecimal obtained = m.getObtainedMarks() != null ? m.getObtainedMarks() : BigDecimal.ZERO;
                BigDecimal passMarks = m.getExamSubject().getPassingMarks() != null ? m.getExamSubject().getPassingMarks() : BigDecimal.ZERO;
                BigDecimal max = m.getExamSubject().getTotalMarks() != null ? m.getExamSubject().getTotalMarks() : BigDecimal.ZERO;
                studentObtained = studentObtained.add(obtained);
                studentMax = studentMax.add(max);

                if (obtained.compareTo(passMarks) < 0) {
                    studentPassed = false;
                }
            }
            double overallPct = studentMax.compareTo(BigDecimal.ZERO) > 0 ? (studentObtained.doubleValue() / studentMax.doubleValue() * 100) : 0;
            if (overallPct < 50) {
                studentPassed = false;
            }
            if (studentPassed) {
                totalPassed++;
            }
        }

        double passPercentage = totalAppeared > 0 ? ((double) totalPassed / totalAppeared * 100) : 0.0;

        PdfPTable statsTable = new PdfPTable(4);
        statsTable.setWidthPercentage(100);
        statsTable.setWidths(new float[]{1f, 1f, 1f, 1f});

        addCellWithBg(statsTable, "Total Candidates Applied", tblHeaderFont, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER);
        addCellWithBg(statsTable, "Candidates Appeared", tblHeaderFont, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER);
        addCellWithBg(statsTable, "Passed", tblHeaderFont, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER);
        addCellWithBg(statsTable, "Pass Percentage", tblHeaderFont, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER);

        addCellWithBg(statsTable, String.valueOf(totalApplied), tblBodyFont, BaseColor.WHITE, Element.ALIGN_CENTER);
        addCellWithBg(statsTable, String.valueOf(totalAppeared), tblBodyFont, BaseColor.WHITE, Element.ALIGN_CENTER);
        addCellWithBg(statsTable, String.valueOf(totalPassed), tblBodyFont, BaseColor.WHITE, Element.ALIGN_CENTER);
        addCellWithBg(statsTable, String.format("%.2f%%", passPercentage), tblBodyFont, BaseColor.WHITE, Element.ALIGN_CENTER);
        
        document.add(statsTable);
        document.add(new Paragraph("\n\n\n\n\n"));

        PdfPTable signTable2 = new PdfPTable(1);
        signTable2.setWidthPercentage(100);
        PdfPCell signCell = new PdfPCell(new Phrase("Controller of Examinations\n" + schoolName + "\n" + campusName + " Campus", tblBodyFont));
        signCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        signCell.setBorder(Rectangle.NO_BORDER);
        signTable2.addCell(signCell);
        document.add(signTable2);

        document.newPage();

        // ================= PAGE 3: SUBJECT-WISE PASS PERCENTAGE =================
        Paragraph pSubjectTitle = new Paragraph(schoolName, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14));
        pSubjectTitle.setAlignment(Element.ALIGN_CENTER);
        document.add(pSubjectTitle);

        Paragraph pSubjectSubtitle = new Paragraph("Statement Showing Subject Wise Pass Percentage of the " + standardName + " " + sectionName + "\n" + examName + " (" + academicYear + ")", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10));
        pSubjectSubtitle.setAlignment(Element.ALIGN_CENTER);
        document.add(pSubjectSubtitle);
        document.add(new Paragraph("\n"));

        PdfPTable subPctTable = new PdfPTable(5);
        subPctTable.setWidthPercentage(100);
        subPctTable.setWidths(new float[]{1f, 4f, 2f, 2f, 2f});

        addCellWithBg(subPctTable, "S.#", tblHeaderFont, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER);
        addCellWithBg(subPctTable, "SUBJECT / PRACTICAL", tblHeaderFont, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER);
        addCellWithBg(subPctTable, "Appeared", tblHeaderFont, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER);
        addCellWithBg(subPctTable, "Passed", tblHeaderFont, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER);
        addCellWithBg(subPctTable, "Pass %", tblHeaderFont, BaseColor.LIGHT_GRAY, Element.ALIGN_CENTER);

        Map<String, List<StudentExamMarksEntity>> marksBySubject = marksList.stream()
                .filter(m -> m.getExamSubject() != null && m.getExamSubject().getSubject() != null)
                .collect(Collectors.groupingBy(m -> m.getExamSubject().getSubject().getName()));

        int subIndex = 1;
        for (Map.Entry<String, List<StudentExamMarksEntity>> entry : marksBySubject.entrySet()) {
            String subjectTitle = entry.getKey();
            List<StudentExamMarksEntity> subMarks = entry.getValue();

            int subAppeared = subMarks.size();
            int subPassed = 0;
            for (StudentExamMarksEntity m : subMarks) {
                BigDecimal obtained = m.getObtainedMarks() != null ? m.getObtainedMarks() : BigDecimal.ZERO;
                BigDecimal passing = m.getExamSubject().getPassingMarks() != null ? m.getExamSubject().getPassingMarks() : BigDecimal.ZERO;
                if (obtained.compareTo(passing) >= 0) {
                    subPassed++;
                }
            }
            double subPassPct = subAppeared > 0 ? ((double) subPassed / subAppeared * 100) : 0.0;

            addCellWithBg(subPctTable, String.valueOf(subIndex++), tblBodyFont, BaseColor.WHITE, Element.ALIGN_CENTER);
            addCellWithBg(subPctTable, subjectTitle, tblBodyFont, BaseColor.WHITE, Element.ALIGN_LEFT);
            addCellWithBg(subPctTable, String.valueOf(subAppeared), tblBodyFont, BaseColor.WHITE, Element.ALIGN_CENTER);
            addCellWithBg(subPctTable, String.valueOf(subPassed), tblBodyFont, BaseColor.WHITE, Element.ALIGN_CENTER);
            addCellWithBg(subPctTable, String.format("%.2f%%", subPassPct), tblBodyFont, BaseColor.WHITE, Element.ALIGN_CENTER);
        }
        document.add(subPctTable);

        document.newPage();

        // ================= PAGE 4: STUDENT RESULTS LISTING =================
        Paragraph pListingTitle = new Paragraph("Secondary School Certificate " + standardName + " " + sectionName + "\n" + examName + " (" + academicYear + ") - Result Listing", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
        pListingTitle.setAlignment(Element.ALIGN_CENTER);
        document.add(pListingTitle);
        document.add(new Paragraph("\n"));

        PdfPTable listingTable = new PdfPTable(6);
        listingTable.setWidthPercentage(100);
        float[] widths = new float[]{2f, 4f, 1.8f, 2.5f, 1.2f, 2f};
        listingTable.setWidths(widths);

        Font listHeaderFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 9, BaseColor.WHITE);
        Font listBodyFont = FontFactory.getFont(FontFactory.HELVETICA, 9);
        BaseColor headerBg = new BaseColor(31, 56, 100);

        addCellWithBg(listingTable, "ROLL NO", listHeaderFont, headerBg, Element.ALIGN_CENTER);
        addCellWithBg(listingTable, "NAME", listHeaderFont, headerBg, Element.ALIGN_CENTER);
        addCellWithBg(listingTable, "NUMBER", listHeaderFont, headerBg, Element.ALIGN_CENTER);
        addCellWithBg(listingTable, "STATUS", listHeaderFont, headerBg, Element.ALIGN_CENTER);
        addCellWithBg(listingTable, "GRADE", listHeaderFont, headerBg, Element.ALIGN_CENTER);
        addCellWithBg(listingTable, "PERCENTAGE", listHeaderFont, headerBg, Element.ALIGN_CENTER);

        List<Map.Entry<Long, List<StudentExamMarksEntity>>> sortedStudentsList = new ArrayList<>(studentMarksMap.entrySet());
        sortedStudentsList.sort((a, b) -> {
            String codeA = a.getValue().get(0).getStudent().getStudentCode();
            String codeB = b.getValue().get(0).getStudent().getStudentCode();
            return codeA.compareTo(codeB);
        });

        for (Map.Entry<Long, List<StudentExamMarksEntity>> studentEntry : sortedStudentsList) {
            StudentEntity student = studentEntry.getValue().get(0).getStudent();
            List<StudentExamMarksEntity> marks = studentEntry.getValue();

            BigDecimal studentObtained = BigDecimal.ZERO;
            BigDecimal studentMax = BigDecimal.ZERO;
            boolean passed = true;
            List<String> failedSubjects = new ArrayList<>();
            
            for (StudentExamMarksEntity m : marks) {
                BigDecimal obtained = m.getObtainedMarks() != null ? m.getObtainedMarks() : BigDecimal.ZERO;
                BigDecimal pass = m.getExamSubject().getPassingMarks() != null ? m.getExamSubject().getPassingMarks() : BigDecimal.ZERO;
                BigDecimal max = m.getExamSubject().getTotalMarks() != null ? m.getExamSubject().getTotalMarks() : BigDecimal.ZERO;
                
                studentObtained = studentObtained.add(obtained);
                studentMax = studentMax.add(max);

                if (obtained.compareTo(pass) < 0) {
                    passed = false;
                    failedSubjects.add(m.getExamSubject().getSubject() != null ? m.getExamSubject().getSubject().getName().substring(0, Math.min(4, m.getExamSubject().getSubject().getName().length())) : "SUB");
                }
            }

            double overallPct = studentMax.compareTo(BigDecimal.ZERO) > 0 ? (studentObtained.doubleValue() / studentMax.doubleValue() * 100) : 0;
            String overallGrade = calcGradeFromScales(overallPct, gradeScales);

            if (overallPct < 50) {
                passed = false;
            }

            String rollText = student.getStudentCode() != null ? student.getStudentCode() : "N/A";
            String nameText = student.getFullName() != null ? student.getFullName().toUpperCase() : "N/A";
            String numberText = studentObtained.stripTrailingZeros().toPlainString();
            
            String statusText;
            if (passed) {
                statusText = "PASS";
            } else {
                if (!failedSubjects.isEmpty()) {
                    statusText = "FAIL (" + String.join(",", failedSubjects) + ")";
                } else {
                    statusText = "FAIL";
                }
            }
            
            String gradeText = passed ? overallGrade : "F";
            String percentageText = String.format("%.2f%%", overallPct);

            addCellWithBg(listingTable, rollText, listBodyFont, BaseColor.WHITE, Element.ALIGN_CENTER);
            addCellWithBg(listingTable, nameText, listBodyFont, BaseColor.WHITE, Element.ALIGN_LEFT);
            addCellWithBg(listingTable, numberText, listBodyFont, BaseColor.WHITE, Element.ALIGN_CENTER);
            addCellWithBg(listingTable, statusText, listBodyFont, BaseColor.WHITE, Element.ALIGN_CENTER);
            addCellWithBg(listingTable, gradeText, listBodyFont, BaseColor.WHITE, Element.ALIGN_CENTER);
            addCellWithBg(listingTable, percentageText, listBodyFont, BaseColor.WHITE, Element.ALIGN_CENTER);
        }
        document.add(listingTable);
    }

    private void addCellWithBg(PdfPTable table, String text, Font font, BaseColor bgColor, int alignment) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(bgColor);
        cell.setHorizontalAlignment(alignment);
        cell.setPadding(3);
        table.addCell(cell);
    }
}