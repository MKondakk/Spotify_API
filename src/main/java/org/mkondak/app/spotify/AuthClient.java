package org.mkondak.app.spotify;

import org.mkondak.app.spotify.contract.AuthDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.Objects;

public class AuthClient {
    private RestTemplate restClient = new RestTemplate();

    /*
    Implement Client Credentials OAuth2 flow to get Spotify access key
    https://developer.spotify.com/documentation/general/guides/authorization/client-credentials/
     */
    public boolean authorise() {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("accounts.spotify.com")
                .pathSegment("api", "token")
                .build()
                .encode();

        HttpHeaders headers = new HttpHeaders();
        String clientId = SpotifySettings.getInstance().getAccessKey();
        String clientSecret = SpotifySettings.getInstance().getSecretKey();
        String authHeader = Base64Utils.encodeToString(String.format("%s:%s", clientId, clientSecret).getBytes());

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", String.format("Basic %s", authHeader));
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

        map.add("grant_type", "client_credentials");

        HttpEntity<MultiValueMap<String, String>> requestEntity =
                new HttpEntity<>(map, headers);

        try {
            var response = restClient.postForEntity(uriComponents.toUriString(), requestEntity, AuthDto.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                SpotifySettings settings = SpotifySettings.getInstance();
                AuthDto authData = Objects.requireNonNull(response.getBody());

                settings.setAccessToken(authData.getAccessToken());
                settings.setExpireDate(LocalDateTime.now().plusSeconds(authData.getExpiresIn()));
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isExpired() {
        LocalDateTime expireDate = SpotifySettings.getInstance().getExpireDate();
        return Objects.isNull(expireDate) || LocalDateTime.now().isAfter(expireDate);
    }
}
