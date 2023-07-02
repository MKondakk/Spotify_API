package org.mkondak.app.spotify.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.mkondak.app.domains.Track;

import java.util.List;
import java.util.stream.Collectors;

public class TrackItemDto {
    private List<ArtistItemDto> artists = null;
    @JsonProperty("disc_number")
    private Integer discNumber;
    @JsonProperty("duration_ms")
    private Integer durationMs;
    private Boolean explicit;
    @JsonProperty("external_urls")
    private ExternalUrlsDto externalUrls;
    private String href;
    private String id;
    @JsonProperty("is_local")
    private Boolean isLocal;
    @JsonProperty("is_playable")
    private Boolean isPlayable;
    private String name;
    @JsonProperty("preview_url")
    private String previewUrl;
    @JsonProperty("track_number")
    private Integer trackNumber;
    private String type;
    private String uri;

    public List<ArtistItemDto> getArtists() {
        return artists;
    }

    public void setArtists(List<ArtistItemDto> artists) {
        this.artists = artists;
    }

    public Integer getDiscNumber() {
        return discNumber;
    }

    public void setDiscNumber(Integer discNumber) {
        this.discNumber = discNumber;
    }

    public Integer getDurationMs() {
        return durationMs;
    }

    public void setDurationMs(Integer durationMs) {
        this.durationMs = durationMs;
    }

    public Boolean getExplicit() {
        return explicit;
    }

    public void setExplicit(Boolean explicit) {
        this.explicit = explicit;
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

    public Boolean getIsLocal() {
        return isLocal;
    }

    public void setIsLocal(Boolean isLocal) {
        this.isLocal = isLocal;
    }

    public Boolean getIsPlayable() {
        return isPlayable;
    }

    public void setIsPlayable(Boolean isPlayable) {
        this.isPlayable = isPlayable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public Integer getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
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
    public Track of() {
        return new Track(getId(), getExternalUrls().getSpotify(), getName(), getArtists().stream().map(ArtistItemDto::getName).collect(Collectors.joining(",")), getPreviewUrl());
    }
}
