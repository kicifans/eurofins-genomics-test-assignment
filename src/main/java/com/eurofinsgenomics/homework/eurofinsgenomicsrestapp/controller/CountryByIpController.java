package com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.controller;

import com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.entity.Country;
import com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.entity.CountryByIpAudit;
import com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.exceptions.InvalidIpException;
import com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.service.CountryByIpAuditService;
import com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.utils.CountrByIpApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.util.regex.Pattern;


@RestController
public class CountryByIpController {

    @Autowired
    private CountryByIpAuditService countryByIpAuditService;
    @Autowired
    private CountrByIpApiService countrByIpApiService;
    private String urlEnding = "/geo";

    //retrieving country by ip address
    @GetMapping("/country-by-ip/{ip}")
    public Country findCountryByIp(@PathVariable String ip) throws MalformedURLException, InvalidIpException {

        boolean isValidIp = Pattern.matches("^((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)\\.?\\b){4}$", ip);

        if(isValidIp) {
            Country countryFromJson = countrByIpApiService.getObjectFromUrl(ip + urlEnding);
            //creating new Object, to insert in ip_country_audit table
            CountryByIpAudit countryByIpAudit = new CountryByIpAudit(ip, countryFromJson.getCountry(),countryFromJson.getCity(),countryFromJson.getLoc());
            countryByIpAuditService.saveIpCountry(countryByIpAudit);
            return countryFromJson;
        } else {
            throw new InvalidIpException();
        }
    }

    //basic error handler to show message if ip address pattern is wrong.
    @ExceptionHandler({InvalidIpException.class})
    public String handleException() {
        return "Invalid IP address!";
    }

}
