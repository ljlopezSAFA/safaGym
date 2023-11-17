package com.example.safagym.service;

import com.example.safagym.dto.ClienteDTO;
import com.example.safagym.mapper.ClienteMapper;
import com.example.safagym.model.Cliente;
import com.example.safagym.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<ClienteDTO> getAll(){
        return clienteMapper.toDTO(clienteRepository.findAll());
    }
    public Cliente save(ClienteDTO dto){
        Cliente entity = clienteMapper.toEntity(dto);
        entity.getUsuario().setPassword(passwordEncoder.encode(entity.getUsuario().getPassword()));
        return clienteRepository.save(entity);
    }


    public List<ClienteDTO> buscarClientePorFiltror(String nombre, String letraDNI){
        if(nombre!= null && letraDNI != null){
            return clienteMapper.toDTO(clienteRepository.buscarPorLetraDNIYNombre(letraDNI,nombre));
        } else if (nombre==null && letraDNI!=null) {
            return clienteMapper.toDTO(clienteRepository.buscarPorLetraDNI(letraDNI));
        }else if(nombre != null){
            return clienteMapper.toDTO(clienteRepository.buscarPorNombre(nombre));
        }else{
            return clienteMapper.toDTO(clienteRepository.findAll());
        }
    }

}
