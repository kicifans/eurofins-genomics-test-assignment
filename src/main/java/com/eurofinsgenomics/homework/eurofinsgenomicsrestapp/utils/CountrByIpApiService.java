package com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.utils;

import com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.entity.Country;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Component
public class CountrByIpApiService extends ApiService<Country>{

    ObjectMapper objectMapper = new ObjectMapper();
    private static final String url = "https://ipinfo.io/";


    @Override
    public List<Country> getObjectListFromUrl(String var) {
        return null;
    }

    //Retrieving json from url, creating Country object from it
    @Override
    public Country getObjectFromUrl(String var) throws MalformedURLException {
        URL url = new URL(CountrByIpApiService.url + var);

        try {
            return objectMapper.readValue(url, Country.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
