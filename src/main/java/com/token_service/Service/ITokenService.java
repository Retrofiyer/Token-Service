package com.token_service.Service;

import com.token_service.Entities.Token;

public interface ITokenService {
    Token createToken(Long userId);

    boolean validateToken(String token);

    Token findTokenByToken(String token);
}
