package com.weather.app.service;

import com.weather.app.domain.WeatherInfoList;
import com.weather.app.dto.WeatherObjectDto;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Component
public class WeatherObjectConverter {
    public WeatherObjectDto toWeatherObject(@NonNull WeatherInfoList input) {
        WeatherObjectDto dto = new WeatherObjectDto();
        dto.setDateString(getHumanDateString(input.getUnixTimestamp()));
        dto.setTemperature(input.getTemperature().getDayTemperature());
        dto.setMinimalTemp(input.getTemperature().getMinimalTemperature());
        return dto;
    }

    private String getHumanDateString(long unixTimeStamp) {
        Instant weatherTime = Instant.ofEpochSecond(unixTimeStamp);
        LocalDateTime datetime = LocalDateTime.ofInstant(weatherTime, ZoneOffset.UTC);
        return DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss").format(datetime);
    }
}
