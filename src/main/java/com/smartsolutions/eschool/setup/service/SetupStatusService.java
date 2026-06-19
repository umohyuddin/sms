package com.smartsolutions.eschool.setup.service;

import com.smartsolutions.eschool.setup.dto.SetupStatusResponseDto;
import com.smartsolutions.eschool.setup.dto.SetupStepDto;
import com.smartsolutions.eschool.setup.dto.SetupStepStatus;
import com.smartsolutions.eschool.util.SecurityUtils;
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

    // Inject your repositories here to check data existence
    // e.g., private final CampusRepository campusRepository;
    // e.g., private final AcademicYearRepository academicYearRepository;
    // ...

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

    // =================================================================================================
    // Replace the return statements below with actual repository counts: e.g. repository.count() > 0
    // =================================================================================================

    private boolean checkCampusExists(Long organizationId) {
        // e.g. return campusRepository.countByOrganizationId(organizationId) > 0;
        return true; 
    }

    private boolean checkAcademicYearExists(Long organizationId) {
        // e.g. return academicYearRepository.countByOrganizationId(organizationId) > 0;
        return true;
    }

    private boolean checkStandardsExist(Long organizationId) {
        // e.g. return standardRepository.countByOrganizationId(organizationId) > 0;
        return false;
    }

    private boolean checkSectionsExist(Long organizationId) {
        return false;
    }

    private boolean checkSubjectsExist(Long organizationId) {
        return false;
    }

    private boolean checkStaffExists(Long organizationId) {
        return false;
    }

    private boolean checkFeeTypesExist(Long organizationId) {
        return false;
    }

    private boolean checkFeeStructureExists(Long organizationId) {
        return false;
    }

    private boolean checkStudentsExist(Long organizationId) {
        return false;
    }
}
