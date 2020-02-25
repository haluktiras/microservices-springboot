package com.api.ratingsdataservice.resources;

import com.api.ratingsdataservice.models.Rating;
import com.api.ratingsdataservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import static com.mongodb.client.model.Filters.eq;

@RestController
@RequestMapping("/ratings")
public class RatingApi {

    private final IRatingResource ratingResource;

    public RatingApi( IRatingResource ratingResource) {
        this.ratingResource = ratingResource;
    }

    @RequestMapping("/book/{id}")
    public Rating getBookRating(@PathVariable("id") String id) {
        return ratingResource.findOne(id);
    }

    @PostMapping("book")
    @ResponseStatus(HttpStatus.CREATED)
    public Rating postBookRating(@RequestBody Rating rating) {
        return ratingResource.save(rating);
    }

    @RequestMapping("/user/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String userId) {
        return ratingResource.findUserRating(userId);
    }

    @PostMapping("user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserRating postUserRating(@RequestBody UserRating userRating) {
        return ratingResource.save(userRating);
    }

}
