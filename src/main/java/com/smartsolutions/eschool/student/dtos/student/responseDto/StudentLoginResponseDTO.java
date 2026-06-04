package com.smartsolutions.eschool.student.dtos.student.responseDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentLoginResponseDTO {

    private Long studentId;
    private Long systemUserId;
    private String username;
    private String status;
    private String message;
}
