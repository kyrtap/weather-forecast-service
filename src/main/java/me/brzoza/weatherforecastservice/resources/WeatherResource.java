package me.brzoza.weatherforecastservice.resources;

import me.brzoza.weatherforecastservice.models.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weather")
public class WeatherResource {
    @Autowired
    private RestTemplate restTemplate;

    public CurrentWeather getCurrentWeather() {
        // TODO
        return null;
    }

}
