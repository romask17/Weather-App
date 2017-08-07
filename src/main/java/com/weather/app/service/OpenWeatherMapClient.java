package com.weather.app.service;

import com.google.common.collect.ImmutableMap;
import com.weather.app.domain.Weather;
import com.weather.app.domain.WeatherInfoList;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class OpenWeatherMapClient {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${application.openWeatherMapApiUrl}")
    private String openWeatherMapApiUrl;
    @Value("${application.openWeatherMapApiKey}")
    private String appId;

    public List<WeatherInfoList> getWeatherByCityAndCountryCode(@NonNull String city, @NonNull String countryCode) {

        Weather response = restTemplate.getForObject(openWeatherMapApiUrl, Weather.class, ImmutableMap.of(
                "cityName", city,
                "countryCode", countryCode,
                "appKey", appId
        ));
        return response.getWeatherInfoList();
    }
}
