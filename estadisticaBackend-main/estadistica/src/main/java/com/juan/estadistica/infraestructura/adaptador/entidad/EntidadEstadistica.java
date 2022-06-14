package com.juan.estadistica.infraestructura.adaptador.entidad;

import com.juan.estadistica.dominio.modelo.Jugador;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;



@Getter
@Setter
@Entity
@Table(name = "estadisticas")
public class EntidadEstadistica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String rival;
    private LocalDateTime fecha;
    private int jornada;
    private int goles;
    private int remates;
    private int asistencias;
    private int pases;
    private int recuperaciones;
    private int perdidas;
    private int faltasRecibidas;
    private int faltasCometidas;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "jugador_id")
    private EntidadJugador jugador;

    public EntidadEstadistica(){}

    public EntidadEstadistica(String rival, LocalDateTime fecha, int jornada, int goles, int remates, int asistencias, int pases,
                              int recuperaciones, int perdidas, int faltasRecibidas, int faltasCometidas, EntidadJugador jugador) {
        this.rival = rival;
        this.fecha = fecha;
        this.jornada = jornada;
        this.goles = goles;
        this.remates = remates;
        this.asistencias = asistencias;
        this.pases = pases;
        this.recuperaciones = recuperaciones;
        this.perdidas = perdidas;
        this.faltasRecibidas = faltasRecibidas;
        this.faltasCometidas = faltasCometidas;
        this.jugador = jugador;
    }

}

