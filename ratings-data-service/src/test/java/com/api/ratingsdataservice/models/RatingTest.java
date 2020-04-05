package com.api.ratingsdataservice.models;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class RatingTest {

    public static final String EXPECTED_BOOK_ID = "1";
    public static final int EXPECTED_RATING = 2;
    public static final Date EXPECTED_DATE = Calendar.getInstance().getTime();

    public static final Rating rating = Rating.builder()
            .bookId("1")
            .rating(2)
            .createdAt(Calendar.getInstance().getTime())
            .build();

    public static final Rating rating2 = Rating.builder()
            .bookId("2")
            .rating(3)
            .createdAt(Calendar.getInstance().getTime())
            .build();

    public static final Rating rating3 = Rating.builder()
            .bookId("3")
            .rating(4)
            .createdAt(Calendar.getInstance().getTime())
            .build();

    private String getToString(String bookId, int rating, Date createdAt){
        return "Rating{" + "bookId=" + bookId + ", rating='" + rating + '\'' + ",  createdAt=" + createdAt + '}';
    }

    @Test
    public void testRatingModelToStringMethod() {

        Assert.assertEquals(rating.toString(), getToString("1", 2, Calendar.getInstance().getTime()));
        Assert.assertEquals(rating2.toString(), getToString("2", 3, Calendar.getInstance().getTime()));
        Assert.assertEquals(rating3.toString(), getToString("3", 4, Calendar.getInstance().getTime()));
    }

    @Test
    public void testRatingModel(){

        Assert.assertEquals(rating.getBookId(), EXPECTED_BOOK_ID);
        Assert.assertEquals(rating.getRating(), EXPECTED_RATING);
        //Assert.assertEquals(rating.getCreatedAt(), EXPECTED_DATE); ::TODO Fails
    }
}