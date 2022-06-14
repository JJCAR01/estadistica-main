package com.juan.estadistica.infraestructura.adaptador.entidad;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "jugadores")
public class EntidadJugador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String numeroIdentificacion;
    private String equipo;

    public EntidadJugador() {}

    public EntidadJugador(String nombre, String numeroIdentificacion, String equipo) {
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
        this.equipo = equipo;
    }

}
