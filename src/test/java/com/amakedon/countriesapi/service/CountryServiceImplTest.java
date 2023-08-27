package com.amakedon.countriesapi.service;

import com.amakedon.countriesapi.model.CountryDto;
import com.amakedon.countriesapi.model.NameDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class CountryServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private CountryServiceImpl countryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetCountriesByCountryWithoutParams() {
        final CountryDto countryEstonia = getCountry("Estonia", 100000);
        final CountryDto countryChina = getCountry("China", 1425671352);
        final CountryDto countryIndia = getCountry("India", 1428627663);
        final CountryDto countryUsa = getCountry("USA", 339996563);

        final CountryDto[] mockCountries = new CountryDto[] {countryEstonia, countryChina, countryIndia, countryUsa};

        ResponseEntity<CountryDto[]> responseEntity = ResponseEntity.ok(mockCountries);
        when(restTemplate.getForEntity(eq(CountryServiceImpl.RESOURCE_URL), eq(CountryDto[].class)))
                .thenReturn(responseEntity);

        List<CountryDto> actualCountries = countryService.getCountries(null, null, null, null);
        assertFalse(actualCountries.isEmpty());
        assertEquals(4, actualCountries.size());
    }

    @Test
    void testGetCountriesByCountryWithAllParams() {
        final CountryDto countryEstonia = getCountry("Estonia", 100000);
        final CountryDto countryChina = getCountry("China", 1425671352);
        final CountryDto countryIndia = getCountry("India", 1428627663);
        final CountryDto countryUsa = getCountry("USA", 339996563);

        final CountryDto[] mockCountries = new CountryDto[] {countryEstonia, countryChina, countryIndia, countryUsa};

        ResponseEntity<CountryDto[]> responseEntity = ResponseEntity.ok(mockCountries);
        when(restTemplate.getForEntity(eq(CountryServiceImpl.RESOURCE_URL), eq(CountryDto[].class)))
                .thenReturn(responseEntity);

        List<CountryDto> actualCountries = countryService.getCountries("CH", 2000, "Ascend", 5);
        assertFalse(actualCountries.isEmpty());
        assertEquals(1, actualCountries.size());
        assertEquals(countryChina, actualCountries.get(0));
    }

    @Test
    void testFilterCountriesByNameContains() {
        final CountryDto countryEstonia = getCountry("Estonia", 100000);
        final CountryDto countrySpain = getCountry("Spain", 100000);

        final List<CountryDto> mockCountries = new ArrayList<>();
        mockCountries.add(countryEstonia);
        mockCountries.add(countrySpain);

        List<CountryDto> actualCountries = countryService.filterCountriesByName("st", mockCountries);
        assertFalse(actualCountries.isEmpty());
        assertEquals(1, actualCountries.size());
        assertEquals(countryEstonia, actualCountries.get(0));
    }

    @Test
    void testFilterCountriesByNameCaseInsensitive () {
        final CountryDto countryEstonia = getCountry("Estonia", 100000);
        final CountryDto countrySpain = getCountry("Spain", 100000);

        final List<CountryDto> mockCountries = new ArrayList<>();
        mockCountries.add(countryEstonia);
        mockCountries.add(countrySpain);

        List<CountryDto> actualCountries = countryService.filterCountriesByName("PA", mockCountries);
        assertFalse(actualCountries.isEmpty());
        assertEquals(1, actualCountries.size());
        assertEquals(countrySpain, actualCountries.get(0));
    }

    @Test
    void testFilterByPopulationLessThen() {
        final CountryDto countryEstonia = getCountry("Estonia", 100000);
        final CountryDto countryChina = getCountry("China", 1425671352);
        final CountryDto countryIndia = getCountry("India", 1428627663);
        final CountryDto countryUsa = getCountry("USA", 339996563);

        final List<CountryDto> mockCountries = new ArrayList<>();
        mockCountries.add(countryEstonia);
        mockCountries.add(countryChina);
        mockCountries.add(countryIndia);
        mockCountries.add(countryUsa);

        List<CountryDto> actualCountries = countryService.filterByPopulation(10, mockCountries);
        assertFalse(actualCountries.isEmpty());
        assertEquals(1, actualCountries.size());
        assertEquals(countryEstonia, actualCountries.get(0));
    }

    @Test
    void testSortByCountryNameAscend() {
        final CountryDto countryEstonia = getCountry("Estonia", 100000);
        final CountryDto countryChina = getCountry("China", 1425671352);
        final CountryDto countryAustria = getCountry("Austria", 9027999);
        final CountryDto countryUsa = getCountry("USA", 339996563);

        final List<CountryDto> mockCountries = new ArrayList<>();
        mockCountries.add(countryEstonia);
        mockCountries.add(countryChina);
        mockCountries.add(countryAustria);
        mockCountries.add(countryUsa);

        final List<CountryDto> expectedCountries = new ArrayList<>();
        expectedCountries.add(countryAustria);
        expectedCountries.add(countryChina);
        expectedCountries.add(countryEstonia);
        expectedCountries.add(countryUsa);

        List<CountryDto> actualCountries = countryService.sortByCountryName("ascend", mockCountries);
        assertFalse(actualCountries.isEmpty());
        assertEquals(4, actualCountries.size());
        assertIterableEquals(expectedCountries, actualCountries);
    }

    @Test
    void testPagination() {
        final CountryDto countryEstonia = getCountry("Estonia", 100000);
        final CountryDto countryChina = getCountry("China", 1425671352);
        final CountryDto countryIndia = getCountry("India", 1428627663);
        final CountryDto countryUsa = getCountry("USA", 339996563);

        final List<CountryDto> mockCountries = new ArrayList<>();
        mockCountries.add(countryEstonia);
        mockCountries.add(countryChina);
        mockCountries.add(countryIndia);
        mockCountries.add(countryUsa);

        List<CountryDto> actualCountries = countryService.pagination(2, mockCountries);
        assertFalse(actualCountries.isEmpty());
        assertEquals(2, actualCountries.size());
    }
    private static CountryDto getCountry(String countryName, Integer population) {
        NameDto name = new NameDto();
        name.setCommon(countryName);
        CountryDto country = new CountryDto();
        country.setName(name);
        country.setPopulation(population);
        return country;
    }
}