package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.dtos.academicYear.requestDto.AcademicYearRequestDTO;
import com.smartsolutions.eschool.school.dtos.academicYear.responseDto.AcademicYearResponseDTO;

import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class AcademicYearService {
    private final AcademicYearRepository academicYearRepository;

    public AcademicYearService(AcademicYearRepository academicYearRepository) {
        this.academicYearRepository = academicYearRepository;
    }


    public AcademicYearResponseDTO getCurrentAcademicYear() {
        try {
            log.info("Fetching current Academic Year...");
            AcademicYearEntity current = academicYearRepository.findByIsCurrentTrue().orElseThrow(() -> new RuntimeException("No active academic year found"));
            return MapperUtil.mapObject(current, AcademicYearResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while fetching current academic year", dae);
            throw new RuntimeException("Failed to fetch current academic year due to database issue");
        } catch (Exception e) {
            log.error("Unexpected error while fetching current academic year", e);
            throw new RuntimeException("Failed to fetch current academic year");
        }
    }

    public AcademicYearRequestDTO createAcademicYear(@Valid AcademicYearRequestDTO requestDTO) {
        log.info("Creating new Academic Year: {}", requestDTO.getName());

        try {
            // Validate date logic
            if (requestDTO.getStartDate().isAfter(requestDTO.getEndDate())) {
                throw new IllegalArgumentException("Start date cannot be after end date.");
            }
            validateNameFormat(requestDTO.getName());

            if (Boolean.TRUE.equals(requestDTO.getIsCurrent())) {
                log.info("Deactivating previous academic years...");
                academicYearRepository.deactivateAllAcademicYears();
            }

            AcademicYearEntity academicYearEntity = MapperUtil.mapObject(requestDTO, AcademicYearEntity.class);

            // Calculate total months
            //requestDTO.getStartDate() → the start date (e.g., 2025-01-15)
            //.withDayOfMonth(1) → normalize to the first day of the month (2025-01-01)
            //Same for requestDTO.getEndDate() (e.g., 2025-03-10 → 2025-03-01)
            //ChronoUnit.MONTHS.between(start, end) → counts full months between the two normalized dates:

            long monthsBetween = ChronoUnit.MONTHS.between(requestDTO.getStartDate().withDayOfMonth(1), requestDTO.getEndDate().withDayOfMonth(1)) + 1;
            academicYearEntity.setTotalMonths(monthsBetween);

            // Save entity
            academicYearEntity = academicYearRepository.save(academicYearEntity);
            log.info("Academic Year saved with id: {}", academicYearEntity.getId());

            // Map back to DTO
            return MapperUtil.mapObject(academicYearEntity, AcademicYearRequestDTO.class);

        } catch (DataAccessException dae) {
            log.error("Database error while creating Academic Year", dae);
            throw new RuntimeException("Failed to create Academic Year due to database error");
        } catch (Exception e) {
            log.error("Unexpected error while creating Academic Year", e);
            throw new RuntimeException("Failed to create Academic Year");
        }
    }

    public List<AcademicYearResponseDTO> getAll() {
        try {
            log.info("Fetching all Academic year from database");
            List<AcademicYearEntity> result = academicYearRepository.findAll();
            log.info("Successfully fetched {} Academic year", result.size());
            List<AcademicYearResponseDTO> responseDTOS = MapperUtil.mapList(result, AcademicYearResponseDTO.class);
            log.info("Successfully fetched Academic year");
            return responseDTOS;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Academic year", dae);
            //throw new CustomServiceException("Unable to fetch students from database", dae);
        } catch (MappingException me) {
            log.error("Error mapping StudentEntity to Academic year", me);
            //throw new CustomServiceException("Error converting student data", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Academic year", e);
            //throw new ("Unexpected error occurred", e);
        }
        return Collections.emptyList();
    }

    private void validateNameFormat(String name) {
        if (!name.matches("\\d{4}-\\d{4}")) {
            throw new IllegalArgumentException("Academic year name must be in 'YYYY-YYYY' format.");
        }
    }

    private long calculateMonths(LocalDate start, LocalDate end) {
        return java.time.temporal.ChronoUnit.MONTHS.between(start, end) + 1;
    }


}



