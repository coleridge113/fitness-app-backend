package com.luna.fitness_app.controller

import com.luna.fitness_app.model.Playlist
import com.luna.fitness_app.service.PlaylistService
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Http
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins=["*"])
@RestController
@RequestMapping("/playlist")
class PlaylistController(
    private val playlistService: PlaylistService
) {

    @GetMapping("/")
    fun getAllPlaylists(): ResponseEntity<List<Playlist>>{
        return ResponseEntity(playlistService.getAllPlaylists(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getPlaylistById(@PathVariable id: Int): ResponseEntity<Playlist> {
        val result = playlistService.getPlaylistById(id)
        return if(result != null) {
            ResponseEntity(result, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("create")
    fun createPlaylist(@RequestBody playlist: Playlist): ResponseEntity<String>{
        val result = playlistService.createPlaylist(playlist)
        return when(result) {
            true -> ResponseEntity("Playlist successfully created!", HttpStatus.CREATED)
            false -> ResponseEntity("Playlist already exists!", HttpStatus.CONFLICT)
            else -> ResponseEntity("There seems to have been an issue...", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")
    fun deletePlaylist(@PathVariable id: Int): ResponseEntity<String> {
        return ResponseEntity(playlistService.deletePlaylist(id), HttpStatus.OK)
    }
}