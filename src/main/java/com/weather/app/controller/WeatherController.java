package com.weather.app.controller;

import com.weather.app.model.WeatherInfoListDto;
import com.weather.app.service.OpenWeatherMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1.0/")
public class WeatherController {

    @Autowired
    OpenWeatherMapService openWeatherMapService;

    @RequestMapping(value = "weather/", method = RequestMethod.GET)
    public List<WeatherInfoListDto> getWeather(@RequestParam(value = "cityName") String cityName,
                                               @RequestParam(value = "countryCode") String countryCode) {
        return openWeatherMapService.getWeatherByCityAndCountryCode(cityName, countryCode);
    }
}
