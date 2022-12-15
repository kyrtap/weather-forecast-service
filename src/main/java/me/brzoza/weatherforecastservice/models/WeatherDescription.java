package me.brzoza.weatherforecastservice.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WeatherDescription {
    private String id;
    @JsonAlias("main")
    private String mainDescription;
    @JsonAlias("description")
    private String detailedDescription;
    private String icon;
}
