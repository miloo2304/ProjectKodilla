package com.kodilla.testing.Project_6_7;
import java.util.*;
public class StoryStatistics implements Statistics {
    private  List<String> users;
    private  int posts;
    private  int comments;

    public StoryStatistics(List<String> users, int posts, int comments) {
        this.users = users;
        this.posts = posts;
        this.comments = comments;
    }

    @Override
    public List<String> usersNames() {
        return users;
    }

    @Override
    public int postsCount() {
        return posts;
    }

    @Override
    public int commentsCount() {
        return comments;
    }
}