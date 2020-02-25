package com.api.bookinfoservice.resources;

import com.api.bookinfoservice.models.Book;
import com.api.bookinfoservice.models.BookSummary;
import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.ClientSession;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("/books")
public class BookApi {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    private final IBookResource bookResource;

    public BookApi(IBookResource bookResource) {
        this.bookResource = bookResource;
    }

    /* book mappings */
    @GetMapping("{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") String id) {
        Book book = bookResource.findOne(id);
        if (book == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(book);
        // BookSummary bookSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + bookId + "?api_key=" + apiKey, BookSummary.class);
    }

    @PostMapping("book")
    @ResponseStatus(HttpStatus.CREATED)
    public Book postBook(@RequestBody Book book) {
        return bookResource.save(book);
    }

    @GetMapping("books")
    public List<Book> getAllBooks() {
        return bookResource.findAll();
    }

    @PostMapping("books")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Book> postAllBooks(@RequestBody List<Book> books) {
        return bookResource.saveAll(books);
    }

    @GetMapping("count")
    public Long getCount() {
        return bookResource.count();
    }

    @DeleteMapping("book/{id}")
    public Long deleteBook(@PathVariable String id)
    {
        return bookResource.delete(id);
    }

    @DeleteMapping("books")
    public Long deleteBooks() {
        return bookResource.deleteAll();
    }

    @PutMapping("book")
    public Book putBook(@RequestBody Book book) {
        return bookResource.update(book);
    }


    /* book summary mappings */
    @RequestMapping("summary/{id}")
    public BookSummary getBookSummaryInfo(@PathVariable("id") String id) {
        return bookResource.findOneSummary(id);
    }

    @PostMapping("summary")
    @ResponseStatus(HttpStatus.CREATED)
    public BookSummary postBookSummary(@RequestBody BookSummary bookSummary) {
        return bookResource.save(bookSummary);
    }

}
