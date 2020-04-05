package com.api.bookcatalogservice.models;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CatalogTest {

    public static final String EXPECTED_NAME = "hebele";
    public static final String EXPECTED_DESC = "hubele kebele zubele";
    public static final int EXPECTED_RATING = 3;

    public static final Catalog BUILDED_CATALOG = Catalog.builder()
            .name("hebele")
            .desc("hubele kebele zubele")
            .rating(3)
            .build();

    @Test
    public void catalogModelTest(){
        Assert.assertEquals(EXPECTED_NAME, BUILDED_CATALOG.getName());
        Assert.assertEquals(EXPECTED_DESC, BUILDED_CATALOG.getDesc());
        Assert.assertEquals(EXPECTED_RATING, BUILDED_CATALOG.getRating());
    }

    @Test
    public void catalogBuilderTest(){
        Catalog constructedCatalog = new Catalog("hebele", "hubele kebele zubele", 3);

        Assert.assertEquals(constructedCatalog, BUILDED_CATALOG);
    }

}