package com.kodilla.testing.Project_6_5;
import java.util.*;

public class WeatherData implements Temperatures {

    @Override
    public Map<String, Double> getTemperatures() {
        Map<String, Double> weatherResult = new HashMap<>();
        weatherResult.put("Rzeszow", 25.5);
        weatherResult.put("Krakow", 26.2);
        weatherResult.put("Wroclaw", 24.8);
        weatherResult.put("Warszawa", 25.2);
        weatherResult.put("Gdansk", 26.1);
        return weatherResult;
    }
}
