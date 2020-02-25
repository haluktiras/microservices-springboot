package com.api.bookinfoservice.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.Date;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Book {

    @JsonSerialize(using = ToStringSerializer.class)
    private String bookId;
    private String name;
    private String description;
    private Date createdAt = new Date();

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Book setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" + "bookId=" + bookId + ", name='" + name + '\'' + ", description='" + description + '\'' + ",  createdAt=" + createdAt + '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Book book = (Book) o;
        return  Objects.equals(bookId, book.bookId) && Objects.equals(name,
                book.name) && Objects.equals(description,
                book.description) && Objects.equals(createdAt, book.createdAt) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, name, description, createdAt);
    }
}


