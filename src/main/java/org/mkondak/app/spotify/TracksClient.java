package org.mkondak.app.spotify;

import org.mkondak.app.domains.Album;
import org.mkondak.app.domains.Track;
import org.mkondak.app.spotify.contract.AlbumItemDto;
import org.mkondak.app.spotify.contract.ResponseDto;
import org.mkondak.app.spotify.contract.TrackItemDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

public class TracksClient {
    private RestTemplate restClient = new RestTemplate();

    public List<Track> getTracksByAlbumId(String id, String albumName) {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.spotify.com")
                .pathSegment("v1", "albums", id, "tracks")
                .queryParam("market", "PL")
                .build();

        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", String.format("Bearer %s", SpotifySettings.getInstance().getAccessToken()));
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

        HttpEntity<MultiValueMap<String, String>> requestEntity =
                new HttpEntity<>(map, headers);

        var response = restClient
                .exchange(
                        uriComponents.toUriString(),
                        HttpMethod.GET,
                        requestEntity,
                        new ParameterizedTypeReference<ResponseDto<TrackItemDto>>() {
                        })
                .getBody();


        return response.getItems().stream().map(trackDto -> {
            Track track = trackDto.of();
            track.setAlbumName(albumName);
            return track;
        }).collect(Collectors.toList());
    }
}
