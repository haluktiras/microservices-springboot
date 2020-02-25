package com.api.ratingsdataservice.resources;

import com.api.ratingsdataservice.models.Rating;
import com.api.ratingsdataservice.models.UserRating;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRatingResource {

    Rating findOne(String id);

    Rating save(Rating rating);

    UserRating findUserRating(String id);

    UserRating save(UserRating userRating);

}
