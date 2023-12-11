package hcmute.alohcmute.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import hcmute.alohcmute.entities.TinNhan;

@Controller
public class TinNhanController {

	@Autowired
    private SimpMessagingTemplate messagingTemplate;	
	
	@GetMapping("/chat")
	public String chat() {
		return "user/chat/chat";
	}

    @MessageMapping("/chat.sendMessage")
    public void sendMessage(
    		@Payload TinNhan chatMessage,
    		@Header("topic") String topic) {
        messagingTemplate.convertAndSend("/topic/" + topic, chatMessage);
    } 

}
