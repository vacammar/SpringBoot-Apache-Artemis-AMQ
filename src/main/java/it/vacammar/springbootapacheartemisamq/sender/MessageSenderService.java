package it.vacammar.springbootapacheartemisamq.sender;

import it.vacammar.springbootapacheartemisamq.common.ISender;
import it.vacammar.springbootapacheartemisamq.model.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Qualifier("messageQueueSender")
public class MessageSenderService implements ISender<MessageDTO> {

    @Value("${jms.queues.message.name}")
    private String queueName;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void send(MessageDTO message) {
        log.info("Sending message: {}", message);
        this.jmsTemplate.convertAndSend(this.queueName, message);
    }
}
