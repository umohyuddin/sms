package com.smartsolutions.eschool.setup.service;

import com.smartsolutions.eschool.setup.dto.SetupStatusResponseDto;
import com.smartsolutions.eschool.setup.dto.SetupStepDto;
import com.smartsolutions.eschool.setup.dto.SetupStepStatus;
import com.smartsolutions.eschool.util.SecurityUtils;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service responsible for calculating the current system setup status.
 */
@Service
@RequiredArgsConstructor
public class SetupStatusService {

    private final EntityManager entityManager;

    public SetupStatusResponseDto getSetupStatus() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();

        List<SetupStepDto> steps = new ArrayList<>();
        int completedStepsCount = 0;
        boolean isPreviousPendingOrLocked = false;


        // 1. Create Academic Year
        boolean hasAcademicYear = checkAcademicYearExists(organizationId);
        isPreviousPendingOrLocked = addStep(steps, "ACADEMIC_YEAR", "Create Academic Year", "/academic-years", hasAcademicYear, isPreviousPendingOrLocked);
        if (hasAcademicYear && !isPreviousPendingOrLocked) completedStepsCount++;

        // 2. Create Campus
        boolean hasCampus = checkCampusExists(organizationId);
        isPreviousPendingOrLocked = addStep(steps, "CAMPUS", "Create Campus", "/campuses", hasCampus, isPreviousPendingOrLocked);
        if (hasCampus && !isPreviousPendingOrLocked) completedStepsCount++;


        // 3. Create Standards
        boolean hasStandards = checkStandardsExist(organizationId);
        isPreviousPendingOrLocked = addStep(steps, "STANDARD", "Create Standards", "/standards", hasStandards, isPreviousPendingOrLocked);
        if (hasStandards && !isPreviousPendingOrLocked) completedStepsCount++;

        // 4. Create Sections
        boolean hasSections = checkSectionsExist(organizationId);
        isPreviousPendingOrLocked = addStep(steps, "SECTION", "Create Sections", "/sections", hasSections, isPreviousPendingOrLocked);
        if (hasSections && !isPreviousPendingOrLocked) completedStepsCount++;

        // 5. Create Subjects
        boolean hasSubjects = checkSubjectsExist(organizationId);
        isPreviousPendingOrLocked = addStep(steps, "SUBJECT", "Create Subjects", "/subjects", hasSubjects, isPreviousPendingOrLocked);
        if (hasSubjects && !isPreviousPendingOrLocked) completedStepsCount++;

        // 6. Create Staff Users
        boolean hasStaff = checkStaffExists(organizationId);
        isPreviousPendingOrLocked = addStep(steps, "STAFF", "Create Staff Users", "/staff", hasStaff, isPreviousPendingOrLocked);
        if (hasStaff && !isPreviousPendingOrLocked) completedStepsCount++;

        // 7. Configure Fee Types
        boolean hasFeeTypes = checkFeeTypesExist(organizationId);
        isPreviousPendingOrLocked = addStep(steps, "FEE_TYPES", "Configure Fee Types", "/fee-types", hasFeeTypes, isPreviousPendingOrLocked);
        if (hasFeeTypes && !isPreviousPendingOrLocked) completedStepsCount++;

        // 8. Configure Fee Structure
        boolean hasFeeStructure = checkFeeStructureExists(organizationId);
        isPreviousPendingOrLocked = addStep(steps, "FEE_STRUCTURE", "Configure Fee Structure", "/fee-structure", hasFeeStructure, isPreviousPendingOrLocked);
        if (hasFeeStructure && !isPreviousPendingOrLocked) completedStepsCount++;

        // 9. Add Students
        boolean hasStudents = checkStudentsExist(organizationId);
        addStep(steps, "STUDENT", "Add Students", "/students", hasStudents, isPreviousPendingOrLocked);
        if (hasStudents && !isPreviousPendingOrLocked) completedStepsCount++;

        int totalSteps = steps.size();
        int completionPercentage = totalSteps == 0 ? 0 : (int) Math.round((completedStepsCount * 100.0) / totalSteps);

        return SetupStatusResponseDto.builder()
                .completionPercentage(completionPercentage)
                .completedSteps(completedStepsCount)
                .totalSteps(totalSteps)
                .steps(steps)
                .build();
    }

    /**
     * Helper method to determine step status and add it to the list.
     * Returns true if the current step is PENDING or LOCKED, meaning the next step MUST be LOCKED.
     */
    private boolean addStep(List<SetupStepDto> steps, String code, String title, String route, boolean hasData, boolean isPreviousPendingOrLocked) {
        SetupStepStatus status;

        if (isPreviousPendingOrLocked) {
            status = SetupStepStatus.LOCKED;
        } else if (hasData) {
            status = SetupStepStatus.COMPLETED;
        } else {
            status = SetupStepStatus.PENDING;
            isPreviousPendingOrLocked = true; // Once a step is PENDING, all subsequent steps are LOCKED
        }

        steps.add(SetupStepDto.builder()
                .code(code)
                .title(title)
                .status(status)
                .route(route)
                .build());

        return isPreviousPendingOrLocked;
    }

    private boolean checkCampusExists(Long organizationId) {
        return checkEntityExists("CampusEntity", organizationId);
    }

    private boolean checkAcademicYearExists(Long organizationId) {
        return checkEntityExists("AcademicYearEntity", organizationId);
    }

    private boolean checkStandardsExist(Long organizationId) {
        return checkEntityExists("StandardEntity", organizationId);
    }

    private boolean checkSectionsExist(Long organizationId) {
        return checkEntityExists("SectionEntity", organizationId);
    }

    private boolean checkSubjectsExist(Long organizationId) {
        return checkEntityExists("SubjectEntity", organizationId);
    }

    private boolean checkStaffExists(Long organizationId) {
        return checkEntityExists("SystemUserEntity", organizationId);
    }

    private boolean checkFeeTypesExist(Long organizationId) {
        // ChargeTypeEntity extends ScopeAuditableEntity which doesn't use organizationId directly
        try {
            Long count = entityManager.createQuery(
                    "SELECT COUNT(e) FROM ChargeTypeEntity e WHERE e.deleted = false", Long.class)
                    .getSingleResult();
            return count != null && count > 0;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean checkFeeStructureExists(Long organizationId) {
        return checkEntityExists("FeeCatalogEntity", organizationId);
    }

    private boolean checkStudentsExist(Long organizationId) {
        return checkEntityExists("StudentEntity", organizationId);
    }

    private boolean checkEntityExists(String entityName, Long organizationId) {
        if (organizationId == null) return false;
        try {
            Long count = entityManager.createQuery(
                    "SELECT COUNT(e) FROM " + entityName + " e WHERE e.organizationId = :orgId AND e.deleted = false", Long.class)
                    .setParameter("orgId", organizationId)
                    .getSingleResult();
            return count != null && count > 0;
        } catch (Exception e) {
            // Failsafe in case of any mapping issues
            return false;
        }
    }
}
