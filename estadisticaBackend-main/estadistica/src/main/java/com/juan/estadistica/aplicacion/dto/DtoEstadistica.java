package com.juan.estadistica.aplicacion.dto;

import com.juan.estadistica.dominio.modelo.Jugador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Getter
public class DtoEstadistica {

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
    DtoJugador jugador;

    public DtoEstadistica(String rival, LocalDateTime fecha, int jornada, int goles, int remates, int asistencias, int pases, int recuperaciones, int perdidas, int faltasCometidas, int faltasRecibidas, Jugador jugador) {
    }
}
