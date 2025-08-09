package com.restaurant.listing.restaurantlisting.mapper;

import com.restaurant.listing.restaurantlisting.dto.RestaurantDto;
import com.restaurant.listing.restaurantlisting.entity.Restaurant;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-24T14:48:13+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class RestaurantMapperImpl implements RestaurantMapper {

    @Override
    public Restaurant mapRestaurantDTOTORestaurant(RestaurantDto restaurantDto) {
        if ( restaurantDto == null ) {
            return null;
        }

        Restaurant restaurant = new Restaurant();

        restaurant.setId( restaurantDto.getId() );
        restaurant.setName( restaurantDto.getName() );
        restaurant.setAddress( restaurantDto.getAddress() );
        restaurant.setCity( restaurantDto.getCity() );
        restaurant.setRestaurantDescription( restaurantDto.getRestaurantDescription() );

        return restaurant;
    }

    @Override
    public RestaurantDto mapRestaurantToRestaurantDTO(Restaurant restaurant) {
        if ( restaurant == null ) {
            return null;
        }

        RestaurantDto restaurantDto = new RestaurantDto();

        restaurantDto.setId( restaurant.getId() );
        restaurantDto.setName( restaurant.getName() );
        restaurantDto.setAddress( restaurant.getAddress() );
        restaurantDto.setCity( restaurant.getCity() );
        restaurantDto.setRestaurantDescription( restaurant.getRestaurantDescription() );

        return restaurantDto;
    }
}
