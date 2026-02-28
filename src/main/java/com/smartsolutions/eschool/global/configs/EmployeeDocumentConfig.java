package com.smartsolutions.eschool.global.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "employee")
public class EmployeeDocumentConfig {
    private Integer probationPeriodMonths;

    private Map<String, String> documentTypes = new java.util.HashMap<>();
    private Map<String, String> addressTypes = new java.util.HashMap<>();
    private Map<String, String> emergencyContactRelationships = new java.util.HashMap<>();
    private Map<String, String> qualificationDegrees = new java.util.HashMap<>();
    private Map<String, String> qualificationSubjects = new java.util.HashMap<>();
    private Map<String, String> maritalStatus = new java.util.HashMap<>();
    private Map<String, String> employmentTypes = new java.util.HashMap<>();

    public Integer getProbationPeriodMonths() {
        return probationPeriodMonths;
    }

    public void setProbationPeriodMonths(Integer probationPeriodMonths) {
        this.probationPeriodMonths = probationPeriodMonths;
    }

    public Map<String, String> getDocumentTypes() {
        return documentTypes;
    }

    public void setDocumentTypes(Map<String, String> documentTypes) {
        this.documentTypes = documentTypes;
    }

    public Map<String, String> getAddressTypes() {
        return addressTypes;
    }

    public void setAddressTypes(Map<String, String> addressTypes) {
        this.addressTypes = addressTypes;
    }

    public Map<String, String> getEmergencyContactRelationships() {
        return emergencyContactRelationships;
    }

    public void setEmergencyContactRelationships(Map<String, String> emergencyContactRelationships) {
        this.emergencyContactRelationships = emergencyContactRelationships;
    }

    public Map<String, String> getQualificationDegrees() {
        return qualificationDegrees;
    }

    public void setQualificationDegrees(Map<String, String> qualificationDegrees) {
        this.qualificationDegrees = qualificationDegrees;
    }

    public Map<String, String> getQualificationSubjects() {
        return qualificationSubjects;
    }

    public void setQualificationSubjects(Map<String, String> qualificationSubjects) {
        this.qualificationSubjects = qualificationSubjects;
    }

    public Map<String, String> getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Map<String, String> maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Map<String, String> getEmploymentTypes() {
        return employmentTypes;
    }

    public void setEmploymentTypes(Map<String, String> employmentTypes) {
        this.employmentTypes = employmentTypes;
    }
}

/**
 * ================================================================
 * Employee Configuration Properties Mapping
 * ================================================================
 *
 * application.properties key prefix: employee
 *
 * ---------------------------------------------------------------
 * Property Key Pattern Java Field
 * ---------------------------------------------------------------
 * employee.document-types.* documentTypes
 * employee.address-types.* addressTypes
 * employee.emergency-contact-relationships.* emergencyContactRelationships
 * employee.qualification-degrees.* qualificationDegrees
 * employee.qualification-subjects.* qualificationSubjects
 * employee.marital-status.* maritalStatus
 * employee.probation-period-months probationPeriodMonths
 * ---------------------------------------------------------------
 *
 * Usage:
 * - All "*" entries are mapped as Map<String, String>
 * - probationPeriodMonths is a single Integer value
 *
 * Example:
 * employee.document-types.RESUME=Resume
 * → documentTypes.get("RESUME") = "Resume"
 *
 * ================================================================
 */
