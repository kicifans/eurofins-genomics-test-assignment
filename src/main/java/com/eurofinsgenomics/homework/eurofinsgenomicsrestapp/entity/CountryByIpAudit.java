package com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class CountryByIpAudit {
    @Id
    @GeneratedValue
    private int id;
    private String ip;
    private String country;
    private String city;
    private String location;

    public CountryByIpAudit(String ip, String country, String city, String location) {
        this.ip = ip;
        this.country = country;
        this.city = city;
        this.location = location;
    }
}
