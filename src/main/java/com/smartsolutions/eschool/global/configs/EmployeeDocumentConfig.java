package com.smartsolutions.eschool.global.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "employee")
@Component
public class EmployeeDocumentConfig {
    private Integer probationPeriodMonths;

    private Map<String, String> documentTypes;
    private Map<String, String> addressTypes;
    private Map<String, String> emergencyContactRelationships;
    private Map<String, String> qualificationDegrees;
    private Map<String, String> qualificationSubjects;
    private Map<String, String> maritalStatus;

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
}



/**
 * ================================================================
 * Employee Configuration Properties Mapping
 * ================================================================
 *
 * application.properties key prefix: employee
 *
 * ---------------------------------------------------------------
 * Property Key Pattern                           Java Field
 * ---------------------------------------------------------------
 * employee.document-types.*                      documentTypes
 * employee.address-types.*                       addressTypes
 * employee.emergency-contact-relationships.*     emergencyContactRelationships
 * employee.qualification-degrees.*               qualificationDegrees
 * employee.qualification-subjects.*              qualificationSubjects
 * employee.marital-status.*                      maritalStatus
 * employee.probation-period-months               probationPeriodMonths
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

