package org.example.practica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan
@EnableJpaRepositories
@SpringBootApplication
public class PracticaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticaApplication.class, args);
    }

}
