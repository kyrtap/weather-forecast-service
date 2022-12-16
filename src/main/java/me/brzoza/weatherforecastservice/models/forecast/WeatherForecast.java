package me.brzoza.weatherforecastservice.models.forecast;

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
public class WeatherForecast {
    public Integer id;
    public String cityName;
    public int timezoneOffset;

    @JsonProperty("city")
    public void cityDeserializer(Map<String, Object> city) {
        this.id = (Integer) city.get("id");
        this.cityName = (String) city.get("name");
        this.timezoneOffset = (Integer) city.get("timezone");
    }

    @JsonAlias("cnt")
    public int forecastDayCount;

    @JsonAlias("list")
    public ArrayList<ForecastElement> forecastList;
}
