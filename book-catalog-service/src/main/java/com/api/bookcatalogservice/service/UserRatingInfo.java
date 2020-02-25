package com.api.bookcatalogservice.service;

import com.api.bookcatalogservice.models.Rating;
import com.api.bookcatalogservice.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class UserRatingInfo {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackUserRating")
    public UserRating getUserRating(String id) {
        return restTemplate.getForObject("http://ratings-data-service/ratings/user/" + id, UserRating.class);
    }

    private UserRating getFallbackUserRating(String id) {
        UserRating userRating = new UserRating();
        userRating.setUserId("");
        userRating.setRatings(Arrays.asList(new Rating("0",0)));
        return userRating;
    }


}



