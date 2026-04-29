package com.smartsolutions.eschool.school.dtos.instituteSocialLinks.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteSocialLinkUpdateRequestDTO {
    private String platform;
    private String url;
}
