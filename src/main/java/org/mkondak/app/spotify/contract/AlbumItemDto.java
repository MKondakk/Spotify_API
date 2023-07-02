package org.mkondak.app.spotify.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.mkondak.app.domains.Album;

import java.util.List;
import java.util.stream.Collectors;

public class AlbumItemDto {
    @JsonProperty("album_group")
    private String albumGroup;
    @JsonProperty("album_type")
    private String albumType;
    private List<ArtistItemDto> artists = null;
    @JsonProperty("available_markets")
    private List<String> availableMarkets = null;
    @JsonProperty("external_urls")
    private ExternalUrlsDto externalUrls;
    private String href;
    private String id;
    private List<ImageDto> images = null;
    private String name;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("release_date_precision")
    private String releaseDatePrecision;
    @JsonProperty("total_tracks")
    private Integer totalTracks;
    private String type;
    private String uri;

    public String getAlbumGroup() {
        return albumGroup;
    }

    public void setAlbumGroup(String albumGroup) {
        this.albumGroup = albumGroup;
    }

    public String getAlbumType() {
        return albumType;
    }

    public void setAlbumType(String albumType) {
        this.albumType = albumType;
    }

    public List<ArtistItemDto> getArtists() {
        return artists;
    }

    public void setArtists(List<ArtistItemDto> artists) {
        this.artists = artists;
    }

    public List<String> getAvailableMarkets() {
        return availableMarkets;
    }

    public void setAvailableMarkets(List<String> availableMarkets) {
        this.availableMarkets = availableMarkets;
    }

    public ExternalUrlsDto getExternalUrls() {
        return externalUrls;
    }

    public void setExternalUrls(ExternalUrlsDto externalUrls) {
        this.externalUrls = externalUrls;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ImageDto> getImages() {
        return images;
    }

    public void setImages(List<ImageDto> images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseDatePrecision() {
        return releaseDatePrecision;
    }

    public void setReleaseDatePrecision(String releaseDatePrecision) {
        this.releaseDatePrecision = releaseDatePrecision;
    }

    public Integer getTotalTracks() {
        return totalTracks;
    }

    public void setTotalTracks(Integer totalTracks) {
        this.totalTracks = totalTracks;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
    public Album of() {
        return new Album(getId(), getExternalUrls().getSpotify(), getName(), getArtists().stream().map(ArtistItemDto::getName).collect(Collectors.joining(",")), getReleaseDate(), getTotalTracks());
    }
}