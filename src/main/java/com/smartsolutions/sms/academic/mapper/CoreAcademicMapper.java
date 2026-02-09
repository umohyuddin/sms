package com.smartsolutions.sms.academic.mapper;

import com.smartsolutions.sms.academic.dto.request.StandardSubjectRequestDTO;
import com.smartsolutions.sms.academic.dto.request.SubjectGroupRequestDTO;
import com.smartsolutions.sms.academic.dto.request.SubjectRequestDTO;
import com.smartsolutions.sms.academic.dto.response.StandardSubjectResponseDTO;
import com.smartsolutions.sms.academic.dto.response.SubjectGroupResponseDTO;
import com.smartsolutions.sms.academic.dto.response.SubjectResponseDTO;
import com.smartsolutions.sms.academic.entity.mapping.StandardSubjectEntity;
import com.smartsolutions.sms.academic.entity.master.SubjectEntity;
import com.smartsolutions.sms.academic.entity.master.SubjectGroupEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CoreAcademicMapper {

    CoreAcademicMapper INSTANCE = Mappers.getMapper(CoreAcademicMapper.class);

    // SubjectGroup
    SubjectGroupEntity toEntity(SubjectGroupRequestDTO dto);
    SubjectGroupResponseDTO toResponse(SubjectGroupEntity entity);

    // Subject
    @Mapping(target = "subjectGroup.id", source = "subjectGroupId")
    SubjectEntity toEntity(SubjectRequestDTO dto);
    
    @Mapping(target = "subjectGroupId", source = "subjectGroup.id")
    @Mapping(target = "subjectGroupName", source = "subjectGroup.name")
    SubjectResponseDTO toResponse(SubjectEntity entity);

    // StandardSubject
    @Mapping(target = "id.standardId", source = "standardId")
    @Mapping(target = "id.subjectId", source = "subjectId")
    @Mapping(target = "id.academicYearId", source = "academicYearId")
    @Mapping(target = "standard.id", source = "standardId")
    @Mapping(target = "subject.id", source = "subjectId")
    @Mapping(target = "academicYear.id", source = "academicYearId")
    StandardSubjectEntity toEntity(StandardSubjectRequestDTO dto);

    @Mapping(target = "standardId", source = "id.standardId")
    @Mapping(target = "standardName", source = "standard.standardName")
    @Mapping(target = "subjectId", source = "id.subjectId")
    @Mapping(target = "subjectName", source = "subject.name")
    @Mapping(target = "academicYearId", source = "id.academicYearId")
    @Mapping(target = "academicYearName", source = "academicYear.name")
    StandardSubjectResponseDTO toResponse(StandardSubjectEntity entity);
}
