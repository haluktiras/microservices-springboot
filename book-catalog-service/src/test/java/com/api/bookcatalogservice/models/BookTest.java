package com.api.bookcatalogservice.models;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class BookTest {

    public static final String EXPECTED_ID = "1";
    public static final String EXPECTED_NAME = "hebele";
    public static final String EXPECTED_DESC = "hubele hebele kebele";

    public static final Book buildedBook = Book.builder()
            .bookId("1")
            .name("hebele")
            .description("hubele hebele kebele")
            .build();

    @Test
    public void bookModelTest() {
        Assert.assertEquals(EXPECTED_ID, buildedBook.getBookId());
        Assert.assertEquals(EXPECTED_NAME, buildedBook.getName());
        Assert.assertEquals(EXPECTED_DESC, buildedBook.getDescription());
    }

    @Test
    public void bookModelBuilderTest() {
        Book constructedBook = new Book("1", "hebele", "hubele hebele kebele");

        Assert.assertEquals(constructedBook, buildedBook);
    }

}