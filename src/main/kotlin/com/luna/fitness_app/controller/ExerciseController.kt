package com.luna.fitness_app.controller

import com.luna.fitness_app.model.Exercise
import com.luna.fitness_app.service.ExerciseService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestParam

@CrossOrigin(origins = ["*"])
@RestController
@RequestMapping("/exercise")
class ExerciseController(
    private val exerciseService: ExerciseService
) {

    @GetMapping("index")
    fun index(): String {
        return "Hello world!"
    }

    @GetMapping("all")
    fun getAllExercises(): ResponseEntity<List<Exercise>>{
        return ResponseEntity(exerciseService.getAllExercises(), HttpStatus.OK)
    }

    @GetMapping("")
    fun getExerciseById(@RequestParam("id") id: Int): ResponseEntity<Exercise?> {
        return ResponseEntity(exerciseService.getExerciseById(id), HttpStatus.OK)
    }

    @GetMapping("muscle/{primaryMuscle}")
    fun getExerciseByPrimaryMuscle(@PathVariable primaryMuscle: String): ResponseEntity<List<Exercise>>{
        return ResponseEntity(exerciseService.getExerciseByPrimaryMuscle(primaryMuscle), HttpStatus.OK)
    }

    @PostMapping("create")
    fun createExercise(@RequestBody exercise: Exercise): ResponseEntity<String> {
        val result = exerciseService.createExercise(exercise)
        return when (result) {
            "Exercise already exists!" -> ResponseEntity(result, HttpStatus.CONFLICT)
            "Exercise created successfully!" -> ResponseEntity(result, HttpStatus.CREATED)
            else -> ResponseEntity(result, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("update/{id}")
    fun updateExercise(@PathVariable id: Int, @RequestBody exercise: Exercise): ResponseEntity<String>{
        val result = exerciseService.updateExercise(id, exercise)
        return when (result) {
            "Exercise updated successfully!" -> ResponseEntity(result, HttpStatus.OK)
            "Exercise not found." -> ResponseEntity(result, HttpStatus.NOT_FOUND)
            else -> ResponseEntity(result, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("delete/{id}")
    fun deleteExerciseById(@PathVariable id: Int): ResponseEntity<String>{
        return ResponseEntity(exerciseService.deleteExerciseById(id), HttpStatus.OK)
    }
}