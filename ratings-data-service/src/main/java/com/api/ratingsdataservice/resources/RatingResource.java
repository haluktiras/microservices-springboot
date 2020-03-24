package com.api.ratingsdataservice.resources;

import com.api.ratingsdataservice.models.Rating;
import com.api.ratingsdataservice.models.UserRating;
import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class RatingResource implements IRatingResource {
    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();

    @Autowired
    private MongoClient client;

    private MongoCollection<Rating> ratingCollection;
    private MongoCollection<UserRating> userRatingCollection;

    @PostConstruct
    void init() {
        ratingCollection = client.getDatabase("test").getCollection("rating", Rating.class);
        userRatingCollection = client.getDatabase("test").getCollection("userRating",UserRating.class);
    }

    @Override
    public Rating save(Rating rating) {
        ratingCollection.insertOne(rating);
        return rating;
    }

    @Override
    public UserRating findUserRating(String id) {
        return userRatingCollection.find(eq("userId", id)).first();
    }

    @Override
    public UserRating save(UserRating userRating) {
        userRatingCollection.insertOne(userRating);
        return userRating;
    }

    @Override
    public Rating findOne(String id) {
        return ratingCollection.find(eq("bookId", id)).first();
    }

}
