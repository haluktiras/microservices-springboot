package com.api.bookcatalogservice.models;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class RatingTest {

    public static final String EXPECTED_ID = "1";
    public static final int EXPECTED_RATING = 5;

    public static final Rating BUILDED_RATING = Rating.builder()
            .bookId("1")
            .rating(5)
            .build();

    @Test
    public void ratingModelTest() {
        Assert.assertEquals(EXPECTED_ID, BUILDED_RATING.getBookId());
        Assert.assertEquals(EXPECTED_RATING, BUILDED_RATING.getRating());
    }

    @Test
    public void ratingBuilderTest() {
        Rating constructedRating = new Rating("1", 5);

        Assert.assertEquals(constructedRating, BUILDED_RATING);
    }

}