package com.play;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class of application.
 */
@SpringBootApplication
public class PlaygroundApplication {
    /**
     * Method for run application.
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(PlaygroundApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
