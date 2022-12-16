package me.brzoza.weatherforecastservice.services;

import me.brzoza.weatherforecastservice.models.CurrentWeather;
import me.brzoza.weatherforecastservice.models.WeatherForecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class WeatherService {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${api.key}")
    private String apiKey;
    private final String apiUrl = "https://api.openweathermap.org/data/2.5";


    public CurrentWeather getCurrentWeather(String cityName, Optional<String> units, Optional<String> lang) {
        String queryUrl = apiUrl;

        queryUrl += "/weather?q=" + cityName + "&appid=" + apiKey;

        if (units.isPresent())
            queryUrl += "&units=" + units;
        else
            queryUrl += "&units=metric";

        if (lang.isPresent())
            queryUrl += "&lang=" + lang;

        return restTemplate.getForObject(queryUrl, CurrentWeather.class);
    }

    public WeatherForecast getWeatherForecast(String cityName, Optional<String> units, Optional<String> lang) {
        String queryUrl = apiUrl;

        queryUrl += "/forecast/daily?q=" + cityName + "&appid=" + apiKey;

        if (units.isPresent())
            queryUrl += "&units=" + units;
        else
            queryUrl += "&units=metric";

        if (lang.isPresent())
            queryUrl += "&lang=" + lang;

        return restTemplate.getForObject(queryUrl, WeatherForecast.class);
    }
}
