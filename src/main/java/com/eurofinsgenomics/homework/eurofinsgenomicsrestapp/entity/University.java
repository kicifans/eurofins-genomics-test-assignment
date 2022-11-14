package com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class University {

    private List<String> domains = null;
    private String alphaTwoCode;
    private List<String> webPages = null;
    private String country;
    private Object stateProvince;
    private String name;

}
