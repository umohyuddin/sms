package com.smartsolutions.eschool.global.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class UploadUtil {
    public static final String UPLOAD_DIR = "uploads/profile-photos/";

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
}
