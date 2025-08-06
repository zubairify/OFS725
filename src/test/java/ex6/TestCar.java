package ex6;

import ex6.Car;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCar {

    @Test
    public void testCar() {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("ex3ctx.xml");
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("appctx.xml");
        Car car = ctx.getBean(Car.class);

        ctx.close();
    }
}
