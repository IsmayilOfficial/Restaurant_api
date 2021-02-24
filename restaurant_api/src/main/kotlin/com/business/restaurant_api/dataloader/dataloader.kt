package com.business.restaurant_api.dataloader


import com.business.restaurant_api.data.Meal


import com.business.restaurant_api.repositories.mealRepository
import org.springframework.stereotype.Component
import java.util.*
import javax.annotation.PostConstruct
import javax.swing.text.html.parser.Entity


@Component
internal class dataloader(private val mealRepository: mealRepository) {
    @PostConstruct
    private fun loadData() {
        val namesList: MutableList<Meal> = Arrays.asList(
            Meal("Balıq"),
            Meal("Ayran"),
            Meal("Kabab"),
            Meal("Tabaka"),

        )
        mealRepository.saveAll(namesList)
    }
}