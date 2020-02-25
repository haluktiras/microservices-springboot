package com.api.ratingsdataservice.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.Date;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Rating {

    @JsonSerialize(using = ToStringSerializer.class)
    private String bookId;
    private int rating;
    private Date createdAt =new Date();

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Rating{" + "bookId=" + bookId + ", rating='" + rating + '\'' + ",  createdAt=" + rating + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Rating rating = (Rating) o;
        return  Objects.equals(bookId, rating.bookId) && Objects.equals(rating,
                rating.rating) &&  Objects.equals(createdAt, rating.createdAt) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, rating,createdAt);
    }

}
