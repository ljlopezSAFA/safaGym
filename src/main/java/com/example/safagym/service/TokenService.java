package com.example.safagym.service;

import com.example.safagym.model.Token;
import com.example.safagym.model.Usuario;
import com.example.safagym.repository.ITokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final ITokenRepository tokenRepository;


    public Token getByUsuario(Usuario usuario){
        return tokenRepository.findTopByUsuario(usuario);
    }

    public Token save(Token token){
        return tokenRepository.save(token);
    }

}
