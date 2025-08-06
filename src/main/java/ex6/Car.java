package ex6;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Car {

    public Car() {
        System.out.println("Car constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("Car Registration");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Claim insurance");
    }
}
