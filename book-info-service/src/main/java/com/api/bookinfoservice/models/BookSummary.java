package com.api.bookinfoservice.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.Date;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookSummary {

    @JsonSerialize(using = ToStringSerializer.class)
    private String id;
    private String author;
    private String overview;
    private Date createdAt = new Date();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "BookSummary{" + "id=" + id + ", author='" + author + '\'' + ", overview='\" + overview + '\\'' + \", createdAt=" + createdAt + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        BookSummary bookSummary = (BookSummary) o;
        return  Objects.equals(id, bookSummary.id) && Objects.equals(author,
                bookSummary.author) && Objects.equals(overview,
                bookSummary.overview) && Objects.equals(createdAt, bookSummary.createdAt) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, overview, createdAt);
    }

}
