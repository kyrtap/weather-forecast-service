package me.brzoza.weatherforecastservice.models.pollution;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PollutionElement {
    @JsonAlias("dt")
    public Instant time;

    public AirQuality airQualityIndex;

    @JsonProperty("main")
    public void mainDeserializer(Map<String, Object> main) {
        this.airQualityIndex = AirQuality.fromInteger((Integer) main.get("aqi"));
    }

    public double co;
    public double no;
    public double no2;
    public double o3;
    public double so2;
    public double pm2_5;
    public double pm10;
    public double nh3;

    @JsonProperty("components")
    public void componentsDeserializer(Map<String, Object> components) {
        this.co = (Double) components.get("co");
        this.no = (Double) components.get("no");
        this.no2 = (Double) components.get("no2");
        this.o3 = (Double) components.get("o3");
        this.so2 = (Double) components.get("so2");
        this.pm2_5 = (Double) components.get("pm2_5");
        this.pm10 = (Double) components.get("pm10");
        this.nh3 = (Double) components.get("nh3");
    }
}
