package com.token_service.Service;

import com.token_service.Entities.Token;
import com.token_service.Entities.UserMessage;
import com.token_service.Repository.TokenRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Optional;
import java.util.UUID;

@Service
public class TokenService implements ITokenService {

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public Token createToken(Long userId) {
        Token token = new Token();
        token.setUserId(userId);
        token.setToken(UUID.randomUUID().toString());
        token.setExpiryDate(calculateExpiryDate());
        Token savedToken = tokenRepository.save(token);

        UserMessage updatedUserMessage = new UserMessage();
        updatedUserMessage.setId(userId);
        updatedUserMessage.setToken(savedToken.getToken());
        rabbitTemplate.convertAndSend("user.update.queue", updatedUserMessage);

        return savedToken;
    }

    @Override
    public boolean validateToken(String token) {
        Optional<Token> verifyToken = tokenRepository.findByToken(token);
        if (verifyToken.isPresent()) {
            Token theToken = verifyToken.get();
            if (theToken.getExpiryDate() >= System.currentTimeMillis()) {
                // Token is valid
                return true;
            }
        }
        return false;
    }

    public boolean confirmToken(String token) {
        Optional<Token> verifyToken = tokenRepository.findByToken(token);
        if (verifyToken.isPresent()) {
            Token theToken = verifyToken.get();
            if (theToken.getExpiryDate() >= System.currentTimeMillis()) {
                tokenRepository.delete(theToken);
                return true;
            }
        }
        return false;
    }

    @Override
    public Token findTokenByToken(String token) {
        return tokenRepository.findTokenByToken(token);
    }


    public UserMessage getUserMessageByToken(String token) {
        Optional<Token> optionalToken = tokenRepository.findByToken(token);
        if (optionalToken.isPresent()) {
            Token validToken = optionalToken.get();

            UserMessage userMessage = new UserMessage();
            userMessage.setId(validToken.getUserId());
            userMessage.setToken(token);

            return userMessage;
        }
        return null;
    }

    private long calculateExpiryDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, 24);
        return cal.getTimeInMillis();
    }
}
