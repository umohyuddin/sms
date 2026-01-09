package com.smartsolutions.eschool.global.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class UploadUtil {
    public static final String UPLOAD_DIR = "uploads/profile-photos/";
    public static final String EMPLOYEE_UPLOAD_DIR = "uploads/";

    public static String saveProfilePhoto(Long employeeId, MultipartFile file) {

        try {
            Files.createDirectories(Paths.get(UPLOAD_DIR));
            String originalFileName = Objects.requireNonNull(file.getOriginalFilename()).replaceAll("\\s+", "_");
            String fileName = employeeId + "_" + System.currentTimeMillis() + "_" + originalFileName;
            Path filePath = Paths.get(UPLOAD_DIR, fileName);

            Files.write(filePath, file.getBytes());
            return filePath.toString();

        } catch (IOException e) {
            throw new RuntimeException("Failed to upload profile photo", e);
        }
    }

    public static String saveEmployeeDocument(Long employeeId, String docKey, MultipartFile file) throws IOException {
        String uploadDir = EMPLOYEE_UPLOAD_DIR + "/employee_" + employeeId + "/documents";
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Remove spaces from original filename
        String originalFileName = Objects.requireNonNull(file.getOriginalFilename()).replaceAll("\\s+", "_");

        String filename = docKey + "_" + System.currentTimeMillis() + "_" + originalFileName;
        String filePath = Paths.get(uploadDir, filename).toString();

        Files.write(Paths.get(filePath), file.getBytes());

        return filePath;
    }

    public static String saveStudentDocument(Long employeeId, String docKey, MultipartFile file) throws IOException {
        String uploadDir = EMPLOYEE_UPLOAD_DIR + "/students_" + employeeId + "/documents";
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Remove spaces from original filename
        String originalFileName = Objects.requireNonNull(file.getOriginalFilename()).replaceAll("\\s+", "_");

        String filename = docKey + "_" + System.currentTimeMillis() + "_" + originalFileName;
        String filePath = Paths.get(uploadDir, filename).toString();

        Files.write(Paths.get(filePath), file.getBytes());

        return filePath;
    }


}
