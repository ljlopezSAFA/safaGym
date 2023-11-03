package com.example.safagym.controller;

import com.example.safagym.dto.ClienteDTO;
import com.example.safagym.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/all")
    public List<ClienteDTO> obtenerTodos(){
        return clienteService.getAll();
    }

    @GetMapping("/find")
    public List<ClienteDTO> buscarPorNombre(@RequestParam String nombre){
        return clienteService.buscarPorNombre(nombre);
    }
}
