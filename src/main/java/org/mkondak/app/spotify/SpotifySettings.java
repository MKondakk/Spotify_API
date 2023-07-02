package org.mkondak.app.spotify;

import java.time.LocalDateTime;

public class SpotifySettings {

    private static SpotifySettings instance;

    private SpotifySettings() {
    }

    public static SpotifySettings getInstance() {
        if (instance == null) {
            instance = new SpotifySettings();
        }
        return instance;
    }

    private String accessKey;

    private String secretKey;

    private String accessToken;

    private LocalDateTime expireDate;

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
    }
}
