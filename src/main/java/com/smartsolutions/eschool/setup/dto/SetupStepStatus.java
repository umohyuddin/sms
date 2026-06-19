package com.smartsolutions.eschool.setup.dto;

/**
 * Enum representing the completion status of a system setup step.
 */
public enum SetupStepStatus {
    /**
     * Required data for this step has been configured.
     */
    COMPLETED,

    /**
     * Prerequisite steps are completed, but this step has not been configured yet.
     */
    PENDING,

    /**
     * One or more prerequisite steps have not been completed.
     */
    LOCKED
}
