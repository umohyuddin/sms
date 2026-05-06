package com.smartsolutions.eschool.report.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import com.smartsolutions.eschool.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PDFService {

    private final InstituteRepository instituteRepository;

    public byte[] generatePdf(String docType) {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        Optional<InstituteEntity> instituteOpt = instituteRepository.findById(orgId);
        InstituteEntity institute = instituteOpt.orElse(null);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4, 36, 36, 36, 36);

        try {
            PdfWriter.getInstance(document, baos);
            document.open();

            // Add Header
            addHeader(document, institute);

            if ("ADMISSION_FORM".equalsIgnoreCase(docType)) {
                generateAdmissionForm(document);
            } else {
                document.add(new Paragraph("Document Type not supported: " + docType));
            }

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return baos.toByteArray();
    }

    private void addHeader(Document document, InstituteEntity institute) throws DocumentException {
        PdfPTable headerTable = new PdfPTable(2);
        headerTable.setWidthPercentage(100);
        headerTable.setWidths(new float[]{1, 3});

        // Logo
        PdfPCell logoCell = new PdfPCell();
        if (institute != null && institute.getLogo() != null) {
            try {
                Image logo = Image.getInstance(institute.getLogo());
                logo.scaleToFit(80, 80);
                logoCell.addElement(logo);
            } catch (Exception e) {
                // Skip logo if error
            }
        }
        logoCell.setBorder(Rectangle.NO_BORDER);
        headerTable.addCell(logoCell);

        // School Info
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

    private void generateAdmissionForm(Document document) throws DocumentException {
        Font sectionFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, BaseColor.WHITE);
        BaseColor sectionBg = new BaseColor(31, 56, 100); // Dark Blue

        // Admission Form Title Bar
        PdfPTable titleTable = new PdfPTable(1);
        titleTable.setWidthPercentage(100);
        PdfPCell titleCell = new PdfPCell(new Phrase("Admission Form O Level", sectionFont));
        titleCell.setBackgroundColor(sectionBg);
        titleCell.setPadding(5);
        titleCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        titleTable.addCell(titleCell);
        document.add(titleTable);
        document.add(new Paragraph("\n"));

        // PAGE 1
        // ADMISSION DETAILS
        addSectionHeader(document, "ADMISSION DETAILS");
        PdfPTable admTable = new PdfPTable(4);
        admTable.setWidthPercentage(100);
        admTable.setWidths(new float[]{1, 2, 1, 2});
        addLabelAndValue(admTable, "Date", "");
        addLabelAndValue(admTable, "Class Applied for", "Class X [ ] Class XI [ ]");
        document.add(admTable);
        document.add(new Paragraph("\n"));

        // STUDENT DETAILS
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

        // PARENTS DETAILS
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
        // SIBLINGS DETAILS
        addSectionHeader(document, "SIBLINGS DETAILS (Brothers & Sisters)");
        PdfPTable siblingTable = new PdfPTable(6);
        siblingTable.setWidthPercentage(100);
        siblingTable.setWidths(new float[]{2, 2, 1, 1, 1, 1});
        addSiblingRow(siblingTable, "1. Name", "Gender", "M [ ] F [ ]", "Class", "Age");
        addSiblingRow(siblingTable, "   School", "", "", "", "");
        document.add(siblingTable);
        document.add(new Paragraph("\n"));

        // EMERGENCY CONTACT DETAILS
        addSectionHeader(document, "EMERGENCY CONTACT DETAILS");
        PdfPTable emgTable = new PdfPTable(4);
        emgTable.setWidthPercentage(100);
        addLabelAndValue(emgTable, "Doctor's Name", "");
        addLabelAndValue(emgTable, "Phone", "");
        addLabelAndValue(emgTable, "Relative's Name", "");
        addLabelAndValue(emgTable, "Mobile", "");
        document.add(emgTable);

        document.newPage(); // PAGE 2
        
        // PREVIOUS SCHOOLING
        addSectionHeader(document, "PREVIOUS SCHOOLING");
        PdfPTable prevSchoolTable = new PdfPTable(4);
        prevSchoolTable.setWidthPercentage(100);
        prevSchoolTable.setWidths(new float[]{2, 3, 1, 1});
        addPrevSchoolRow(prevSchoolTable, "School Attended", "Address", "From", "To");
        addPrevSchoolRow(prevSchoolTable, "1.", "", "", "");
        addPrevSchoolRow(prevSchoolTable, "2.", "", "", "");
        document.add(prevSchoolTable);
        document.add(new Paragraph("\n"));

        // SPORTS
        addSectionHeader(document, "SPORTS");
        addTextBox(document, "Does the applicant have a special interest in sports or games? Has he/she ever played for a school team?");
        document.add(new Paragraph("\n"));

        // INTEREST / HOBBIES
        addSectionHeader(document, "INTEREST / HOBBIES");
        addTextBox(document, "Please list any particular hobby or interest.");
        document.add(new Paragraph("\n"));

        // CO-CURRICULAR ACTIVITIES
        addSectionHeader(document, "CO-CURRICULAR ACTIVITIES");
        addTextBox(document, "Please mark tick (V) or give details if you are able to contribute to the school in any of the following ways:");
        document.add(new Paragraph("\n"));

        // HEALTH
        addSectionHeader(document, "HEALTH");
        PdfPTable healthTable = new PdfPTable(3);
        healthTable.setWidthPercentage(100);
        healthTable.setWidths(new float[]{5, 1, 1});
        addHealthRow(healthTable, "Does the applicant have any health problems which might influence his/her performance in the classroom or during games?");
        addHealthRow(healthTable, "Has the applicant received any psychological treatment?");
        addHealthRow(healthTable, "Does the applicant have a learning deficiency?");
        document.add(healthTable);
        document.add(new Paragraph("\n"));

        // CHECK LIST OF DOCUMENTS
        addSectionHeader(document, "CHECK LIST OF DOCUMENTS");
        PdfPTable checkListTable = new PdfPTable(4);
        checkListTable.setWidthPercentage(100);
        addCheckListRow(checkListTable, "Last two Report Cards", "Awards / Certificates");
        addCheckListRow(checkListTable, "Birth Certificate (copy)", "Leaving Certificate");
        addCheckListRow(checkListTable, "Photographs x 4", "");
        document.add(checkListTable);
        document.add(new Paragraph("\n"));

        // DECLARATION
        addSectionHeader(document, "Declaration");
        Font declFont = FontFactory.getFont(FontFactory.HELVETICA, 8);
        Paragraph decl = new Paragraph("I/We do hereby declare that all the details provided above are true. If any misinformation is found at any stage of the applicant's study, his/her registration may be cancelled and any action taken by the school accepted by me/us. We also agree to abide by all existing rules and regulations of the school and those that may be framed from time to time.", declFont);
        document.add(decl);
        document.add(new Paragraph("\n\n"));

        PdfPTable signTable = new PdfPTable(3);
        signTable.setWidthPercentage(100);
        signTable.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        signTable.addCell(new Phrase("____________________\nSignature of Applicant", declFont));
        signTable.addCell(new Phrase("____________________\nDate", declFont));
        signTable.addCell(new Phrase("____________________\nSignature of Parent/Guardian", declFont));
        document.add(signTable);
    }

    private void addSiblingRow(PdfPTable table, String label1, String label2, String val2, String label3, String label4) {
        Font f = FontFactory.getFont(FontFactory.HELVETICA, 8);
        PdfPCell c1 = new PdfPCell(new Phrase(label1, f)); c1.setBackgroundColor(BaseColor.LIGHT_GRAY); table.addCell(c1);
        table.addCell(new Phrase("", f));
        PdfPCell c2 = new PdfPCell(new Phrase(label2, f)); c2.setBackgroundColor(BaseColor.LIGHT_GRAY); table.addCell(c2);
        table.addCell(new Phrase(val2, f));
        PdfPCell c3 = new PdfPCell(new Phrase(label3, f)); c3.setBackgroundColor(BaseColor.LIGHT_GRAY); table.addCell(c3);
        table.addCell(new Phrase("", f));
    }

    private void addPrevSchoolRow(PdfPTable table, String c1, String c2, String c3, String c4) {
        Font f = FontFactory.getFont(FontFactory.HELVETICA, 8);
        PdfPCell cell1 = new PdfPCell(new Phrase(c1, f)); cell1.setBackgroundColor(BaseColor.LIGHT_GRAY); table.addCell(cell1);
        table.addCell(new Phrase(c2, f));
        table.addCell(new Phrase(c3, f));
        table.addCell(new Phrase(c4, f));
    }

    private void addTextBox(Document document, String prompt) throws DocumentException {
        Font f = FontFactory.getFont(FontFactory.HELVETICA, 8);
        document.add(new Paragraph(prompt, f));
        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);
        PdfPCell cell = new PdfPCell();
        cell.setMinimumHeight(50);
        table.addCell(cell);
        document.add(table);
    }

    private void addHealthRow(PdfPTable table, String question) {
        Font f = FontFactory.getFont(FontFactory.HELVETICA, 8);
        table.addCell(new Phrase(question, f));
        table.addCell(new Phrase("Yes [ ]", f));
        table.addCell(new Phrase("No [ ]", f));
    }

    private void addCheckListRow(PdfPTable table, String item1, String item2) {
        Font f = FontFactory.getFont(FontFactory.HELVETICA, 8);
        table.addCell(new Phrase(item1, f));
        table.addCell(new Phrase("[ ]", f));
        table.addCell(new Phrase(item2, f));
        table.addCell(new Phrase("[ ]", f));
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
}
