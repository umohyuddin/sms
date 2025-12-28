package com.smartsolutions.eschool.school.dtos.campuses.metaData;

import com.smartsolutions.eschool.lookups.dtos.province.responseDto.ProvinceResponseDTO;
import com.smartsolutions.eschool.school.dtos.institute.response.InstituteResponseDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CampusMetaData {
    private InstituteResponseDTO institute;
    private List<ProvinceResponseDTO> provinces;
}
