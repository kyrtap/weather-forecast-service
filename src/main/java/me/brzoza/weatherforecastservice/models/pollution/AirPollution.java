package me.brzoza.weatherforecastservice.models.pollution;

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
public class AirPollution {
    public double longitude;
    public double latitude;

    @JsonAlias("list")
    public ArrayList<PollutionElement> pollutionList;

    @JsonProperty("coord")
    public void coordDeserializer(Map<String, Object> coord) {
        this.longitude = (Double) coord.get("lon");
        this.latitude = (Double) coord.get("lat");
    }
}
