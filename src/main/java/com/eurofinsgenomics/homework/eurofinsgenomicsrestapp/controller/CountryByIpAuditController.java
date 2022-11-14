package com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.controller;

import com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.entity.CountryByIpAudit;
import com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.service.CountryByIpAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryByIpAuditController {

    @Autowired
    private CountryByIpAuditService countryByIpAuditService;

    //retrieving all records from ip_country_audit table
    @GetMapping("/audit")
    public List<CountryByIpAudit> findAllIpCountries(){
        return countryByIpAuditService.getIpCountries();
    }
}
