package com.zs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KafkaProducerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerServiceApplication.class, args);
    }

}
