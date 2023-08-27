package com.amakedon.countriesapi.model;

import java.util.List;
import java.util.Map;

public class NameDto {
    private String common;
    private String official;
    private Map<String, NativeNameDto> nativeName;
    private List<String> altSpellings;

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }

    public String getOfficial() {
        return official;
    }

    public void setOfficial(String official) {
        this.official = official;
    }

    public Map<String, NativeNameDto> getNativeName() {
        return nativeName;
    }

    public void setNativeName(Map<String, NativeNameDto> nativeName) {
        this.nativeName = nativeName;
    }

    public List<String> getAltSpellings() {
        return altSpellings;
    }

    public void setAltSpellings(List<String> altSpellings) {
        this.altSpellings = altSpellings;
    }
}
