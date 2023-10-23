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
public class Tarifa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tipo")
    @Enumerated(EnumType.ORDINAL)
    private TipoMonitor tipo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio_mensual")
    private Double precioMensual;

    @Column(name = "incluye_clases")
    private boolean incluyeClases;

}
