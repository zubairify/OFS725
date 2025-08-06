package ex5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("stk")
@Scope("singleton")
public class Stock {
    public Stock() {
        System.out.println("Stock constructor");
    }

    @Bean
    public static Stock getStock() {
        System.out.println("Stock factory method");
        return new Stock();
    }
}
