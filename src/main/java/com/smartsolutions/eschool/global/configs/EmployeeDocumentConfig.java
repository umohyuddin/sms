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
    private Map<String, String> addressTypes;
    private Map<String, String> emergencyContactRelationships;
    private Map<String, String> degrees;
    private Map<String, String> subjects;

    // Document Types
    public Map<String, String> getDocumentTypes() {
        return documentTypes;
    }

    public void setDocumentTypes(Map<String, String> documentTypes) {
        this.documentTypes = documentTypes;
    }

    // Address Types
    public Map<String, String> getAddressTypes() {
        return addressTypes;
    }

    public void setAddressTypes(Map<String, String> addressTypes) {
        this.addressTypes = addressTypes;
    }

    // Emergency Contact Relationships
    public Map<String, String> getEmergencyContactRelationships() {
        return emergencyContactRelationships;
    }

    public void setEmergencyContactRelationships(Map<String, String> emergencyContactRelationships) {
        this.emergencyContactRelationships = emergencyContactRelationships;
    }

    public Map<String, String> getDegrees() {
        return degrees;
    }

    public void setDegrees(Map<String, String> degrees) {
        this.degrees = degrees;
    }

    public Map<String, String> getSubjects() {
        return subjects;
    }

    public void setSubjects(Map<String, String> subjects) {
        this.subjects = subjects;
    }
}
