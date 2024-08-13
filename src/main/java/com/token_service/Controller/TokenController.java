package com.token_service.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.token_service.Entities.UserMessage;
import com.token_service.Service.TokenService;



@RestController
@RequestMapping("/token")
@Tag(name = "Api Rest for brands use Swagger 3 - Token")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/verify")
    @Operation(summary = "This endpoint is used for verify token")
    public ResponseEntity<?> verifyToken(@RequestParam("token") String token) {
        UserMessage userMessage = tokenService.getUserMessageByToken(token);
        if (userMessage != null && tokenService.validateToken(token)) {
            userMessage.setEnabled(true);
            rabbitTemplate.convertAndSend("user.update.queue", userMessage);

            tokenService.confirmToken(token);
            return ResponseEntity.ok("Token is valid. User account is confirmed.");
        } else {
            return ResponseEntity.badRequest().body("Invalid or expired token.");
        }
    }
}
