package com.example.safagym.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
public class ClienteDTO {


    private Integer id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido1;

    @NotBlank
    private String apellido2;

    @NotBlank
    private String dni;

    @Email
    private String email;

    @Valid
    private UsuarioDTO usuarioDTO;

}
