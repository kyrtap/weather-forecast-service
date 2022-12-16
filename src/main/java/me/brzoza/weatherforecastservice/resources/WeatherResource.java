package me.brzoza.weatherforecastservice.resources;

import me.brzoza.weatherforecastservice.models.CurrentWeather;
import me.brzoza.weatherforecastservice.models.WeatherForecast;
import me.brzoza.weatherforecastservice.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/weather")
public class WeatherResource {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/current")
    public CurrentWeather getCurrentWeather(@RequestParam String cityName, @RequestParam(required = false) Optional<String> units, @RequestParam(required = false) Optional<String> lang) {
        return weatherService.getCurrentWeather(cityName, units, lang);

    }

    @GetMapping("/forecast")
    public WeatherForecast getWeatherForecase(@RequestParam String cityName, @RequestParam(required = false) Optional<String> units, @RequestParam(required = false) Optional<String> lang) {
        return weatherService.getWeatherForecast(cityName, units, lang);
    }

}
