package ex8;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("wap")
@Lazy
public class WhatsappMessage implements Message {

	public WhatsappMessage() {
		System.out.println("Whatsapp constructor");
	}
	
	@Override
	public void send(String to, String msg) {
		System.out.println("Whatsapp sent to " + to + " as " + msg);
	}
}
