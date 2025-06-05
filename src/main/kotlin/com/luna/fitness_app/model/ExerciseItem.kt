package com.luna.fitness_app.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Exercise(
    @Column(nullable = false)
    var name: String,
    @Column(nullable = false)
    var primaryMuscle: String,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
)