package org.mkondak.app.spotify;

import org.mkondak.app.domains.Artist;
import org.mkondak.app.spotify.contract.SearchResultDto;
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

public class SearchArtistClient {
    private RestTemplate restClient = new RestTemplate();

    public Artist searchArtist(String name) {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.spotify.com")
                .pathSegment("v1", "search")
                .queryParam("q", name)
                .queryParam("type", "artist")
                .queryParam("limit", "1")
                .build();

        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", String.format("Bearer %s", SpotifySettings.getInstance().getAccessToken()));
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

        HttpEntity<MultiValueMap<String, String>> requestEntity =
                new HttpEntity<>(map, headers);

        var response = restClient.exchange(uriComponents.toUriString(), HttpMethod.GET, requestEntity, SearchResultDto.class).getBody();
        return response.getArtists().getItems().get(0).of();
    }
}
