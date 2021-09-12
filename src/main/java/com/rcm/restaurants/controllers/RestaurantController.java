package com.rcm.restaurants.controllers;

import com.rcm.restaurants.datamodel.Restaurant;
import com.rcm.restaurants.datamodel.Review;
import com.rcm.restaurants.exceptions.ResourceNotFoundException;
import com.rcm.restaurants.repository.RestaurantRepository;
import com.rcm.restaurants.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant getRestaurant(@PathVariable int id) {
        String test = "";
        Optional<Restaurant> maybeRestaurant = restaurantRepository.findById(id);
        if (maybeRestaurant.isEmpty()) throw new ResourceNotFoundException("Restaurant not found: " + id);
        return maybeRestaurant.get();
    }

    @PostMapping("/restaurants")
    public ResponseEntity<Object> addRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant newRestaurant = restaurantRepository.save(restaurant);
        URI location = getRestaurantLocation(newRestaurant);
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/restaurants/{id}")
    public void updateRestaurant(@RequestBody Restaurant updatedRestaurantData, @PathVariable int id) {
        Optional<Restaurant> maybeRestaurant = restaurantRepository.findById(id);
        if (maybeRestaurant.isEmpty()) throw new ResourceNotFoundException("Restaurant not found: " + id);
        Restaurant updatedRestaurant = maybeRestaurant.map(restaurant -> {
            restaurant.setName(updatedRestaurantData.getName());
            restaurant.setAddress(updatedRestaurantData.getAddress());
            restaurant.setPhone(updatedRestaurantData.getPhone());
            return restaurant;
        }).get();
        restaurantRepository.save(updatedRestaurant);
    }

    @DeleteMapping("/restaurants/{id}")
    public void deleteRestaurant(@PathVariable int id) {
        Optional<Restaurant> maybeRestaurant = restaurantRepository.findById(id);
        if (maybeRestaurant.isEmpty()) throw new ResourceNotFoundException("Restaurant not found: " + id);
        restaurantRepository.delete(maybeRestaurant.get());
    }

    @GetMapping("/restaurants/{id}/reviews")
    public List<Review> getRestaurantReview(@PathVariable int id) {
        Optional<Restaurant> maybeRestaurant = restaurantRepository.findById(id);
        if (maybeRestaurant.isEmpty()) throw new ResourceNotFoundException("Restaurant not found: " + id);
        return maybeRestaurant.get().getReviews();
    }

    @PostMapping("/restaurants/{id}/reviews")
    public ResponseEntity<Object> addReview(@PathVariable int id, @RequestBody Review review) {
        Optional<Restaurant> maybeRestaurant = restaurantRepository.findById(id);
        if (maybeRestaurant.isEmpty()) throw new ResourceNotFoundException("Restaurant not found: " + id);
        Restaurant restaurant = maybeRestaurant.get();
        review.setRestaurant(restaurant);
        reviewRepository.save(review);
        URI location = getRestaurantLocation(restaurant);
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/restaurants/{restaurantId}/reviews/{reviewId}")
    public void updateReview(@RequestBody Review updatedReviewData, @PathVariable int restaurantId, @PathVariable int reviewId) {
        Optional<Restaurant> maybeRestaurant = restaurantRepository.findById(restaurantId);
        if (maybeRestaurant.isEmpty()) throw new ResourceNotFoundException("Restaurant not found: " + restaurantId);
        Restaurant restaurant = maybeRestaurant.get();
        Optional<Review> maybeReview = restaurant.getReviews().stream().filter(review -> review.getId() == reviewId).findFirst();
        if (maybeReview.isEmpty()) throw new ResourceNotFoundException("Review not found: " + reviewId);
        Review updatedReview =
                maybeReview.map(review -> {
            review.setComment(updatedReviewData.getComment());
            review.setReviewerName(updatedReviewData.getReviewerName());
            review.setStars(updatedReviewData.getStars());
            review.setRestaurant(restaurant);
            return review;
        }).get();
        reviewRepository.save(updatedReview);
    }

    @DeleteMapping("/restaurants/{restaurantId}/reviews/{reviewId}")
    public void deleteRestaurant(@PathVariable int restaurantId, @PathVariable int reviewId) {
        Optional<Restaurant> maybeRestaurant = restaurantRepository.findById(restaurantId);
        if (maybeRestaurant.isEmpty()) throw new ResourceNotFoundException("Restaurant not found: " + restaurantId);
        Restaurant restaurant = maybeRestaurant.get();
        Optional<Review> maybeReview = restaurant.getReviews().stream().filter(review -> review.getId() == reviewId).findFirst();
        if (maybeReview.isEmpty()) throw new ResourceNotFoundException("Review not found: " + reviewId);
        reviewRepository.delete(maybeReview.get());
    }

    private URI getRestaurantLocation(Restaurant restaurant) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(restaurant.getId()).toUri();
    }
}
