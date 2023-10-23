package com.example.safagym.dto;

import com.example.safagym.enums.Rol;
import lombok.Data;

@Data
public class UsuarioDTO {

    private Integer id;

    private String username;

    private String password;

    private Rol rol;
}
