package com.smartsolutions.eschool.setup.controller;

import com.smartsolutions.eschool.setup.dto.SetupStatusResponseDto;
import com.smartsolutions.eschool.setup.service.SetupStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for exposing system setup wizard endpoints.
 */
@RestController
@RequestMapping("/api/setup")
@RequiredArgsConstructor
public class SetupStatusController {

    private final SetupStatusService setupStatusService;

    /**
     * Gets the current setup status and progress for the system.
     *
     * @return the setup status response containing progress and steps
     */
    @GetMapping("/status")
    public ResponseEntity<SetupStatusResponseDto> getSetupStatus() {
        SetupStatusResponseDto response = setupStatusService.getSetupStatus();
        return ResponseEntity.ok(response);
    }
}
