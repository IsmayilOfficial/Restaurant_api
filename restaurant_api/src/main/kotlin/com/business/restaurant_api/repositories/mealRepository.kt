package com.business.restaurant_api.repositories


import com.business.restaurant_api.data.Meal

import org.springframework.data.repository.CrudRepository



internal interface mealRepository : CrudRepository<Meal?, String?>