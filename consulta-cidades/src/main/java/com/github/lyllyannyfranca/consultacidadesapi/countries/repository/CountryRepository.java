package com.github.lyllyannyfranca.consultacidadesapi.countries.repository;

import com.github.lyllyannyfranca.consultacidadesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
