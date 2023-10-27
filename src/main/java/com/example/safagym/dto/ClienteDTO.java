package com.example.safagym.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteDTO {


    private Integer id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    private String email;
    private UsuarioDTO usuarioDTO;

}
