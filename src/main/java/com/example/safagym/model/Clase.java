package com.example.safagym.model;

import com.example.safagym.enums.TipoClase;
import com.example.safagym.enums.TipoMonitor;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "monitor" , catalog = "postgres", schema = "safagym")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Clase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tipo")
    @Enumerated(EnumType.ORDINAL)
    private TipoClase tipoClase;

    @Column(name = "capacidadf_maxima")
    private Integer capacidadMaxima;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "password")
    private String password;

}
