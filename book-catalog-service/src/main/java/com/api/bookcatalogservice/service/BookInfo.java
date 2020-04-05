package com.api.bookcatalogservice.service;

import com.api.bookcatalogservice.models.Book;
import com.api.bookcatalogservice.models.Catalog;
import com.api.bookcatalogservice.models.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class BookInfo {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
    public Catalog getCatalogItem(Rating rating) {
        Book book = restTemplate.getForObject("http://book-info-service/books/" + rating.getBookId(), Book.class);
        return Catalog.builder()
                .name(book.getName())
                .desc(book.getDescription())
                .rating(rating.getRating())
                .build();
    }

    private Catalog getFallbackCatalogItem(Rating rating) {
        return Catalog.builder()
                .name("Book name not")
                .desc("")
                .rating(rating.getRating())
                .build();
    }

}
/*
Alternative WebClient way
Book book = webClientBuilder.build().get().uri("http://book-info-service/books/"+ rating.getBookId())
.retrieve().bodyToMono(Book.class).block();
*/

