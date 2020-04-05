package com.api.bookcatalogservice.models;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class UserRatingTest {

    public static final String EXPECTED_ID = "1";
    public static final List<Rating> EXPECTED_RATING_LIST = Arrays.asList(
            Rating.builder()
                    .bookId("1")
                    .rating(6)
                    .build(),
            Rating.builder()
                    .bookId("2")
                    .rating(4)
                    .build());

    public static final UserRating BUILDED_USER_RATING = UserRating.builder()
            .userId("1")
            .ratings(Arrays.asList(
                    Rating.builder()
                            .bookId("1")
                            .rating(6)
                            .build(),
                    Rating.builder()
                            .bookId("2")
                            .rating(4)
                            .build()))
            .build();

    @Test
    public void userRatingModelTest() {
        Assert.assertEquals(EXPECTED_ID, BUILDED_USER_RATING.getUserId());
        Assert.assertEquals(EXPECTED_RATING_LIST, BUILDED_USER_RATING.getRatings());
    }

    @Test
    public void userRatingBuilderTest() {
        List<Rating> ratingList = new ArrayList<>();
        ratingList.add(new Rating("1", 6));
        ratingList.add(new Rating("2", 4));
        UserRating constructedRating = new UserRating("1", ratingList);

        Assert.assertEquals(BUILDED_USER_RATING, constructedRating);
    }

}