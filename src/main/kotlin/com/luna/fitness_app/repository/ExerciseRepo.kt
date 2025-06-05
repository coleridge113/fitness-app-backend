package com.luna.fitness_app.repository

import com.luna.fitness_app.model.Exercise
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ExerciseRepo : JpaRepository<Exercise, Int> {
     @Query(value="SELECT * FROM exercise WHERE name=:name", nativeQuery=true)
    fun findByName(name: String): Exercise?

     @Query(value="SELECT * FROM exercise WHERE primary_muscle=:primaryMuscle", nativeQuery=true)
    fun findByPrimaryMuscle(primaryMuscle: String): List<Exercise>
}