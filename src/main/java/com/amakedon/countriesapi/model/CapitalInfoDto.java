package com.amakedon.countriesapi.model;

import java.util.List;

public class CapitalInfoDto {
    private List<Double> latlng;

    public List<Double> getLatlng() {
        return latlng;
    }

    public void setLatlng(List<Double> latlng) {
        this.latlng = latlng;
    }
}
