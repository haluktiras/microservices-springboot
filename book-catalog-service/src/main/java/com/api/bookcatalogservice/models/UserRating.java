package com.api.bookcatalogservice.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserRating {

    private String userId;
    private List<Rating> ratings;

}
