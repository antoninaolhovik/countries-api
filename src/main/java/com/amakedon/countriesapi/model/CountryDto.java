package com.amakedon.countriesapi.model;

import java.util.List;
import java.util.Map;

public class CountryDto {

    protected NameDto name;
    private List<String> topLevelDomain;
    protected String alpha2Code;
    private String alpha3Code;
    private List<String> callingCodes;
    private List<String> capital;
    private List<String> altSpellings;
    protected String subregion;
    protected String region;
    protected Integer population;
    private List<Double> latlng;
    private String demonym;
    private Double area;
    protected Map<String, Double> gini;
    private List<String> timezones;
    protected List<String> borders;
    protected String nativeName;
    private String numericCode;
    private Map<String, String> flags;
    private String flag;
    private FlagDto coatOfArms;
    private String startOfWeek;
    private CapitalInfoDto capitalInfo;
    private Map<String, String> postalCode;

    public NameDto getName() {
        return name;
    }

    public void setName(NameDto name) {
        this.name = name;
    }

    public List<String> getTopLevelDomain() {
        return topLevelDomain;
    }

    public void setTopLevelDomain(List<String> topLevelDomain) {
        this.topLevelDomain = topLevelDomain;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public List<String> getCallingCodes() {
        return callingCodes;
    }

    public void setCallingCodes(List<String> callingCodes) {
        this.callingCodes = callingCodes;
    }

    public List<String> getCapital() {
        return capital;
    }

    public void setCapital(List<String> capital) {
        this.capital = capital;
    }

    public List<String> getAltSpellings() {
        return altSpellings;
    }

    public void setAltSpellings(List<String> altSpellings) {
        this.altSpellings = altSpellings;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public List<Double> getLatlng() {
        return latlng;
    }

    public void setLatlng(List<Double> latlng) {
        this.latlng = latlng;
    }

    public String getDemonym() {
        return demonym;
    }

    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Map<String, Double> getGini() {
        return gini;
    }

    public void setGini(Map<String, Double> gini) {
        this.gini = gini;
    }

    public List<String> getTimezones() {
        return timezones;
    }

    public void setTimezones(List<String> timezones) {
        this.timezones = timezones;
    }

    public List<String> getBorders() {
        return borders;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public Map<String, String> getFlags() {
        return flags;
    }

    public void setFlags(Map<String, String> flags) {
        this.flags = flags;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public FlagDto getCoatOfArms() {
        return coatOfArms;
    }

    public void setCoatOfArms(FlagDto coatOfArms) {
        this.coatOfArms = coatOfArms;
    }

    public String getStartOfWeek() {
        return startOfWeek;
    }

    public void setStartOfWeek(String startOfWeek) {
        this.startOfWeek = startOfWeek;
    }

    public CapitalInfoDto getCapitalInfo() {
        return capitalInfo;
    }

    public void setCapitalInfo(CapitalInfoDto capitalInfo) {
        this.capitalInfo = capitalInfo;
    }

    public Map<String, String> getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Map<String, String> postalCode) {
        this.postalCode = postalCode;
    }
}
