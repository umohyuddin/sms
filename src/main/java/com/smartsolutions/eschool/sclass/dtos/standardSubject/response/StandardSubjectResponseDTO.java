package com.smartsolutions.eschool.sclass.dtos.standardSubject.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StandardSubjectResponseDTO {

    private Long id;

    private Long standardId;
    private String standardName;

    private Long subjectId;
    private String subjectName;

    private Boolean isOptional;
}
