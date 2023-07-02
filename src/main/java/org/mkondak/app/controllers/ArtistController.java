package org.mkondak.app.controllers;

import org.mkondak.app.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artists")
public class ArtistController {
    @Autowired
    private ArtistRepository artistRepository;

    @DeleteMapping("/{id}")
    public void deleteBySpotifyId(@PathVariable String id) {
        artistRepository.deleteBySpotifyId(id);
    }
}
