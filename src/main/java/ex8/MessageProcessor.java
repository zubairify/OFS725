package ex8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

@Repository("process")
public class MessageProcessor {

	@Autowired
	private ApplicationContext appCtx;
	
	public MessageProcessor() {
		System.out.println("Processor constructor");
	}
	
	public void process(String type, String to, String msg) {
		Message m = (Message) appCtx.getBean(type);
		m.send(to, msg);
	}
}
