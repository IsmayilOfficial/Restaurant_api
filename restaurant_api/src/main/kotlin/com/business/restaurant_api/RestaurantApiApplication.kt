package com.business.restaurant_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

import org.springframework.data.repository.CrudRepository

import org.springframework.http.HttpStatus

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

import org.springframework.web.bind.annotation.RequestBody

import org.springframework.web.bind.annotation.PathVariable

import org.springframework.web.bind.annotation.PatchMapping

import org.springframework.web.bind.annotation.DeleteMapping

import org.springframework.web.bind.annotation.PutMapping

import org.springframework.web.bind.annotation.PostMapping

import org.springframework.web.bind.annotation.GetMapping

import org.springframework.web.bind.annotation.RequestMapping

import org.springframework.web.bind.annotation.RestController
import java.util.*

import javax.annotation.PostConstruct
import javax.persistence.Entity
import javax.persistence.Id


@SpringBootApplication
class RestaurantApiApplication

fun main(args: Array<String>) {
	runApplication<RestaurantApiApplication>(*args)
}

@Component
internal class DataLoader(private val mealRepository: MealRepository) {
	@PostConstruct
	private fun loadData() {
		val namesList: List<Meal> = Arrays.asList(
			Meal("Balıq"),
			Meal("Dolma"),
			Meal("basdirma"),
			Meal("kabab")
		)
		mealRepository.saveAll(namesList)
	}
}

@RestController
@RequestMapping("/meals")
internal class RestApiDemoController(private val mealRepository: MealRepository) {
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

internal interface MealRepository : CrudRepository<Meal?, String?>

@Entity
internal class Meal {
	@Id
	var id: String? = null
	var name: String? = null


	constructor(id: String?, name: String?) {
		this.id = id
		this.name = name
	}

	constructor(name: String?) : this(UUID.randomUUID().toString(), name) {}
}
