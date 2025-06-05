package com.luna.fitness_app.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Exercise(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var primaryMuscle: String,

    @Column(nullable = true)
    var secondaryMuscle: String? = null,

    @Column(nullable = true)
    var equipment: String? = null,

    @Column(nullable = true)
    var description: String? = null
)