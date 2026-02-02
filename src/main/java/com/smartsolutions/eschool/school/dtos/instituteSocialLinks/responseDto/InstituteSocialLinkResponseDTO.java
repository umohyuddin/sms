package com.smartsolutions.eschool.school.dtos.instituteSocialLinks.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteSocialLinkResponseDTO {
    private Long id;
    private Long instituteId;
    private String platform;
    private String url;
}
