package com.restaurant.listing.restaurantlisting.mapper;

import com.restaurant.listing.restaurantlisting.dto.RestaurantDto;
import com.restaurant.listing.restaurantlisting.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    Restaurant mapRestaurantDTOTORestaurant(RestaurantDto restaurantDto);

    RestaurantDto mapRestaurantToRestaurantDTO(Restaurant restaurant);

}
