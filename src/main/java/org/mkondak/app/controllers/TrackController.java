package org.mkondak.app.controllers;

import org.mkondak.app.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tracks")
public class TrackController {
    @Autowired
    private TrackRepository trackRepository;

    @DeleteMapping("/{id}")
    public void deleteBySpotifyId(@PathVariable String id) {
        trackRepository.deleteBySpotifyId(id);
    }
}
