package com.weather.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TemperatureDto {
    @JsonProperty("day")
    private double dayTemperature;
    @JsonProperty("min")
    private double minimalTemperature;
    @JsonProperty("max")
    private double maximumTemperature;
    @JsonProperty("night")
    private double nightTemperature;
}