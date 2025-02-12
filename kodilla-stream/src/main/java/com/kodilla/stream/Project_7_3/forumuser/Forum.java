package com.kodilla.stream.Project_7_3.forumuser;
import java.util.*;
import java.util.stream.*;
import java.time.*;


public class Forum {
    private List<ForumUser> users = new ArrayList<>();

    public Forum() {
        users.add(new ForumUser(1, "John Smith", 'M', LocalDate.of(2000, 1, 15), 5));
        users.add(new ForumUser(2, "Alice Smith", 'F', LocalDate.of(1995, 2, 20), 3));
        users.add(new ForumUser(3, "Emily Wonder", 'F', LocalDate.of(2004, 4, 25), 0));
        users.add(new ForumUser(4, "Bob Smith", 'M', LocalDate.of(2002, 5, 5), 1));
        users.add(new ForumUser(5, "Charlie ThreeSixty", 'F', LocalDate.of(1999, 4, 23), 11));
        users.add(new ForumUser(6, "Donald Junior",'M', LocalDate.of(2025, 1, 15),4));
    }

    public List<ForumUser> getUserList() {
        return users;
    }
}
