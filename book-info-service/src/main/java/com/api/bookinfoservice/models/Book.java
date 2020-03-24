package com.api.bookinfoservice.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Book {

    @JsonSerialize(using = ToStringSerializer.class)
    private String bookId;
    private String name;
    private String description;
    private Date createdAt = new Date();

    @Override
    public String toString() {
        return "Book{" + "bookId=" + bookId + ", name='" + name + '\'' + ", description='" + description + '\'' + ",  createdAt=" + createdAt + '}';
    }
}


