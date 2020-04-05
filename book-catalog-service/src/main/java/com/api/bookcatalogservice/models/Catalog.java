package com.api.bookcatalogservice.models;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class Catalog {
    private @NonNull String name;
    private @NonNull String desc;
    private @NonNull int rating;
}
