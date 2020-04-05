package com.api.bookcatalogservice.models;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class Rating {

    private @NonNull String bookId;
    private @NonNull int rating;
}
