package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.sclass.dtos.requestDto.SectionCreateRequestDTO;
import com.smartsolutions.eschool.student.dtos.requestDto.StudentFeeAssignmentRequestDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeRateDTO;
import com.smartsolutions.eschool.student.service.FeeRateService;
import com.smartsolutions.eschool.student.service.StudentFeeAssignmentService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class StudentFeeAssignmentFacade {

private StudentFeeAssignmentService studentFeeAssignmentService;

    public StudentFeeAssignmentFacade(StudentFeeAssignmentService studentFeeAssignmentService) {
        this.studentFeeAssignmentService = studentFeeAssignmentService;
    }

    public StudentFeeAssignmentRequestDTO assignStudentFee(Long id,@Valid StudentFeeAssignmentRequestDTO dto) {
        return studentFeeAssignmentService.assignStudentFee(id,dto);
    }
}

