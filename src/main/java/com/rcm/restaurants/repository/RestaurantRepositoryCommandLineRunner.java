package com.rcm.restaurants.repository;

import com.rcm.restaurants.datamodel.Restaurant;
import com.rcm.restaurants.datamodel.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RestaurantRepositoryCommandLineRunner implements CommandLineRunner {

    private static final Logger log =
            LoggerFactory.getLogger(RestaurantRepositoryCommandLineRunner.class);

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public void run(String... arg0) throws Exception {
/*
        List<Restaurant> restaurants = new ArrayList<Restaurant>();
        restaurants.add(new Restaurant("Bistro", "Gran vía 1, Madrid, Spain", "+34265897236"));
        restaurants.add(new Restaurant("Cielo", "Castellana 22, Madrid, Spain", "+342552376990"));
        restaurants.add(new Restaurant("Pizza Pisa", "Calle Alcalá 33, Madrid, Spain", "+34211910086"));
        for(Restaurant restaurant: restaurants) {
            restaurantRepository.save(restaurant);
        }

 */
    }
}
