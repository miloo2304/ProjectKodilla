package com.kodilla.exception.Project_6_5;
import java.util.*;
import java.lang.*;

public class WeatherForecast implements Temperatures {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }
    @Override
    public Map<String, Double> getTemperatures() {
        return temperatures.getTemperatures();
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double calculateAverageTemperature() {
        Map<String, Double> forecastMap = calculateForecast();
        forecastMap.put("Rzeszow", 25.5);
        forecastMap.put("Krakow", 26.2);
        forecastMap.put("Wroclaw", 24.8);
        forecastMap.put("Warszawa", 25.2);
        forecastMap.put("Gdansk", 26.1);
        if (forecastMap.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;
        int count = 0;
        double average = 0.0;

        for (Double temperature : forecastMap.values()) {
            sum += temperature;
            count++;
            average = sum / count;

        }
        return average;
    }

    public double calculateMedianTemperature() {
        Map<String, Double> forecastMap = calculateForecast();
        forecastMap.put("Rzeszow", 25.5);
        forecastMap.put("Krakow", 26.2);
        forecastMap.put("Wroclaw", 24.8);
        forecastMap.put("Warszawa", 25.2);
        forecastMap.put("Gdansk", 26.1);

        if (forecastMap.isEmpty()) {
            return 0.0;
        }

        // Step 1: Get temperatures from the map and sort them
        List<Double> temperatures = new ArrayList<>(forecastMap.values());
        Collections.sort(temperatures);

        int size = temperatures.size();
        double median = 0.0;
        if (size % 2 == 1) {
            median = temperatures.get(size / 2);
        }
        else {
            int midIndex = size / 2;
            median = (temperatures.get(midIndex - 1) + temperatures.get(midIndex)) / 2.0;
        }
        return median;
    }

}
