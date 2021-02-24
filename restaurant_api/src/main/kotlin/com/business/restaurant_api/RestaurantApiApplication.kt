package com.business.restaurant_api

import com.business.restaurant_api.repositories.mealRepository
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





