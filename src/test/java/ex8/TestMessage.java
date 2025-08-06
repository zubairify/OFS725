package ex8;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMessage {

	@Test
	public void testProcess() {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("appctx.xml");
		
		MessageProcessor mp = (MessageProcessor) appCtx.getBean("process");
		
		mp.process("sms", "9876543210", "Hello SMS");
		mp.process("email", "zubair@mail", "Hello Email");
//		mp.process("wap", "@zubair", "Hello Whatsapp");
	}
}
