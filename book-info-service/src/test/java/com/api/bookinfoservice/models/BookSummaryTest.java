package com.api.bookinfoservice.models;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

class BookSummaryTest {

    public static final Date NOW = Calendar.getInstance().getTime();

    public static final String EXPECTED_ID = "1";
    public static final String EXPECTED_AUTHOR = "hebeleHubele";
    public static final String EXPECTED_OVERVIEW = "hebele hubele kubele zubele";

    public static final BookSummary buildedBookSummary = BookSummary.builder()
            .id("1")
            .author("hebeleHubele")
            .overview("hebele hubele kubele zubele")
            .createdAt(NOW)
            .build();

    @Test
    public void bookModelTest() {

        Assert.assertEquals(EXPECTED_ID, buildedBookSummary.getId());
        Assert.assertEquals(EXPECTED_AUTHOR, buildedBookSummary.getAuthor());
        Assert.assertEquals(EXPECTED_OVERVIEW, buildedBookSummary.getOverview());
    }

    @Test
    public void bookBuilderTest() {

        BookSummary constrBookSummary = new BookSummary("1", "hebeleHubele", "hebele hubele kubele zubele", NOW);

        Assert.assertEquals(constrBookSummary, buildedBookSummary);
    }

}