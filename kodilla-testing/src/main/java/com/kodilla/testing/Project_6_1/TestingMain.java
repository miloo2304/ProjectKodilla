package com.kodilla.testing.Project_6_1;

import com.kodilla.testing.Project_6_3.OddNumbersExterminator;
import com.kodilla.testing.Project_6_5.Temperatures;
import com.kodilla.testing.Project_6_5.WeatherForecast;
import com.kodilla.testing.Project_6_5.WeatherData;
import java.util.*;
public class TestingMain {
    public static void main(String[] args) {
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> result = exterminator.exterminate(exterminator.getNumbers());
        System.out.println("Even numbers: " + result);

        //Project_6_5
        WeatherData weatherData = new WeatherData();
        WeatherForecast forecast = new WeatherForecast(weatherData);

        Map<String, Double> map = forecast.calculateForecast();
        System.out.println("Map include: " + map);

        double average = forecast.calculateAverageTemperature();
        System.out.println("Average Temperature: " + average);

        double median = forecast.calculateMedianTemperature();
        System.out.println("Median Temperature: " + median);



    }
}
