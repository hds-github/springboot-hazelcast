package com.javatech.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Application implements CommandLineRunner {

    private static Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private GameService gameService;

    @Autowired
    private CacheManager cacheManager;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("Spring Boot Hazelcast Caching Example Configuration");
        log.info("Using cache manager: " + cacheManager.getClass().getName());

        gameService.clearCache();

        play("cricket");
        play("football");
        play("cricket");
        play("tennis");
        play("cricket");
    }

    private void play(String game) {
        log.info("Calling: " + GameService.class.getSimpleName() + ".play(\"" + game + "\");");
        gameService.play(game);
    }
}
