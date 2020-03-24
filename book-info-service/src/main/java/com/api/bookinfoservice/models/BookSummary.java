package com.api.bookinfoservice.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.util.Date;
import java.util.Objects;

@NonNull
@EqualsAndHashCode
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookSummary {

    @JsonSerialize(using = ToStringSerializer.class)
    private String id;
    private String author;
    private String overview;
    private Date createdAt = new Date();

    @Override
    public String toString() {
        return "BookSummary{" + "id=" + id + ", author='" + author + '\'' + ", overview='\" + overview + '\\'' + \", createdAt=" + createdAt + '}';
    }

}
