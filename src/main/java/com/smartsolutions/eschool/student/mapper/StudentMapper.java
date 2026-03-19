package com.smartsolutions.eschool.student.mapper;

import com.smartsolutions.eschool.student.dtos.StudentDTO;
import com.smartsolutions.eschool.student.dtos.student.responseDto.StudentResponseDTO;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.school.dtos.campuses.responseDto.CampusResponseDTO;
import com.smartsolutions.eschool.student.dtos.student.responseDto.StudentStandardDTO;
import com.smartsolutions.eschool.student.dtos.student.requestDto.StudentRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

public class StudentMapper {

    private StudentMapper() {
        // prevent instantiation
    }

    public static StudentDTO toDTO(StudentEntity entity) {
        if (entity == null) return null;
        StudentDTO dto = new StudentDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setMiddleName(entity.getMiddleName());
        dto.setFullName(entity.getFullName());
        dto.setLastName(entity.getLastName());
        dto.setStudentCode(entity.getStudentCode());
        dto.setDateOfBirth(entity.getDateOfBirth());
        dto.setGender(entity.getGender());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setAddress(entity.getAddress());
        dto.setCnic(entity.getCnic());
        dto.setPassportNumber(entity.getPassportNumber());
        dto.setReligion(entity.getReligion());
        dto.setNationality(entity.getNationality());
        dto.setBloodGroup(entity.getBloodGroup());
        dto.setIsActive(entity.getIsActive());
        dto.setDeleted(entity.isDeleted());
        dto.setDeletedAt(entity.getDeletedAt());
        dto.setStatus(entity.getStatus());
        dto.setEnrollmentDate(entity.getEnrollmentDate());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setFeeAssigned(entity.getFeeAssigned() != null ? entity.getFeeAssigned() : false);

        if (entity.getCampus() != null) {
            dto.setCampusId(entity.getCampus().getId());
            CampusResponseDTO campusDto = new CampusResponseDTO();
            campusDto.setId(entity.getCampus().getId());
            campusDto.setCampusName(entity.getCampus().getCampusName());
            campusDto.setCampusCode(entity.getCampus().getCampusCode());
            dto.setCampus(campusDto);
        }

        if (entity.getStandard() != null) {
            dto.setStandardId(entity.getStandard().getId());
            StudentStandardDTO standardDto = new StudentStandardDTO();
            standardDto.setId(entity.getStandard().getId());
            standardDto.setStandardName(entity.getStandard().getStandardName());
            standardDto.setStandardCode(entity.getStandard().getStandardCode());
            dto.setStandard(standardDto);
        }

        if (entity.getSection() != null) {
            dto.setSectionId(entity.getSection().getId());
        }

        if (entity.getAcademicYear() != null) {
            dto.setAcademicYearId(entity.getAcademicYear().getId());
        }

        return dto;
    }

    public static List<StudentDTO> toDTOList(List<StudentEntity> entities) {
        return entities == null ? null : entities.stream().map(StudentMapper::toDTO).collect(Collectors.toList());
    }

    public static StudentResponseDTO toResponseDTO(StudentEntity entity) {
        if (entity == null) return null;
        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setMiddleName(entity.getMiddleName());
        dto.setLastName(entity.getLastName());
        dto.setFullName(entity.getFullName());
        dto.setStudentCode(entity.getStudentCode());
        dto.setDateOfBirth(entity.getDateOfBirth());
        dto.setGender(entity.getGender());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setAddress(entity.getAddress());
        dto.setCnic(entity.getCnic());
        dto.setPassportNumber(entity.getPassportNumber());
        dto.setReligion(entity.getReligion());
        dto.setNationality(entity.getNationality());
        dto.setBloodGroup(entity.getBloodGroup());
        dto.setIsActive(entity.getIsActive());
        dto.setStatus(entity.getStatus());
        dto.setEnrollmentDate(entity.getEnrollmentDate());
        dto.setDeleted(entity.isDeleted());
        dto.setDeletedAt(entity.getDeletedAt());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        if (entity.getCampus() != null) {
            dto.setCampusId(entity.getCampus().getId());
            dto.setCampusName(entity.getCampus().getCampusName());
        }

        if (entity.getStandard() != null) {
            dto.setStandardId(entity.getStandard().getId());
            dto.setStandardName(entity.getStandard().getStandardName());
        }

        if (entity.getSection() != null) {
            dto.setSectionId(entity.getSection().getId());
            dto.setSectionName(entity.getSection().getSectionName());
        }

        if (entity.getAdmissionType() != null) {
            dto.setAdmissionTypeId(entity.getAdmissionType().getId());
            dto.setAdmissionTypeName(entity.getAdmissionType().getName());
        }

        if (entity.getAcademicYear() != null) {
            dto.setAcademicYearId(entity.getAcademicYear().getId());
            dto.setAcademicYearName(entity.getAcademicYear().getName());
        }

        return dto;
    }

    public static List<StudentResponseDTO> toResponseDTOList(List<StudentEntity> entities) {
        return entities == null ? null : entities.stream().map(StudentMapper::toResponseDTO).collect(Collectors.toList());
    }

    public static StudentEntity toEntity(StudentRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getCampusId() == null) {
            throw new com.smartsolutions.eschool.global.error.ApiException(com.smartsolutions.eschool.student.error.StudentErrors.INVALID_STUDENT_DATA, "Campus ID is required", org.springframework.http.HttpStatus.BAD_REQUEST);
        }
        if (dto.getStandardId() == null) {
            throw new com.smartsolutions.eschool.global.error.ApiException(com.smartsolutions.eschool.student.error.StudentErrors.INVALID_STUDENT_DATA, "Standard ID is required", org.springframework.http.HttpStatus.BAD_REQUEST);
        }
        if (dto.getFirstName() == null || dto.getFirstName().trim().isEmpty()) {
            throw new com.smartsolutions.eschool.global.error.ApiException(com.smartsolutions.eschool.student.error.StudentErrors.INVALID_STUDENT_DATA, "First name is required", org.springframework.http.HttpStatus.BAD_REQUEST);
        }
        if (dto.getLastName() == null || dto.getLastName().trim().isEmpty()) {
            throw new com.smartsolutions.eschool.global.error.ApiException(com.smartsolutions.eschool.student.error.StudentErrors.INVALID_STUDENT_DATA, "Last name is required", org.springframework.http.HttpStatus.BAD_REQUEST);
        }
        if (dto.getDateOfBirth() == null) {
            throw new com.smartsolutions.eschool.global.error.ApiException(com.smartsolutions.eschool.student.error.StudentErrors.INVALID_STUDENT_DATA, "Date of birth is required", org.springframework.http.HttpStatus.BAD_REQUEST);
        }

        StudentEntity entity = new StudentEntity();
        
        String code = dto.getStudentCode();
        if (code == null || code.trim().isEmpty()) {
            code = "STD-" + java.util.UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        }
        entity.setStudentCode(code);

        entity.setFirstName(dto.getFirstName().trim());
        entity.setMiddleName(dto.getMiddleName() != null ? dto.getMiddleName().trim() : null);
        entity.setLastName(dto.getLastName().trim());
        
        String fullName = dto.getFullName() != null && !dto.getFullName().isBlank() 
                ? dto.getFullName().trim() 
                : entity.getFirstName() + (entity.getMiddleName() != null ? " " + entity.getMiddleName() : "") + " " + entity.getLastName();
        entity.setFullName(fullName);

        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setGender(dto.getGender());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setAddress(dto.getAddress());
        entity.setCnic(dto.getCnic());
        entity.setPassportNumber(dto.getPassportNumber());
        entity.setReligion(dto.getReligion());
        entity.setNationality(dto.getNationality());
        entity.setBloodGroup(dto.getBloodGroup());
        entity.setEnrollmentDate(dto.getEnrollmentDate() != null ? dto.getEnrollmentDate() : java.time.LocalDate.now());
        
        entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        entity.setStatus(dto.getStatus() != null ? dto.getStatus() : "Pending");
        entity.setDeleted(false);

        return entity;
    }

    public static void updateEntityFromDTO(StudentEntity entity, StudentRequestDTO dto) {
        if (entity == null || dto == null) return;

        if (dto.getFirstName() != null && !dto.getFirstName().isBlank()) {
            entity.setFirstName(dto.getFirstName().trim());
        }
        if (dto.getMiddleName() != null) {
            entity.setMiddleName(dto.getMiddleName().trim());
        }
        if (dto.getLastName() != null && !dto.getLastName().isBlank()) {
            entity.setLastName(dto.getLastName().trim());
        }

        // Update fullname if components changed
        String fullName = entity.getFirstName() + 
            (entity.getMiddleName() != null && !entity.getMiddleName().isBlank() ? " " + entity.getMiddleName() : "") + 
            " " + entity.getLastName();
        entity.setFullName(fullName);

        if (dto.getDateOfBirth() != null) entity.setDateOfBirth(dto.getDateOfBirth());
        if (dto.getGender() != null) entity.setGender(dto.getGender());
        if (dto.getEmail() != null) entity.setEmail(dto.getEmail());
        if (dto.getPhone() != null) entity.setPhone(dto.getPhone());
        if (dto.getAddress() != null) entity.setAddress(dto.getAddress());
        if (dto.getCnic() != null) entity.setCnic(dto.getCnic());
        if (dto.getPassportNumber() != null) entity.setPassportNumber(dto.getPassportNumber());
        if (dto.getReligion() != null) entity.setReligion(dto.getReligion());
        if (dto.getNationality() != null) entity.setNationality(dto.getNationality());
        if (dto.getBloodGroup() != null) entity.setBloodGroup(dto.getBloodGroup());
        if (dto.getEnrollmentDate() != null) entity.setEnrollmentDate(dto.getEnrollmentDate());

        if (dto.getIsActive() != null) entity.setIsActive(dto.getIsActive());
        if (dto.getStatus() != null) entity.setStatus(dto.getStatus());
    }
}

