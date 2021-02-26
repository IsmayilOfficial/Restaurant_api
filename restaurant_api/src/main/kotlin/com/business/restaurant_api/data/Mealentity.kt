package com.business.restaurant_api.data

import java.util.*
import javax.persistence.*


@Entity
class Meal(
    var name: String,
    var price :Double,
    var orderTime:String,
    @ManyToOne var cafe: Restaurants ,
    @Id @GeneratedValue var id: Long? = null)

@Entity
class Restaurants(
    var cafeName: String,
    var location: String?,
    var instock: Boolean,
    var delivery: Boolean,

    @Id @GeneratedValue var id: Long? = null)


