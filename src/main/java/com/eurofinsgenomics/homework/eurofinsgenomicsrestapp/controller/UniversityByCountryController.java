package com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.controller;

import com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.entity.University;
import com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.utils.UniversitiesByCountryApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
public class UniversityByCountryController {

    @Autowired
    private UniversitiesByCountryApiService universitiesByCountryApiService;

    @GetMapping("/universities/{country}")
    public List<University> findCountryByIp(@PathVariable String country) throws IOException {
        return universitiesByCountryApiService.getObjectListFromUrl(country);
    }
}
