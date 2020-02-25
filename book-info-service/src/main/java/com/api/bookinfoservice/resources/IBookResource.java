package com.api.bookinfoservice.resources;

import com.api.bookinfoservice.models.Book;
import com.api.bookinfoservice.models.BookSummary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookResource {

    Book findOne(String id);

    Book save(Book book);

    List<Book> findAll();

    List<Book> saveAll(List<Book> books);

    long count();

    long delete(String id);

    long deleteAll();

    Book update(Book book);

    BookSummary findOneSummary(String id);

    BookSummary save(BookSummary bookSummary);
}
