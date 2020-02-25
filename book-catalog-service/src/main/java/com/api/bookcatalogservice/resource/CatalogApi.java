package com.api.bookcatalogservice.resource;

import com.api.bookcatalogservice.models.Catalog;
import com.api.bookcatalogservice.models.UserRating;
import com.api.bookcatalogservice.service.BookInfo;
import com.api.bookcatalogservice.service.UserRatingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class CatalogApi {

    @Autowired
    private BookInfo bookInfo;

    @Autowired
    private UserRatingInfo userRatingInfo;

    @RequestMapping("/{userId}")
    public List<Catalog> getCatalog(@PathVariable("userId") String userId) {

        UserRating userRating = userRatingInfo.getUserRating(userId);
        return userRating.getRatings().stream()
                .map(rating ->  bookInfo.getCatalogItem(rating))
                .collect(Collectors.toList());
    }

}
