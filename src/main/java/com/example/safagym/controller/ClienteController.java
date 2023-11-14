package com.example.safagym.controller;

import com.example.safagym.dto.ClienteDTO;
import com.example.safagym.service.ClienteService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cliente")
@SecurityRequirement(name = "Bearer Authentication")
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

    @PostMapping("/crear")
    public ClienteDTO crearCliente(@Valid @RequestBody ClienteDTO clienteDTO){
        return null;
    }

}
