package com.api.bookcatalogservice.models;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@NonNull
public class Book {
    private String bookId;
    private String name;
    private String description;
}
