package org.example.rbapi;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Date;
import java.util.TimeZone;

//@EnableJpaAuditing
@SpringBootApplication
public class RBapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RBapiApplication.class, args);
    }

}
