package com.smartsolutions.eschool.sclass.dtos.standardSubject.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StandardSubjectRequestDTO {

    @NotNull
    private Long standardId;

    @NotNull
    private Long subjectId;

    private Boolean isOptional = false;
}
