package com.weather.app.service;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.weather.app.domain.Weather;
import com.weather.app.domain.WeatherInfoList;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
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

    @Retryable(maxAttempts = 5, value = RuntimeException.class, backoff = @Backoff(delay = 500, multiplier = 2))
    public List<WeatherInfoList> getWeatherByCityAndCountryCode(@NonNull String city, @NonNull String countryCode) {
        ResponseEntity<Weather> response = restTemplate.getForEntity(openWeatherMapApiUrl, Weather.class, ImmutableMap.of(
                "cityName", city,
                "countryCode", countryCode,
                "appKey", appId
        ));
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException(String.format("Response status code was %s", response.getStatusCode()));
        }
        return ImmutableList.copyOf(response.getBody().getWeatherInfoList());
    }

    @Recover
    public void recover() throws Exception {
        throw new Exception();
    }

}
