package com.amakedon.countriesapi.service;

import com.amakedon.countriesapi.model.CountryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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
}
