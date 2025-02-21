package com.kodilla.exception.Project_6_1;

public class FirstClass {

    public String findVowels(String letter) {

        String samogloski = "aoeiuyAOEIOY";
        StringBuilder wynik = new StringBuilder();

        for (int i = 0; i < letter.length(); i++) {
            char ch = letter.charAt(i);

            if (samogloski.indexOf(ch) != -1) {
                wynik.append(ch);
            }
        }
        return wynik.toString();
    }

}
