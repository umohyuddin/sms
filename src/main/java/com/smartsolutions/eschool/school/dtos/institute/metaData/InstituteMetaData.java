package com.smartsolutions.eschool.school.dtos.institute.metaData;

import com.smartsolutions.eschool.lookups.dtos.country.response.CountryResponseDTO;
import com.smartsolutions.eschool.lookups.dtos.province.responseDto.ProvinceResponseDTO;
import com.smartsolutions.eschool.lookups.dtos.city.responseDto.CityResponseDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstituteMetaData {
    private List<CountryResponseDTO> countries;
    private List<ProvinceResponseDTO> provinces;
    private List<CityResponseDTO> cities;
}
