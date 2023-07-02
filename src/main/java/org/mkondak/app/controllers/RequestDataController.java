package org.mkondak.app.controllers;

import org.mkondak.app.domains.Album;
import org.mkondak.app.domains.Artist;
import org.mkondak.app.domains.Track;
import org.mkondak.app.repositories.AlbumRepository;
import org.mkondak.app.repositories.ArtistRepository;
import org.mkondak.app.repositories.TrackRepository;
import org.mkondak.app.spotify.AlbumsClient;
import org.mkondak.app.spotify.AuthClient;
import org.mkondak.app.spotify.SearchArtistClient;
import org.mkondak.app.spotify.TracksClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class RequestDataController {
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private TrackRepository trackRepository;

    @GetMapping("/{name}")
    public ResponseEntity<?> searchArtist(@PathVariable String name) {
        try {
            AuthClient authClient = new AuthClient();
            if (authClient.isExpired()) {
                authClient.authorise();
            }

            SearchArtistClient searchArtistClient = new SearchArtistClient();
            Artist artist = searchArtistClient.searchArtist(name);
            artistRepository.save(artist);

            AlbumsClient albumsClient = new AlbumsClient();
            List<Album> albums = albumsClient.getAlbumsByArtistId(artist.getSpotifyId());
            albumRepository.saveAll(albums);

            TracksClient tracksClient = new TracksClient();
            for (Album album : albums) {
                List<Track> tracks = tracksClient.getTracksByAlbumId(album.getSpotifyId(), album.getName());
                trackRepository.saveAll(tracks);
            }

            return new ResponseEntity<>(null, HttpStatus.OK);

        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(null, HttpStatus.ALREADY_REPORTED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}