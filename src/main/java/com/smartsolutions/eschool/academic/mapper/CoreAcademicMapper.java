package com.smartsolutions.eschool.academic.mapper;

import com.smartsolutions.eschool.academic.dto.request.StandardSubjectRequestDTO;
import com.smartsolutions.eschool.academic.dto.request.SubjectGroupRequestDTO;
import com.smartsolutions.eschool.academic.dto.request.SubjectRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.StandardSubjectResponseDTO;
import com.smartsolutions.eschool.academic.dto.response.SubjectGroupResponseDTO;
import com.smartsolutions.eschool.academic.dto.response.SubjectResponseDTO;
import com.smartsolutions.eschool.academic.entity.mapping.StandardSubjectEntity;
import com.smartsolutions.eschool.academic.entity.master.SubjectEntity;
import com.smartsolutions.eschool.academic.entity.master.SubjectGroupEntity;

import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.sclass.model.StandardEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CoreAcademicMapper {

    private CoreAcademicMapper() {
        // prevent instantiation
    }

    // SubjectGroup
    public static SubjectGroupEntity toEntity(SubjectGroupRequestDTO dto) {
        if (dto == null)
            return null;
        SubjectGroupEntity entity = new SubjectGroupEntity();
        entity.setOrganizationId(dto.getOrganizationId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setActive(dto.isActive());
        return entity;
    }

    public static SubjectGroupResponseDTO toResponse(SubjectGroupEntity entity) {
        if (entity == null)
            return null;
        SubjectGroupResponseDTO dto = new SubjectGroupResponseDTO();
        dto.setId(entity.getId());
        dto.setOrganizationId(entity.getOrganizationId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setActive(entity.isActive());
        dto.setDeleted(entity.isDeleted());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public static List<SubjectGroupResponseDTO> toSubjectGroupResponseList(List<SubjectGroupEntity> entities) {
        return entities == null ? null
                : entities.stream().map(CoreAcademicMapper::toResponse).collect(Collectors.toList());
    }

    // Subject
    public static SubjectEntity toEntity(SubjectRequestDTO dto) {
        if (dto == null)
            return null;
        SubjectEntity entity = new SubjectEntity();
        entity.setOrganizationId(dto.getOrganizationId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setCore(dto.isCore());
        if (dto.getSubjectGroupId() != null) {
            SubjectGroupEntity group = new SubjectGroupEntity();
            group.setId(dto.getSubjectGroupId());
            entity.setSubjectGroup(group);
        }
        entity.setActive(dto.isActive());
        return entity;
    }

    public static SubjectResponseDTO toResponse(SubjectEntity entity) {
        if (entity == null)
            return null;
        SubjectResponseDTO dto = new SubjectResponseDTO();
        dto.setId(entity.getId());
        dto.setOrganizationId(entity.getOrganizationId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setCore(entity.isCore());
        if (entity.getSubjectGroup() != null) {
            dto.setSubjectGroupId(entity.getSubjectGroup().getId());
            dto.setSubjectGroupName(entity.getSubjectGroup().getName());
        }
        dto.setActive(entity.isActive());
        dto.setDeleted(entity.isDeleted());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public static List<SubjectResponseDTO> toSubjectResponseList(List<SubjectEntity> entities) {
        return entities == null ? null
                : entities.stream().map(CoreAcademicMapper::toResponse).collect(Collectors.toList());
    }

    // StandardSubject
    public static StandardSubjectEntity toEntity(StandardSubjectRequestDTO dto) {
        if (dto == null)
            return null;
        StandardSubjectEntity entity = new StandardSubjectEntity();
        // ID is auto-generated

        if (dto.getStandardId() != null) {
            StandardEntity standard = new StandardEntity();
            standard.setId(dto.getStandardId());
            entity.setStandard(standard);
        }

        if (dto.getSubjectId() != null) {
            SubjectEntity subject = new SubjectEntity();
            subject.setId(dto.getSubjectId());
            entity.setSubject(subject);
        }

        if (dto.getAcademicYearId() != null) {
            AcademicYearEntity year = new AcademicYearEntity();
            year.setId(dto.getAcademicYearId());
            entity.setAcademicYear(year);
        }

        entity.setOptional(dto.isOptional());
        entity.setWeeklyHours(dto.getWeeklyHours());
        entity.setTheoryMarks(dto.getTheoryMarks());
        entity.setPracticalMarks(dto.getPracticalMarks());
        entity.setActive(dto.isActive());
        return entity;
    }

    public static StandardSubjectResponseDTO toResponse(StandardSubjectEntity entity) {
        if (entity == null)
            return null;
        StandardSubjectResponseDTO dto = new StandardSubjectResponseDTO();
        dto.setId(entity.getId());

        if (entity.getStandard() != null) {
            dto.setStandardId(entity.getStandard().getId());
            dto.setStandardName(entity.getStandard().getStandardName());
        }
        if (entity.getSubject() != null) {
            dto.setSubjectId(entity.getSubject().getId());
            dto.setSubjectName(entity.getSubject().getName());
        }
        if (entity.getAcademicYear() != null) {
            dto.setAcademicYearId(entity.getAcademicYear().getId());
            dto.setAcademicYearName(entity.getAcademicYear().getName());
        }
        dto.setOptional(entity.isOptional());
        dto.setWeeklyHours(entity.getWeeklyHours());
        dto.setTheoryMarks(entity.getTheoryMarks());
        dto.setPracticalMarks(entity.getPracticalMarks());
        dto.setActive(entity.isActive());
        return dto;
    }

    public static List<StandardSubjectResponseDTO> toStandardSubjectResponseList(List<StandardSubjectEntity> entities) {
        return entities == null ? null
                : entities.stream().map(CoreAcademicMapper::toResponse).collect(Collectors.toList());
    }
}
