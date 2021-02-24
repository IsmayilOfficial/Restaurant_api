package com.business.restaurant_api.data

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id



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
