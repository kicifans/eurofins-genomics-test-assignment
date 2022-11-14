package com.eurofinsgenomics.homework.eurofinsgenomicsrestapp;

import com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.entity.Country;
import com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.utils.CountrByIpApiService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

public class IpCountryTest {


    @Test
    //Testing if api call returns same Country as that we can get manually
    public void testEqualCountry() throws MalformedURLException {
        Country testCountry = new Country("Bellevue","Washington","US","47.5614,-122.1552","AS21928 T-Mobile USA, Inc.");

        CountrByIpApiService countrByIpApiService = new CountrByIpApiService();
        Country countryFromJson = countrByIpApiService.getObjectFromUrl("100.219.85.6/geo");
        Assert.assertEquals(testCountry, countryFromJson);

    }
}
