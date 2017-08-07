package com.weather.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {
    @JsonProperty("day")
    private double dayTemperature;
    @JsonProperty("min")
    private double minimalTemperature;
    @JsonProperty("max")
    private double maximumTemperature;
    @JsonProperty("night")
    private double nightTemperature;
}