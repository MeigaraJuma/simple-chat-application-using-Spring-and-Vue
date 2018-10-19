package main.java.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

import main.java.app.models.Message;;


@Component
public class SubscriberListener implements ApplicationListener<SessionSubscribeEvent> {
	
	
	@Autowired
    private SimpMessagingTemplate messagingTemplate;

	@Override
	public void onApplicationEvent(SessionSubscribeEvent event) {
		// TODO Auto-generated method stub
	
		StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
		System.out.println(sha.getDestination());
		System.out.println(sha.getUser());
	
		messagingTemplate.convertAndSend("/chat/user/1", new Message("2","1","Halo"));    
	}


	
	
	
	
	
	
	
	
	
	
}