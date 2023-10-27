package com.example.safagym.security.auth;

import com.example.safagym.dto.ClienteDTO;
import com.example.safagym.dto.UsuarioDTO;
import com.example.safagym.model.Cliente;
import com.example.safagym.model.Token;
import com.example.safagym.model.Usuario;
import com.example.safagym.security.jwt.JWTService;
import com.example.safagym.service.ClienteService;
import com.example.safagym.service.TokenService;
import com.example.safagym.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ClienteService clienteService;


    @PostMapping("/login")
    public AuthDTO login(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = (Usuario) usuarioService.loadUserByUsername(usuarioDTO.getUsername());
        String apiKey = null;
        String mensaje;

        if (usuario != null) {
            if (usuarioService.validarPassword(usuario, usuarioDTO.getPassword())) {

                mensaje = "Usuario Logueado";

                //Usuario sin token
                if (usuario.getToken() == null) {
                    apiKey = jwtService.generateToken(usuario);
                    Token token = new Token();
                    token.setUsuario(usuario);
                    token.setToken(apiKey);
                    token.setFechaExpiracion(LocalDateTime.now().plusDays(1));
                    tokenService.save(token);

                    //Usuario con token caducado
                } else if (usuario.getToken().getFechaExpiracion().isBefore(LocalDateTime.now())) {
                    Token token = usuario.getToken();
                    apiKey = jwtService.generateToken(usuario);
                    token.setToken(apiKey);
                    token.setFechaExpiracion(LocalDateTime.now().plusDays(1));
                    tokenService.save(token);

                    //Usuario con token válido
                } else {
                    apiKey = usuario.getToken().getToken();
                }
            } else {
                mensaje = "Contraseña no válida";
            }
        } else {
            mensaje = "Usuario No encontrado";
        }

        return AuthDTO
                .builder()
                .token(apiKey)
                .info(mensaje)
                .build();
    }


    @PostMapping("/register")
    public AuthDTO register(@RequestBody ClienteDTO clienteDTO) {

        Cliente clieneNuevo = clienteService.save(clienteDTO);

        String token = jwtService.generateToken(clieneNuevo.getUsuario());

        return AuthDTO
                .builder()
                .token(token)
                .info("Usuario creado correctamente")
                .build();
    }
}


