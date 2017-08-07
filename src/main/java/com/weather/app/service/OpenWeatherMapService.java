package com.weather.app.service;

import com.google.common.collect.ImmutableList;
import com.weather.app.dto.WeatherObjectDto;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

@Service
public class OpenWeatherMapService {
    @Autowired
    private OpenWeatherMapClient openWeatherMapClient;
    @Autowired
    private WeatherObjectConverter weatherObjectConverter;

    public ImmutableList<WeatherObjectDto> getWeatherByCityAndCountryCode(@NonNull String city, @NonNull String countryCode) {

        ImmutableList<WeatherObjectDto> result = openWeatherMapClient.getWeatherByCityAndCountryCode(city, countryCode)
                .stream()
                .map(weatherObjectConverter::toWeatherObject)
                .collect(collectingAndThen(toList(), ImmutableList::copyOf));
        return result;
    }
}
