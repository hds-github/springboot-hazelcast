package com.javatech.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "games")
public class GameService {

    private static Logger log = LoggerFactory.getLogger(GameService.class);

    @CacheEvict(allEntries = true)
    public void clearCache() {
    }

    @Cacheable(condition = "#game.equals('cricket')")
    public String play(String game) {
        log.info("Executing: " + this.getClass().getSimpleName() + ".play(\"" + game + "\");");
        return "paying " + game + "!";
    }

}
