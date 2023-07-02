package org.mkondak.app.domains;

import jakarta.persistence.*;

@Entity
public class Artist {

    protected Artist() {
    }

    public Artist(String spotifyId, String externalUrl, long followers, String[] genres, String name) {
        this.spotifyId = spotifyId;
        this.externalUrl = externalUrl;
        this.followers = followers;
        this.genres = genres;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public String getSpotifyId() {
        return spotifyId;
    }

    public void setSpotifyId(String spotifyId) {
        this.spotifyId = spotifyId;
    }

    @Column(unique=true)
    private String spotifyId;

    public String getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    public long getFollowers() {
        return followers;
    }

    public void setFollowers(long followers) {
        this.followers = followers;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String externalUrl;

    private long followers;

    private String[] genres;

    private String name;
}
