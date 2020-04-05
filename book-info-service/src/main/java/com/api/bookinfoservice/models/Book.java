package com.api.bookinfoservice.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@Builder
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Book {

    @JsonSerialize(using = ToStringSerializer.class)
    private String bookId;
    private String name;
    private String description;
    private Date createdAt;

    @Override
    public String toString() {
        return "Book{" + "bookId=" + bookId + ", name='" + name + '\'' + ", description='" + description + '\'' + ",  createdAt=" + createdAt + '}';
    }
}


