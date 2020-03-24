package com.api.ratingsdataservice.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.util.Date;
import java.util.Objects;

@Data
@NonNull
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Rating {

    @JsonSerialize(using = ToStringSerializer.class)
    private String bookId;
    private int rating;
    private Date createdAt =new Date();

    @Override
    public String toString() {
        return "Rating{" + "bookId=" + bookId + ", rating='" + rating + '\'' + ",  createdAt=" + rating + '}';
    }

}
