package com.kodilla.stream.Project_7_3.forumuser;
import java.time.*;


public class ForumUser {
    private int id;
    private String username;
    private char gender;
    private LocalDate birthDate;
    private int postCount;

    public ForumUser(int id, String username, char gender, LocalDate birthDate, int postCount) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.birthDate = birthDate;
        this.postCount = postCount;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostCount() {
        return postCount;
    }

    public int getAge() {
        Period period = Period.between(birthDate, LocalDate.now());
        return period.getYears(); //Class Period from java.time to getAge
    }

    @Override
    public String toString() {
        return "*** ID: " + id + ", Username: " + username + ", Gender: " + gender + ", Age: " +
                getAge() + ", Posts: " + postCount + " ***";
    }
}