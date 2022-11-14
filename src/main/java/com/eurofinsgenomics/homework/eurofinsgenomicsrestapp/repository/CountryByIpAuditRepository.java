package com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.repository;

import com.eurofinsgenomics.homework.eurofinsgenomicsrestapp.entity.CountryByIpAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryByIpAuditRepository extends JpaRepository<CountryByIpAudit, Integer> {
}
