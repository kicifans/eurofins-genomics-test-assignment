package com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.utils;

import com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.entity.University;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Component
public class UniversitiesByCountryApiService extends ApiService<University>{

    ObjectMapper objectMapper = new ObjectMapper();
    private static final String url = "http://universities.hipolabs.com/search?country=";


    //Retrieving json list from url, creating list of University objects from it
    @Override
    public List<University> getObjectListFromUrl(String country) throws MalformedURLException {
        URL url = new URL(UniversitiesByCountryApiService.url + country);

        try {
            return Arrays.asList(objectMapper.readValue(url, University[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public University getObjectFromUrl(String country) {
        return null;
    }

}
