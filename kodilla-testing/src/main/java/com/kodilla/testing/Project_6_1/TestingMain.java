package com.kodilla.testing.Project_6_1;

import com.kodilla.testing.Project_6_3.OddNumbersExterminator;
import com.kodilla.testing.Project_6_5.Temperatures;
import com.kodilla.testing.Project_6_5.WeatherForecast;
import com.kodilla.testing.Project_6_5.WeatherData;
import com.kodilla.testing.Project_6_6.BookLibrary;
import com.kodilla.testing.Project_6_6.Book;
import com.kodilla.testing.Project_6_6.LibraryUser;
import com.kodilla.testing.Project_6_6.LibraryDatabase;
import com.kodilla.testing.Project_6_6.LibraryDatabaseImpl;
import com.kodilla.testing.Project_6_7.CountImpl;
import com.kodilla.testing.Project_6_7.Statistics;
import com.kodilla.testing.Project_6_7.StoryStatistics;


import java.util.*;
public class TestingMain {
    public static void main(String[] args) {

        /*
        //Project 6_3
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
        */
        /*
        //Project 6_6
        LibraryDatabase libraryDatabase = new LibraryDatabaseImpl();


        BookLibrary bookLibrary = new BookLibrary(libraryDatabase);


        LibraryUser user = new LibraryUser("John", "Smith", "12345678901");


        List<Book> books = bookLibrary.listBooksWithCondition("Java");
        System.out.println("Books found with condition 'Java':");
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }


        List<Book> userBooks = bookLibrary.listBooksInHandsOf(user);
        System.out.println("\nBooks in hands of " + user.getFirstname() + " " + user.getLastname() + ":");
        for (Book book : userBooks) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
         */
        // Project_6_7
        List<String> users = Arrays.asList("Alice", "Bob", "Charlie");
        int posts = 10;
        int comments = 5;

        Statistics storyStatistics = new StoryStatistics(users, posts, comments);
        CountImpl statisticsCalculator = new CountImpl();

        statisticsCalculator.calculateAdvStatistics(storyStatistics);
        statisticsCalculator.displayStatistics();
    }
}