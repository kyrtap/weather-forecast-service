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
public class ForecastElement {
    @JsonAlias("dt")
    public long time;
    @JsonAlias("sunrise")
    public long sunriseTime;
    @JsonAlias("sunset")
    public long sunsetTime;

    public double dayTemperature;
    public double nightTemperature;
    public double minTemperature;
    public double maxTemperature;
    public double eveningTemperature;
    public double morningTemperature;

    @JsonProperty("temp")
    public void tempDeserializer(Map<String, Object> temp) {
        this.dayTemperature = (Double) temp.get("day");
        this.nightTemperature = (Double) temp.get("night");
        this.minTemperature = (Double) temp.get("min");
        this.maxTemperature = (Double) temp.get("max");
        this.eveningTemperature = (Double) temp.get("eve");
        this.morningTemperature = (Double) temp.get("morn");
    }

    public double dayFeelsLikeTemperature;
    public double nightFeelsLikeTemperature;
    public double eveningFeelsLikeTemperature;
    public double morningFeelsLikeTemperature;

    @JsonProperty("feels_like")
    public void feelsLikeDeserializer(Map<String, Object> feelsLike) {
        this.dayFeelsLikeTemperature = (Double) feelsLike.get("day");
        this.nightFeelsLikeTemperature = (Double) feelsLike.get("night");
        this.eveningFeelsLikeTemperature = (Double) feelsLike.get("eve");
        this.morningFeelsLikeTemperature = (Double) feelsLike.get("morn");
    }

    public int pressure;
    public int humidity;

    public ArrayList<WeatherDescription> weather;

    @JsonAlias("speed")
    public double windSpeed;
    @JsonAlias("deg")
    public int windDegree;
    @JsonAlias("clouds")
    public int cloudiness;
    @JsonAlias("snow")
    public double snowVolume;
}
