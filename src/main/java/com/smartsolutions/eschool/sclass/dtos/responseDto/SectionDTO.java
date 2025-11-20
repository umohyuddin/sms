package com.smartsolutions.eschool.sclass.dtos.responseDto;

import lombok.Data;

@Data
public class SectionDTO {
    private Long id;
    private String sectionName;
    private String sectionCode;
    private StandardDTO standard;
}
