package com.smartsolutions.eschool.global.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "employee")
@Component
public class EmployeeDocumentConfig {
    private Map<String, String> documentTypes;

    public Map<String, String> getDocumentTypes() {
        return documentTypes;
    }

    public void setDocumentTypes(Map<String, String> documentTypes) {
        this.documentTypes = documentTypes;
    }
}
