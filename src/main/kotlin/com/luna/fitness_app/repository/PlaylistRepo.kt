package com.luna.fitness_app.repository

import com.luna.fitness_app.model.Playlist
import com.luna.fitness_app.service.PlaylistService
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface PlaylistRepo : JpaRepository<Playlist, Int> {
    @Query(value="SELECT * FROM playlist WHERE name=:name", nativeQuery=true)
    fun findByName(name: String): Playlist?
}