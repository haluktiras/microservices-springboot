package com.api.ratingsdataservice.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import java.util.Date;
import java.util.Objects;

@Data
@NonNull
@Builder
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Rating {

    @JsonSerialize(using = ToStringSerializer.class)
    private String bookId;
    private int rating;
    private Date createdAt;

    @Override
    public String toString() {
        return "Rating{" + "bookId=" + bookId + ", rating='" + rating + '\'' + ",  createdAt=" + createdAt + '}';
    }

}
