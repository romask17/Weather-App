package com.weather.app.controller;

import com.weather.app.WeatherAppApplication;
import com.weather.app.service.OpenWeatherMapService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WeatherAppApplication.class)
@WebAppConfiguration

public class WeatherControllerTest {
    @InjectMocks
    private WeatherController weatherController;

    @Mock
    private OpenWeatherMapService openWeatherMapService;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(weatherController).build();
    }

    @Test
    public void shouldGetWeather() throws Exception {
        String cityName = "Moscow";
        String countryCode = "RU";
        mockMvc.perform(get("/api/v1.0/weather/")
                        .param("cityName", cityName)
                        .param("countryCode", countryCode)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
