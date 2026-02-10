package com.smartsolutions.eschool.student.mapper;

import com.smartsolutions.eschool.student.dtos.StudentDTO;
import com.smartsolutions.eschool.student.dtos.student.responseDto.StudentResponseDTO;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.school.dtos.campuses.responseDto.CampusResponseDTO;
import com.smartsolutions.eschool.student.dtos.student.responseDto.StudentStandardDTO;

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
}

