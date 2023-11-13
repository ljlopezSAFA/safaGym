package com.example.safagym.dto;

import com.example.safagym.enums.Rol;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UsuarioDTO {

    private Integer id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private Rol rol;
}
