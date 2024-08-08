package it.vacammar.springbootapacheartemisamq.receiver;

import it.vacammar.springbootapacheartemisamq.common.IReceiver;
import it.vacammar.springbootapacheartemisamq.model.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Qualifier("messageQueueReceiver")
public class MessageReceiverService implements IReceiver<MessageDTO> {

    @JmsListener(destination = "message-queue", containerFactory = "myFactory")
    @Override
    public void receive(MessageDTO message) {
        log.info("Received message: {}", message.getMessage());
    }
}
