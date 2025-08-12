package com.luna.fitness_app.model

import jakarta.persistence.*

@Entity
data class Playlist (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(nullable = false)
    var name: String,

    @ElementCollection
    var exerciseIds: List<Int> = emptyList()
)