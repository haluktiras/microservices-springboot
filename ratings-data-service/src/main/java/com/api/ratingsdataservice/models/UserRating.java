package com.api.ratingsdataservice.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRating {

    @JsonSerialize(using = ToStringSerializer.class)
    private String userId;
    private List<Rating> ratings;
    private Date createdAt = new Date();
}
