package me.brzoza.weatherforecastservice.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    //private double windSpeed;
    //private int windDegrees;

    private int cloudiness;

    private String id;
    @JsonAlias("name")
    private String cityName;

    /*
    @JsonProperty("weather")
    private void weatherDeserializer(Map<String, Object> weather) {
        this.weather = weather;
    }
     */


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

    /*
    @JsonProperty("wind")
    private void windDeserializer(Map<String, Object> wind) {
        this.windSpeed = (Double) wind.get("speed");
        this.windDegrees = (Integer) wind.get("deg");
    }
     */

    @JsonProperty("clouds")
    private void cloudDeserializer(Map<String, Object> clouds) {
        this.cloudiness = (Integer) clouds.get("all");
    }
}
