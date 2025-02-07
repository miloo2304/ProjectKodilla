package com.kodilla.testing.Project_6_1;

public class TestingMain {
    public static void main(String[] args) {
        FirstClass user = new FirstClass();
        String title = "Checking new PROJECT_6_1";
        System.out.println("Testing Main");
        String wynik = user.findVowels(title);
        System.out.println(wynik);
    }
}
