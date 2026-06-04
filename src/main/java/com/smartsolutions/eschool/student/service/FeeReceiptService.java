package com.smartsolutions.eschool.student.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.smartsolutions.eschool.student.model.StudentFeePaymentEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public class FeeReceiptService {

    public byte[] generateReceiptPdf(StudentFeePaymentEntity payment) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            // Fonts
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
            Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 11);

            // Title
            Paragraph title = new Paragraph("FEE PAYMENT RECEIPT", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(20);
            document.add(title);

            // Receipt Info Table
            PdfPTable infoTable = new PdfPTable(2);
            infoTable.setWidthPercentage(100);
            infoTable.setSpacingAfter(20);

            infoTable.addCell(createCell("Receipt No:", headerFont, false));
            infoTable.addCell(createCell(payment.getReceiptNumber(), normalFont, false));
            infoTable.addCell(createCell("Date:", headerFont, false));
            infoTable.addCell(createCell(payment.getPaymentDate().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")), normalFont, false));
            infoTable.addCell(createCell("Student:", headerFont, false));
            infoTable.addCell(createCell(payment.getStudent().getFirstName() + " " + payment.getStudent().getLastName(), normalFont, false));
            infoTable.addCell(createCell("Academic Year:", headerFont, false));
            infoTable.addCell(createCell(payment.getAcademicYear().getName(), normalFont, false));

            document.add(infoTable);

            // Payment Details Table
            PdfPTable detailsTable = new PdfPTable(2);
            detailsTable.setWidthPercentage(100);
            detailsTable.setSpacingAfter(20);
            
            detailsTable.addCell(createCell("Payment Month:", headerFont, true));
            detailsTable.addCell(createCell(payment.getPaymentMonth() + " " + payment.getPaymentYear(), normalFont, true));
            
            detailsTable.addCell(createCell("Amount Paid:", headerFont, true));
            detailsTable.addCell(createCell(payment.getAmountPaid().toString(), normalFont, true));
            
            if (payment.getLateFeePaid() != null && payment.getLateFeePaid().compareTo(BigDecimal.ZERO) > 0) {
                detailsTable.addCell(createCell("Late Fee Paid:", headerFont, true));
                detailsTable.addCell(createCell(payment.getLateFeePaid().toString(), normalFont, true));
            }
            
            if (payment.getTaxPaid() != null && payment.getTaxPaid().compareTo(BigDecimal.ZERO) > 0) {
                detailsTable.addCell(createCell("Tax Paid:", headerFont, true));
                detailsTable.addCell(createCell(payment.getTaxPaid().toString(), normalFont, true));
            }
            
            detailsTable.addCell(createCell("Payment Mode:", headerFont, true));
            detailsTable.addCell(createCell(payment.getPaymentMode().toString(), normalFont, true));

            BigDecimal total = payment.getAmountPaid()
                    .add(payment.getLateFeePaid() != null ? payment.getLateFeePaid() : BigDecimal.ZERO)
                    .add(payment.getTaxPaid() != null ? payment.getTaxPaid() : BigDecimal.ZERO);
            detailsTable.addCell(createCell("TOTAL PAID:", headerFont, true));
            detailsTable.addCell(createCell(total.toString(), headerFont, true));

            document.add(detailsTable);

            // Footer
            Paragraph footer = new Paragraph("\n\nThis is a computer generated receipt.", normalFont);
            footer.setAlignment(Element.ALIGN_CENTER);
            document.add(footer);

            document.close();
        } catch (DocumentException e) {
            log.error("Error generating PDF receipt", e);
        }

        return out.toByteArray();
    }

    private PdfPCell createCell(String text, Font font, boolean border) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        if (!border) {
            cell.setBorder(Rectangle.NO_BORDER);
        }
        cell.setPadding(5);
        return cell;
    }
}
