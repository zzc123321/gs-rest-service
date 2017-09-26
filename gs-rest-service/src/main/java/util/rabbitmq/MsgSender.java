package util.rabbitmq;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class MsgSender {
	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(String keyWord) {
		String context = keyWord ;
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("worker", context);
	}
}
