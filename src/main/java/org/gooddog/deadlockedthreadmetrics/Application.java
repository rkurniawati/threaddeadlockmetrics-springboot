package org.gooddog.deadlockedthreadmetrics;

import org.gooddog.deadlockedthreadmetrics.diningphilosophers.PhilosopherWithMonitorLock;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(PhilosopherWithMonitorLock.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> logger.info("*** To exit the application, press Ctrl+C");
    }
}
