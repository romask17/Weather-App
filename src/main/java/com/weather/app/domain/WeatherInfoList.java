package com.weather.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherInfoList {
    @JsonProperty("dt")
    private long unixTimestamp;
    @JsonProperty("temp")
    private Temperature temperature;
    private double pressure;
    private double humidity;
    private double speed;
    private double deg;
    private double clouds;
}
