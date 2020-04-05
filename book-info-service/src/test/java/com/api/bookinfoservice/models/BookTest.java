package com.api.bookinfoservice.models;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

class BookTest {

    public static final Date NOW = Calendar.getInstance().getTime();

    public static final String EXPECTED_ID = "1";
    public static final String EXPECTED_NAME = "hebeleHubele";
    public static final String EXPECTED_DESC = "hebele hubele kubele zubele";

    public static final Book buildedBook = Book.builder()
            .bookId("1")
            .name("hebeleHubele")
            .description("hebele hubele kubele zubele")
            .createdAt(NOW)
            .build();

    @Test
    public void bookModelTest() {

        Assert.assertEquals(EXPECTED_ID, buildedBook.getBookId());
        Assert.assertEquals(EXPECTED_NAME, buildedBook.getName());
        Assert.assertEquals(EXPECTED_DESC, buildedBook.getDescription());
    }

    @Test
    public void bookBuilderTest() {

        Book constrBook = new Book("1", "hebeleHubele", "hebele hubele kubele zubele", NOW);

        Assert.assertEquals(constrBook, buildedBook);
    }

}