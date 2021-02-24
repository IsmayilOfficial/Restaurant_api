package com.business.restaurant_api.dataloader

import com.business.restaurant_api.database_structure.Meals
import com.business.restaurant_api.repositories.MealsRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct


@Component
internal class DataLoader(private val mealsRepository: MealsRepository) {
    @PostConstruct
    private fun loadData() {
        val mealList: List<Meals> =listOf(
            Meals("kabab"),
            Meals("Cafe Ganador"),
            Meals("Cafe Lareno"),
            Meals("Cafe Tres Pontas")
        )
        mealsRepository.saveAll(mealList)
    }
}


