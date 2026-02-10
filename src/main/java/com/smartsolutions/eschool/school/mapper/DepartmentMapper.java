package com.smartsolutions.eschool.school.mapper;

import com.smartsolutions.eschool.school.dtos.departments.request.DepartmentRequestDTO;
import com.smartsolutions.eschool.school.model.DepartmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);
    @Mapping(target="id", ignore=true) // entity id is auto-generated
    @Mapping(source="parentDepartmentId", target="parentDepartment.id")
    @Mapping(source="headEmployeeId", target="headEmployee.id")
    DepartmentEntity toEntity(DepartmentRequestDTO dto);

    DepartmentRequestDTO toDTO(DepartmentEntity entity);
}
