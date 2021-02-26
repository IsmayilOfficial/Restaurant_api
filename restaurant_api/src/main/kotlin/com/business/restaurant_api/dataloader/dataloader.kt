package com.business.restaurant_api.dataloader


import com.business.restaurant_api.data.Meal
import com.business.restaurant_api.data.Restaurants
import com.business.restaurant_api.repositories.MealRepository
import com.business.restaurant_api.repositories.RestaurantRepository


import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.annotation.PostConstruct
import javax.swing.text.html.parser.Entity


//@Component
//internal class dataloader(private val mealRepository: mealRepository) {
//    @PostConstruct
//    private fun loadData() {
//        val namesList: MutableList<Meal> = Arrays.asList(
//            Meal("Balıq",),
//            Meal("Ayran"),
//            Meal("Kabab"),
//            Meal("Tabaka"),
//
//        )
//        mealRepository.saveAll(namesList)
//
//
//
//    }
//}

@Configuration
class BlogConfiguration {
    var currentDateTime= LocalDateTime.now()
    var datePatterned  = currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))

    @Bean
    fun databaseInitializer(restaurantRepository: RestaurantRepository,
                            mealRepository: MealRepository
    ) = ApplicationRunner {


        val rest1 = restaurantRepository.save(Restaurants("kabab Stop ","Tartu",true,true))
        val rest2 = restaurantRepository.save(Restaurants("armudu","Tartu",true,true))
        val rest3 = restaurantRepository.save(Restaurants("furkan kebab","Tartu",true,true))
        mealRepository.save(Meal(
            "lule",

12.3,
            datePatterned,
            rest1
        ))
        mealRepository.save(Meal(
          "bozartma",
            23.0,
            datePatterned,


            rest3
        ))

        mealRepository.save(Meal(
            name = "pomidor yumurta",

34.9,
            datePatterned,
            cafe = rest2
        ))
    }
}