package com.example.safagym.service;

import com.example.safagym.dto.ClienteDTO;
import com.example.safagym.mapper.ClienteMapper;
import com.example.safagym.model.Cliente;
import com.example.safagym.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public Cliente save(ClienteDTO dto){
        Cliente entity = clienteMapper.toEntity(dto);
        entity.getUsuario().setPassword(passwordEncoder.encode(entity.getUsuario().getPassword()));
        return clienteRepository.save(entity);

    }
}
