package com.api.bookinfoservice.resources;

import com.api.bookinfoservice.models.Book;
import com.api.bookinfoservice.models.BookSummary;
import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReplaceOneModel;
import com.mongodb.client.model.WriteModel;
import org.bson.BsonDocument;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.in;
import static com.mongodb.client.model.ReturnDocument.AFTER;

@Repository
public class BookResource implements IBookResource {

    @Autowired
    private MongoClient client;

    private MongoCollection<Book> bookCollection;
    private MongoCollection<BookSummary> bookSummaryCollection;

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();

    @PostConstruct
    void init() {
        bookCollection = client.getDatabase("test").getCollection("book", Book.class);
        bookSummaryCollection = client.getDatabase("test").getCollection("bookSummary", BookSummary.class);
    }

    @Override
    public Book findOne(String id) {
        return bookCollection.find(eq("bookId",id)).first();
    }

    @Override
    public Book save(Book book) {
        bookCollection.insertOne(book);
        return book;
    }

    @Override
    public List<Book> findAll() {
        return bookCollection.find().into(new ArrayList<>());
    }

    @Override
    public List<Book> saveAll(List<Book> books){
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(() -> {
                bookCollection.insertMany(clientSession, books);
                return books;
            }, txnOptions);
        }
    }

    @Override
    public long count() {
        return bookCollection.countDocuments();
    }

    @Override
    public long delete(String id) {
        return bookCollection.deleteOne(eq("bookId",id)).getDeletedCount();
    }

    @Override
    public long deleteAll() {
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(
                    () -> bookCollection.deleteMany(clientSession, new BsonDocument()).getDeletedCount(), txnOptions);
        }
    }

    @Override
    public Book update(Book book) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().returnDocument(AFTER);
        return bookCollection.findOneAndReplace(eq("_id", book.getBookId()), book, options);
    }


    @Override
    public BookSummary findOneSummary(String id) {
        return bookSummaryCollection.find(eq("id",id)).first();
    }

    @Override
    public BookSummary save(BookSummary bookSummary) {
        bookSummaryCollection.insertOne(bookSummary);
        return bookSummary;
    }

}
