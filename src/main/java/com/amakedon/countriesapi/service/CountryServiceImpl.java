package com.amakedon.countriesapi.service;

import com.amakedon.countriesapi.model.CountryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

@Service
public class CountryServiceImpl implements CountryService {
    public static final String RESOURCE_URL = "/v3.1/all";
    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<CountryDto> getCountries(String countryName, Integer population, String sort, Integer pageSize) {

        ResponseEntity<CountryDto[]> response =
                restTemplate.getForEntity(
                        RESOURCE_URL,
                        CountryDto[].class);
        CountryDto[] countriesList = response.getBody();
        return List.of(countriesList);
    }

    public List<CountryDto> filterCountriesByName(String countryName, List<CountryDto> countries) {
        return countries.stream()
                .filter(country -> country.getName().getCommon().toLowerCase().contains(countryName.toLowerCase()))
                .toList();
    }

    private List<CountryDto> filterByPopulation(Integer population, List<CountryDto> countries) {
        final long MILLION = 1000000L;
        long populationInMillion = population * MILLION;
        return countries.stream()
                .filter(country -> country.getPopulation() < populationInMillion)
                .toList();
    }

    public static List<CountryDto> sortByCountryName(String sortOrder, List<CountryDto> countries) {
        List<CountryDto> sortedCountries = new ArrayList<>(countries);
        Function<CountryDto, String> countryDtoStringFunction = c -> c.getName().getCommon();

        if ("ascend".equalsIgnoreCase(sortOrder)) {
            Collections.sort(sortedCountries, Comparator.comparing(countryDtoStringFunction));
        } else if ("descend".equalsIgnoreCase(sortOrder)) {
            Collections.sort(sortedCountries, Comparator.comparing(countryDtoStringFunction).reversed());
        } else {
            throw new IllegalArgumentException("Invalid sorting order value, 'ascend' or 'descend' are allowed");
        }
        return sortedCountries;
    }


}
