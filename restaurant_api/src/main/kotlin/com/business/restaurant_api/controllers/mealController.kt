package com.business.restaurant_api.controllers

import com.business.restaurant_api.data.Meal
import com.business.restaurant_api.repositories.MealRepository

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*



@RestController
@RequestMapping("/meals")
internal class mealController(private val mealRepository: MealRepository) {
    @get:GetMapping
    val meals: Iterable<Meal?>
        get() = mealRepository.findAll()

    @GetMapping("/{id}")
    fun getMealById(@PathVariable id: String): Optional<Meal?> {
        return mealRepository.findById(id)
    }

    @PostMapping
    fun postMeal(@RequestBody coffee: Meal): Meal {
        return mealRepository.save(coffee)
    }

    @PutMapping("/{id}")
    fun putMeal(
        @PathVariable id: String,
        @RequestBody coffee: Meal
    ): ResponseEntity<Meal> {
        return if (mealRepository.existsById(id)) ResponseEntity(
            mealRepository.save(coffee),
            HttpStatus.OK
        ) else ResponseEntity(
            mealRepository.save(coffee), HttpStatus.CREATED
        )
    }

    @DeleteMapping("/{id}")
    fun deleteMeal(@PathVariable id: String) {
        mealRepository.deleteById(id)
    }

    @PatchMapping("/{id}")
    fun patchMeal(
        @PathVariable id: String,
        @RequestBody coffee: Meal
    ): ResponseEntity<Meal> {
        return if (mealRepository.existsById(id)) ResponseEntity(
            mealRepository.save(coffee),
            HttpStatus.OK
        ) else ResponseEntity(
            mealRepository.save(coffee), HttpStatus.CREATED
        )
    }
}