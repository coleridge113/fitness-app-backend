package com.luna.fitness_app.service

import com.luna.fitness_app.model.Playlist
import com.luna.fitness_app.repository.PlaylistRepo
import org.springframework.stereotype.Service

@Service
class PlaylistService(
    private val playlistRepo: PlaylistRepo
) {

    fun getAllPlaylists(): List<Playlist> {
        return playlistRepo.findAll()
    }

    fun getPlaylistById(id: Int): Playlist? {
        return playlistRepo.findById(id).orElse(null)
    }

    fun createPlaylist(playlist: Playlist): Boolean {
        if (playlistRepo.findByName(playlist.name) != null) {
            return false
        }
        return try {
            playlistRepo.save(playlist)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun deletePlaylist(id: Int): String {
        return try {
            playlistRepo.deleteById(id)
            "Playlist is successfully deleted!"
        } catch (e: Exception) {
            e.printStackTrace()
            "Failed to delete playlist..."
        }
    }
}