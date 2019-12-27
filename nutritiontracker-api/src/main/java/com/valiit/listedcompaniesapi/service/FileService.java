package com.valiit.listedcompaniesapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private Path getUploadDir() {
        return Paths.get(this.uploadDir).toAbsolutePath().normalize();
    }

    public String storeFile(MultipartFile file) throws IOException {
        String fileName = generateFileName(file);
        Path targetLocation = this.getUploadDir().resolve(fileName);
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        return fileName;
    }

    public Resource loadFileAsResource(String fileName) throws MalformedURLException {
        Path filePath = this.getUploadDir().resolve(fileName).normalize();
        return new UrlResource(filePath.toUri());
    }

    private String generateFileName(MultipartFile inputFile) {
        String fileName = StringUtils.cleanPath(inputFile.getOriginalFilename());
        String extension = "";
        int i = fileName.lastIndexOf(".");
        if (i > 0) {
            extension = fileName.substring(i);
        }
        return UUID.randomUUID().toString() + extension;
    }
}
