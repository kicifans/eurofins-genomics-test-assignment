package com.eurofinsgenomics.homework.eurofinsgenomicsrestapp;

import com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.entity.University;
import com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.utils.UniversitiesByCountryApiService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.util.List;
import java.util.stream.Collectors;

public class UniversityByCountryTest {

    @Test
    //test if university count from manual search is the same as application received list size
    public void testUniversityListSize() throws MalformedURLException {
        int lvUniversityCount = 44;
        UniversitiesByCountryApiService universitiesByCountryApiService = new UniversitiesByCountryApiService();
        Assert.assertEquals(lvUniversityCount, universitiesByCountryApiService.getObjectListFromUrl("latvia").size());
    }

    @Test
    //check if Latvia university names from manual search are the same as application received list university names
    public void testUniversityListNames() throws MalformedURLException {
        List<String> universityNames = List.of(
                "Medical Academy of Latvia",
                "School of Business and Finance",
                "Baltic International Academy",
                "Liepaja Pedagogical Higher School",
                "Daugavpils University",
                "Latvian Maritime Academy",
                "Latvian Academy of Culture",
                "Latvian University of Agriculture",
                "Latvian Academy of Arts",
                "Latvian Academy of Music",
                "Latvian Academy of Sports Education",
                "University of Latvia",
                "National Defence Academy of Latvia",
                "Police Academy of Latvia",
                "Higher School of Psychology",
                "Riga Aviation University",
                "Riga Teacher Training and Educational Management Academy",
                "Riga Technical University",
                "Rezekne Higher School",
                "Stockholm School of Economics in Riga",
                "Transport and Telecommunication Institute",
                "Vidzeme University College",
                "Medical Academy of Latvia",
                "School of Business and Finance",
                "Baltic International Academy",
                "Liepaja Pedagogical Higher School",
                "Daugavpils University",
                "Latvian Maritime Academy",
                "Latvian Academy of Culture",
                "Latvian University of Agriculture",
                "Latvian Academy of Arts",
                "Latvian Academy of Music",
                "Latvian Academy of Sports Education",
                "University of Latvia",
                "National Defence Academy of Latvia",
                "Police Academy of Latvia",
                "Higher School of Psychology",
                "Riga Aviation University",
                "Riga Teacher Training and Educational Management Academy",
                "Riga Technical University",
                "Rezekne Higher School",
                "Stockholm School of Economics in Riga",
                "Transport and Telecommunication Institute",
                "Vidzeme University College"
        );

        UniversitiesByCountryApiService universitiesByCountryApiService = new UniversitiesByCountryApiService();
        Assert.assertEquals(universityNames, universitiesByCountryApiService.getObjectListFromUrl("latvia").stream().map(University::getName).collect(Collectors.toList()));
    }
}
