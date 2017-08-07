package com.weather.app.dto;

import lombok.Data;

@Data
public class WeatherObjectDto {
    private String dateString;
    private double temperature;
    private double minimalTemp;
}
