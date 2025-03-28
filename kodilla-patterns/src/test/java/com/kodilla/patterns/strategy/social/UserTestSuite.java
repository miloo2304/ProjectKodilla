package com.kodilla.patterns.strategy.social;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        // Given
        User millenial = new Millenials("John Smith");
        User yGeneration = new YGeneration("Anna YGen");
        User zGeneration = new ZGeneration("Tom ZGen");

        // When
        String millenialShare = millenial.sharePost();
        String yGenerationShare = yGeneration.sharePost();
        String zGenerationShare = zGeneration.sharePost();

        // Then
        assertEquals("Facebook", millenialShare);
        assertEquals("Twitter", yGenerationShare);
        assertEquals("Snapchat", zGenerationShare);
    }

    @Test
    void testIndividualSharingStrategy() {
        // Given
        User user = new Millenials("John Smith");

        // When
        String defaultShare = user.sharePost();
        user.setSocialPublisher(new TwitterPublisher());
        String changedShare = user.sharePost();

        // Then
        assertEquals("Facebook", defaultShare);
        assertEquals("Twitter", changedShare);
    }
}

