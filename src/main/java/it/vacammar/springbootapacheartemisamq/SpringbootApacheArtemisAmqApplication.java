package it.vacammar.springbootapacheartemisamq;

import it.vacammar.springbootapacheartemisamq.model.MessageDTO;
import it.vacammar.springbootapacheartemisamq.sender.MessageSenderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

import java.util.List;

@EnableJms
@SpringBootApplication
public class SpringbootApacheArtemisAmqApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(SpringbootApacheArtemisAmqApplication.class, args);
        var messageSenderService = context.getBean(MessageSenderService.class);
        List.of(new MessageDTO("Hello World 1"), new MessageDTO("Hello World 2"), new MessageDTO("Hello World 3"))
                .forEach(messageSenderService::send);
    }

}
