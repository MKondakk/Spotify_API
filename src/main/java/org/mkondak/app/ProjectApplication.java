package org.mkondak.app;

import org.mkondak.app.spotify.SpotifySettings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);

		SpotifySettings settings = SpotifySettings.getInstance();
		settings.setAccessKey("");
		settings.setSecretKey("");
	}

}
