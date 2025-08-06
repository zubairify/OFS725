package ex7;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestConfig {

	@Test
	public void testExchange() {
		ApplicationContext ctx =
				new AnnotationConfigApplicationContext(ExchangeConfig.class);
		
		ExchangeService es = (ExchangeService) ctx.getBean("xe");
		
		es.convert();
		
	}
}
