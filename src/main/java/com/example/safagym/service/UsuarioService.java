package com.example.safagym.service;

import com.example.safagym.dto.UsuarioDTO;
import com.example.safagym.mapper.UsuarioMapper;
import com.example.safagym.model.Usuario;
import com.example.safagym.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findTopByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("Usuario no encontrado"));
    }


    public Usuario buscarPorUsername(String username){
        return usuarioRepository.findTopByUsername(username).orElse(null);
    }

    public Usuario save(UsuarioDTO dto){
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        return  usuarioRepository.save(usuarioMapper.toEntity(dto));
    }

    public boolean validarPassword(Usuario usuario, String passwordSinEncriptar){
        return passwordEncoder.matches(passwordSinEncriptar, usuario.getPassword());
    }
}
