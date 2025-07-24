package com.restaurant.listing.restaurantlisting.controller;

import com.restaurant.listing.restaurantlisting.dto.RestaurantDto;
import com.restaurant.listing.restaurantlisting.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestaurantDto>> fetchAllRestaurants(){
        List<RestaurantDto> allRestaurants = restaurantService.findAllRestaurants();
        return new ResponseEntity<>(allRestaurants, HttpStatus.OK);
    }

    public ResponseEntity<RestaurantDto> saveRestaurant(@RequestBody RestaurantDto restaurantDto){
        RestaurantDto restaurantAdded = restaurantService.addRestaurantInDB(restaurantDto);
        return new ResponseEntity<>(restaurantAdded,HttpStatus.CREATED);
    }
}
