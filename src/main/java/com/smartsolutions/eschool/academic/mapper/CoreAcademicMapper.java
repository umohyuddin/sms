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
