package ex4;

import ex8.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("hi")
public class Hello {
    private String greeting;

    public Hello() {
        System.out.println("Default constructor");
    }

    public Hello(String greeting) {
        this.greeting = greeting;
        System.out.println("Parameterised constructor");
    }

    public String getGreeting() {
        return greeting;
    }

    @Value("Hello Spring")
    public void setGreeting(String greeting) {
        this.greeting = greeting;
        System.out.println("Setting Greeting");
    }
}
