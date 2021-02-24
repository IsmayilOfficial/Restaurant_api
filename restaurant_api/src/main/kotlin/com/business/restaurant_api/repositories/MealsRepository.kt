package com.business.restaurant_api.repositories

import com.business.restaurant_api.database_structure.Meals
import org.springframework.data.repository.CrudRepository

internal interface MealsRepository : CrudRepository<Meals?, String?>