
package org.mkondak.app.spotify.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.mkondak.app.domains.Artist;

import java.util.Arrays;
import java.util.List;

public class ArtistItemDto {

    @JsonProperty("external_urls")
    private ExternalUrlsDto externalUrls;
    private FollowersDto followers;
    private List<String> genres = null;
    private String href;
    private String id;
    private List<ImageDto> images = null;
    private String name;
    private Long popularity;
    private String type;
    private String uri;

    public ExternalUrlsDto getExternalUrls() {
        return externalUrls;
    }

    public void setExternalUrls(ExternalUrlsDto externalUrls) {
        this.externalUrls = externalUrls;
    }

    public FollowersDto getFollowers() {
        return followers;
    }

    public void setFollowers(FollowersDto followers) {
        this.followers = followers;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
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

    public Long getPopularity() {
        return popularity;
    }

    public void setPopularity(Long popularity) {
        this.popularity = popularity;
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

    @Override
    public String toString() {
        return getName();
    }

    public Artist of() {
        return new Artist(getId(), getExternalUrls().getSpotify(), getFollowers().getTotal(), getGenres().toArray(new String[0]), getName());
    }
}
