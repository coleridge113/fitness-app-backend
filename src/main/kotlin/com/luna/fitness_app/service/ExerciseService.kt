package com.luna.fitness_app.service

import com.luna.fitness_app.model.Exercise
import com.luna.fitness_app.repository.ExerciseRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ExerciseService(
    @Autowired
    private val exerciseRepo: ExerciseRepo
) {
    fun getAllExercises(): List<Exercise>{
        return exerciseRepo.findAll()
    }

    fun getExerciseById(id: Int): Exercise? {
        return exerciseRepo.findById(id).orElse(null)
    }

    fun createExercise(exercise: Exercise): String {
        return if(exerciseRepo.findByName(exercise.name) != null){
            "Exercise already exists!"
        } else {
            try {
                exerciseRepo.save(exercise)
                "Exercise created successfully!"
            } catch (e: Exception) {
                e.printStackTrace()
                "Failed to create exercise..."
            }
        }
    }

    fun updateExercise(id: Int, exercise: Exercise): String {
        val existingExercise = exerciseRepo.findById(id).orElse(null)
        return if (existingExercise != null) {
            existingExercise.name = exercise.name
            existingExercise.primaryMuscle = exercise.primaryMuscle
            return try {
                exerciseRepo.save(existingExercise)
                "Exercise updated successfully!"
            } catch (e: Exception) {
                e.printStackTrace()
                "Failed to update exercise..."
            }
        } else {
            "Exercise not found."
        }
    }

    fun deleteExerciseById(id: Int): String {
        return try {
            exerciseRepo.deleteById(id)
            "Exercise is successfully deleted"
        } catch (e: Exception) {
            e.printStackTrace()
            "Failed to delete exercise..."
        }
    }

}