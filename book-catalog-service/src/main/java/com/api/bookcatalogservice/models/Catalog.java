package com.api.bookcatalogservice.models;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Catalog {
    @NonNull private String name;
    @NonNull private String desc;
    @NonNull private int rating;
}
