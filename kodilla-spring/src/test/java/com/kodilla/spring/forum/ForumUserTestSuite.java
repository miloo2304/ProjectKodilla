package com.kodilla.spring.forum;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ForumUserTestSuite {

    @Autowired
    private ForumUser forumUser;

    @Test
    void testGetUsername() {
        String username = forumUser.getUsername();
        assertEquals("John Smith", username);
    }


}