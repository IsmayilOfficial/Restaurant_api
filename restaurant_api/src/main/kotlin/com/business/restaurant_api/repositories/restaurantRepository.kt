package com.business.restaurant_api.repositories

import com.business.restaurant_api.data.Restaurants
import org.springframework.data.repository.CrudRepository

interface RestaurantRepository : CrudRepository<Restaurants?, String?>