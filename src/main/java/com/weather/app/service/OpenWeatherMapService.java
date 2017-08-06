package com.weather.app.service;

import com.weather.app.model.WeatherInfoListDto;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpenWeatherMapService {
    @Autowired
    OpenWeatherMapClient openWeatherMapClient;

    public List<WeatherInfoListDto> getWeatherByCityAndCountryCode(@NonNull String city, @NonNull String countryCode) {
        return openWeatherMapClient.getWeatherByCityAndCountryCode(city, countryCode);
    }
}
