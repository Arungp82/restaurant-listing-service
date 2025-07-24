package com.restaurant.listing.restaurantlisting.service;

import com.restaurant.listing.restaurantlisting.dto.RestaurantDto;
import com.restaurant.listing.restaurantlisting.entity.Restaurant;
import com.restaurant.listing.restaurantlisting.mapper.RestaurantMapper;
import com.restaurant.listing.restaurantlisting.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<RestaurantDto> findAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        //map it to list of DTOs
        List<RestaurantDto> restaurantDtoList = restaurants.stream().map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant)).toList();
        return restaurantDtoList;
    }

    public RestaurantDto addRestaurantInDB(RestaurantDto restaurantDto) {
        Restaurant savedRestaurant = restaurantRepository.save(RestaurantMapper.INSTANCE.mapRestaurantDTOTORestaurant(restaurantDto));
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(savedRestaurant);
    }

    public ResponseEntity<RestaurantDto> fetchRestaurantById(Integer id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if (restaurant.isPresent()) {
            return new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant.get()),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
