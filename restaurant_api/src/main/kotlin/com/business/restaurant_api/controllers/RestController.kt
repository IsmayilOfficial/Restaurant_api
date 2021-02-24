package com.business.restaurant_api.controllers

import com.business.restaurant_api.database_structure.Meals
import com.business.restaurant_api.repositories.MealsRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import java.util.*




@RestController
@RequestMapping("/meals")
internal class RestController(private val mealsRepository: MealsRepository) {
    @get:GetMapping
    val coffees: Iterable<Meals?>
        get() = mealsRepository.findAll()

    @GetMapping("/{id}")
    fun getCoffeeById(@PathVariable id: String): Optional<Meals?> {
        return mealsRepository.findById(id)
    }

    @PostMapping
    fun postCoffee(@RequestBody coffee: Meals): Meals {
        return mealsRepository.save(coffee)
    }

    @PutMapping("/{id}")
    fun putCoffee(
        @PathVariable id: String,
        @RequestBody coffee: Meals
    ): ResponseEntity<Meals> {
        return if (mealsRepository.existsById(id)) ResponseEntity(
            mealsRepository.save(coffee),
            HttpStatus.OK
        ) else ResponseEntity(
            mealsRepository.save(coffee), HttpStatus.CREATED
        )
    }

    @DeleteMapping("/{id}")
    fun deleteCoffee(@PathVariable id: String) {
        mealsRepository.deleteById(id)
    }

    @PatchMapping("/{id}")
    fun patchCofee(
        @PathVariable id: String,
        @RequestBody coffee: Meals
    ): ResponseEntity<Meals> {
        return if (mealsRepository.existsById(id)) ResponseEntity(
            mealsRepository.save(coffee),
            HttpStatus.OK
        ) else ResponseEntity(
            mealsRepository.save(coffee), HttpStatus.CREATED
        )
    }
}