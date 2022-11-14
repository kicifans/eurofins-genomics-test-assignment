package com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

    private String city;
    private String region;
    private String country;
    private String loc;
    private String org;

}
