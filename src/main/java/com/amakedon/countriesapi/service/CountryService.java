package com.amakedon.countriesapi.service;

import com.amakedon.countriesapi.model.CountryDto;

import java.util.List;

public interface CountryService {
    List<CountryDto> getCountries(String countryName, Integer population, String sort, Integer pageSize);
}
