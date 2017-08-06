package com.weather.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherInfoListDto {
    @JsonProperty("dt")
    private Date date;
    @JsonProperty("temp")
    private TemperatureDto temperature;
    private double pressure;
    private double humidity;
    private double speed;
    private double deg;
    private double clouds;
}
