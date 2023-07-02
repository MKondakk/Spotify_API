package org.mkondak.app.controllers;

import org.mkondak.app.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    @Autowired
    private AlbumRepository albumRepository;

    @DeleteMapping("/{id}")
    public void deleteBySpotifyId(@PathVariable String id) {
        albumRepository.deleteBySpotifyId(id);
    }
}
