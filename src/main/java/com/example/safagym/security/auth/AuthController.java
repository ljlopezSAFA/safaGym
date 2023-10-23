package com.example.safagym.security.auth;

import com.example.safagym.dto.UsuarioDTO;
import com.example.safagym.model.Usuario;
import com.example.safagym.security.jwt.JWTService;
import com.example.safagym.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JWTService jwtService;


    @PostMapping("/login")
    public AuthDTO login(@RequestBody UsuarioDTO usuarioDTO){
        Usuario usuarioNuevo = (Usuario) usuarioService.loadUserByUsername(usuarioDTO.getUsername());
        String token = jwtService.generateToken(usuarioNuevo);
        return AuthDTO
                .builder()
                .token(token)
                .info("Usuario logueado")
                .build();
    }

    @PostMapping("/register")
    public AuthDTO register(@RequestBody UsuarioDTO usuarioDTO){
        Usuario usuarioNuevo = usuarioService.save(usuarioDTO);
        String token = jwtService.generateToken(usuarioNuevo);

        return AuthDTO
                .builder()
                .token(token)
                .info("Usuario creado correctamente")
                .build();
    }

}
