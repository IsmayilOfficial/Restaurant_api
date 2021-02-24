package com.business.restaurant_api.database_structure

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id


@Entity
  class Meals {
    @Id
    var id: String? = null
    var name: String? = null


    constructor(id: String?, name: String?) {
        this.id = id
        this.name = name
    }

    constructor(name: String?) : this(UUID.randomUUID().toString(), name) {}
}
