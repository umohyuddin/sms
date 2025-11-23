package com.smartsolutions.eschool.student.mapper;

import com.smartsolutions.eschool.student.dtos.StudentDTO;
import com.smartsolutions.eschool.student.model.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

        @Mapping(source = "campus.id", target = "campusId")
        @Mapping(source = "standard.id", target = "standardId")
        @Mapping(source = "section.id", target = "sectionId")
        StudentDTO toDTO(StudentEntity student);
        List<StudentDTO> toDTOList(List<StudentEntity> students);
    }

