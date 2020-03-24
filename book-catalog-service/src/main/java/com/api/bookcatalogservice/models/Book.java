package com.api.bookcatalogservice.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NonNull
@RequiredArgsConstructor
public class Book {
    private String bookId;
    private String name;
    private String description;
}
