package com.example.safagym.model;

import com.example.safagym.enums.TipoMonitor;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "monitor" , catalog = "postgres", schema = "safagym")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
public class Monitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido1")
    private String apellido1;

    @Column(name = "apellido2")
    private String apellido2;

    @Column(name = "tipo")
    @Enumerated(EnumType.ORDINAL)
    private TipoMonitor tipo;


}
