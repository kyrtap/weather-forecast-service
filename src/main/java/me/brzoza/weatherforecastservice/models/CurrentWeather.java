package me.brzoza.weatherforecastservice.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CurrentWeather {
    private double longitude;
    private double latitude;

    private ArrayList<WeatherDescription> weather;

    private double temperature;
    private double feelsLikeTemperature;
    private double minTemperature;
    private double maxTemperature;

    private int pressure;
    private int humidity;
    private int visibility;

    private double windSpeed;
    private int windDegrees;

    private int cloudiness;

    private Instant sunriseTime;
    private Instant sunsetTime;
    @JsonAlias("timezone")
    private int timezoneOffset;

    private Integer id;
    private String country;
    @JsonAlias("name")
    private String cityName;

    @JsonProperty("coord")
    private void coordDeserializer(Map<String, Object> coord) {
        this.longitude = (Double) coord.get("lon");
        this.latitude = (Double) coord.get("lat");
    }

    @JsonProperty("main")
    private void mainDeserializer(Map<String, Object> main) {
        this.temperature = (Double) main.get("temp");
        this.feelsLikeTemperature = (Double) main.get("feels_like");
        this.minTemperature = (Double) main.get("temp_min");
        this.maxTemperature = (Double) main.get("temp_max");

        this.pressure = (Integer) main.get("pressure");
        this.humidity = (Integer) main.get("humidity");
    }

    @JsonProperty("wind")
    private void windDeserializer(Map<String, Object> wind) {
        this.windSpeed = ((Number) wind.get("speed")).doubleValue();
        this.windDegrees = (Integer) wind.get("deg");
    }

    @JsonProperty("clouds")
    private void cloudDeserializer(Map<String, Object> clouds) {
        this.cloudiness = (Integer) clouds.get("all");
    }

    @JsonProperty("sys")
    private void sysDeserializer(Map<String, Object> sys) {
        this.sunriseTime = Instant.ofEpochSecond(((Number) sys.get("sunrise")).longValue());
        this.sunsetTime = Instant.ofEpochSecond(((Number) sys.get("sunset")).longValue());
        this.country = (String) sys.get("country");
    }
}
