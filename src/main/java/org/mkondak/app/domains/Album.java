package org.mkondak.app.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Album {
    protected Album() {
    }

    public Album(String spotifyId, String externalUrl, String name, String artistNames, String releaseDate, int totalTracks) {
        this.spotifyId = spotifyId;
        this.externalUrl = externalUrl;
        this.name = name;
        this.artistNames = artistNames;
        this.releaseDate = releaseDate;
        this.totalTracks = totalTracks;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String spotifyId;
    private String externalUrl;
    private String name;

    private String artistNames;

    public String getArtistNames() {
        return artistNames;
    }

    public void setArtistNames(String artistNames) {
        this.artistNames = artistNames;
    }

    private String releaseDate;

    private int totalTracks;

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getTotalTracks() {
        return totalTracks;
    }

    public void setTotalTracks(int totalTracks) {
        this.totalTracks = totalTracks;
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
