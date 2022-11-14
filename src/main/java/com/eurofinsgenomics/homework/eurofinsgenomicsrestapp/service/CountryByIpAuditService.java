package com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.service;

import com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.entity.CountryByIpAudit;
import com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.repository.CountryByIpAuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryByIpAuditService {

    @Autowired
    private CountryByIpAuditRepository countryByIpAuditRepository;

    public CountryByIpAudit saveIpCountry(CountryByIpAudit countryByIpAudit) {
        return countryByIpAuditRepository.save(countryByIpAudit);
    }

    public List<CountryByIpAudit> getIpCountries(){
        return countryByIpAuditRepository.findAll();
    }
}
