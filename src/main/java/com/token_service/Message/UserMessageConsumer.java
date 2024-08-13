package com.token_service.Message;

import com.token_service.Entities.Token;
import com.token_service.Entities.UserMessage;
import com.token_service.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMessageConsumer {

    @Autowired
    private TokenService tokenService;

    public void consumeMessage(UserMessage userMessage) {
        Token newtoken = tokenService.createToken(userMessage.getId());
        System.out.println("Token created: " + newtoken.getToken());
    }
}
