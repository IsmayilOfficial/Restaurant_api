package com.business.restaurant_api.data

import java.util.*
import javax.persistence.*


@Entity
class Meal(
    var name: String,
    @ManyToOne var cafe: Restaurants ,
    @Id @GeneratedValue var id: Long? = null)

@Entity
class Restaurants(
    var cafeName: String,

    @Id @GeneratedValue var id: Long? = null)



//@Entity
//internal class Meal {
//    @Id
//    var id: String? = null
//    var name: String? = null
//
//
//    constructor(id: String?, name: String?) {
//        this.id = id
//        this.name = name
//    }

//    constructor(name: String?) : this(UUID.randomUUID().toString(), name) {}
//
//    @ManyToOne
//    var cafe: Restaurants,
//}
//
//    @Entity
//    class Restaurants(
//        var cafeName: String,
//        @Id @GeneratedValue var id: Long? = null)
//
//
//}