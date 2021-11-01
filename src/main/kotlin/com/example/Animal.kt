package com.example

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


@Entity
data class Animal(
    @Id
    @GeneratedValue
    var id: UUID?,
)