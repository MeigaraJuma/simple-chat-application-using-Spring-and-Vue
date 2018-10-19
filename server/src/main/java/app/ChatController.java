package main.java.app;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import main.java.app.models.Chat;
import main.java.app.models.Message;

@Controller
public class ChatController {


    @MessageMapping("/user/{id}")
    //@SendTo("/chat/user/{id}")
    public void message(Message message) throws Exception {
    	System.out.println("sender :"+message.getSender());
    	System.out.println("receiver :"+message.getReceiver());
    }

}