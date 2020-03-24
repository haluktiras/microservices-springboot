package com.api.bookcatalogservice.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Rating {

    @NonNull private String bookId;
    @NonNull private int rating;
}
