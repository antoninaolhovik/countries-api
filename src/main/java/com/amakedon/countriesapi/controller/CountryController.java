package com.amakedon.countriesapi.controller;

import com.amakedon.countriesapi.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping
    public Iterable getCountries(@RequestParam(required = false) String countryName,
                                 @RequestParam(required = false) Integer population,
                                 @RequestParam(required = false) String sort,
                                 @RequestParam(required = false) Integer pageSize) {
        return countryService.getCountries(countryName, population, sort, pageSize);
    }

}
