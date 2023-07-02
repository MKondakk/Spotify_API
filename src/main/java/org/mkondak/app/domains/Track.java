package org.mkondak.app.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Track {
    protected Track() {
    }

    public Track(String spotifyId, String externalUrl, String name, String artistNames, String previewUrl) {
        this.spotifyId = spotifyId;
        this.externalUrl = externalUrl;
        this.name = name;
        this.artistNames = artistNames;
        this.previewUrl = previewUrl;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String spotifyId;
    private String externalUrl;
    private String name;
    private String albumName;
    private String artistNames;

    private String previewUrl;

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtistNames() {
        return artistNames;
    }

    public void setArtistNames(String artistNames) {
        this.artistNames = artistNames;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpotifyId() {
        return spotifyId;
    }

    public void setSpotifyId(String spotifyId) {
        this.spotifyId = spotifyId;
    }

    @Override
    public String toString() {
        return getName();
    }
}
