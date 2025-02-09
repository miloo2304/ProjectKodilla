package com.kodilla.testing.Project_6_7.Forum.mock;

import com.kodilla.testing.Project_6_7.Statistics;
import com.kodilla.testing.Project_6_7.CountImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.ArgumentMatchers.anyString;


@ExtendWith(MockitoExtension.class)
class ForumDirectoryTestSuite {

    @Mock
    private Statistics statisticsMock;

    private CountImpl countImpl;

    @BeforeEach
    void setUp() {
        countImpl = new CountImpl();
    }

    @Test
    void testCalculateAdvStatisticsWithZeroPosts() {
        // Given
        List<String> users = Arrays.asList("User1", "User2", "User3");
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(10);

        // When
        countImpl.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(3, countImpl.getUsersCount());
        assertEquals(0, countImpl.getPostsCount());
        assertEquals(10, countImpl.getCommentsCount());
        assertEquals(0, countImpl.getAvgPostsPerUser(), "Avg posts per user should be 0");
        assertEquals(3.33, countImpl.getAvgCommentsPerUser(), 0.01, "Avg comments per user should be 3.33");
    }

    @Test
    void testCalculateAdvStatisticsWithMoreCommentsThanPosts() {
        // Given
        List<String> users = Arrays.asList("User1", "User2", "User3");
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(5);
        when(statisticsMock.commentsCount()).thenReturn(15);

        // When
        countImpl.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(3, countImpl.getUsersCount());
        assertEquals(5, countImpl.getPostsCount());
        assertEquals(15, countImpl.getCommentsCount());
        assertEquals(1.66, countImpl.getAvgPostsPerUser(), 0.01);
        assertEquals(5.0, countImpl.getAvgCommentsPerUser(), 0.01);
        assertEquals(3.0, countImpl.getAvgCommentsPerPost(), 0.01);
    }

    @Test
    void testCalculateAdvStatisticsWithZeroUsers() {
        // Given
        List<String> users = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(5);

        // When
        countImpl.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(0, countImpl.getUsersCount());
        assertEquals(10, countImpl.getPostsCount());
        assertEquals(5, countImpl.getCommentsCount());
        assertEquals(0, countImpl.getAvgPostsPerUser());
        assertEquals(0, countImpl.getAvgCommentsPerUser());
    }
}