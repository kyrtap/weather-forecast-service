package me.brzoza.weatherforecastservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CurrentWeather {
    private double lon;
    private double lat;
    private String weatherMain;

    private double temp;
    private double tempMin;
    private double tempMax;

    private int pressure;
    private int humidity;

    private double windSpeed;

    private String id;
    private String name;
}
