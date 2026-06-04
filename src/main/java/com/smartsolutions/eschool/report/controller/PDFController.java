package com.smartsolutions.eschool.report.controller;

import com.smartsolutions.eschool.report.service.PDFService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
@Tag(name = "Reports", description = "Endpoints for generating and downloading reports/forms")
public class PDFController {

    private final PDFService pdfService;

    @GetMapping("/download")
    @Operation(summary = "Download PDF Document", description = "Generates and downloads a PDF document based on docType (e.g., ADMISSION_FORM)")
    public ResponseEntity<byte[]> downloadPdf(@RequestParam String docType) {
        byte[] pdfContent = pdfService.generatePdf(docType);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        String filename = docType.toLowerCase() + ".pdf";
        headers.setContentDispositionFormData("attachment", filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        return new ResponseEntity<>(pdfContent, headers, HttpStatus.OK);
    }
}
