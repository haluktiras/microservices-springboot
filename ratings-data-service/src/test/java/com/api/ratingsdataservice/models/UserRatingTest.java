package com.api.ratingsdataservice.models;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

class UserRatingTest {

    public static final Date NOW = Calendar.getInstance().getTime();

    public static final String EXPECTED_USER_ID = "1";
    public static final List<Rating> EXPECTED_RATING_LIST = Arrays.asList(Rating.builder().bookId("15").rating(3).createdAt(NOW).build(),
            Rating.builder().bookId("11").rating(5).createdAt(NOW).build(),
            Rating.builder().bookId("16").rating(1).createdAt(NOW).build());
    public static final Date EXPECTED_DATE = Calendar.getInstance().getTime();

    public static final UserRating userRating = UserRating.builder()
            .userId("1")
            .ratings(Arrays.asList(Rating.builder().bookId("15").rating(3).createdAt(NOW).build(),
                    Rating.builder().bookId("11").rating(5).createdAt(NOW).build(),
                    Rating.builder().bookId("16").rating(1).createdAt(NOW).build()))
            .createdAt(NOW)
            .build();

    @Test
    public void testRatingModel(){
        Assert.assertEquals(userRating.getRatings(), EXPECTED_RATING_LIST);
        Assert.assertEquals(userRating.getUserId(), EXPECTED_USER_ID);
    }

}