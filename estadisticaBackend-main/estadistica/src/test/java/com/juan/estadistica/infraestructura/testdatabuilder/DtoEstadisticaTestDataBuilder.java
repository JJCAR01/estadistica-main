package com.juan.estadistica.infraestructura.testdatabuilder;

import com.juan.estadistica.aplicacion.dto.DtoEstadistica;
import com.juan.estadistica.aplicacion.dto.DtoJugador;
import com.juan.estadistica.dominio.modelo.Jugador;

import java.time.LocalDateTime;

public class DtoEstadisticaTestDataBuilder {

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
    private Jugador jugador;

    public DtoEstadisticaTestDataBuilder() {
        this.rival = "Nal";
        this.fecha = LocalDateTime.now();
        this.jornada = 1;
        this.goles = 1;
        this.remates = 5;
        this.asistencias = 2;
        this.pases = 30;
        this.recuperaciones = 6;
        this.perdidas = 3;
        this.faltasRecibidas = 2;
        this.faltasCometidas = 4;
        this.jugador = Jugador.of("Juan","23234324f", "Nal");
    }

    public DtoEstadisticaTestDataBuilder conRival(String rival) {
        this.rival = rival;
        return this;
    }

    public DtoEstadisticaTestDataBuilder conFecha(LocalDateTime fecha) {
        this.fecha = fecha;
        return this;
    }
    public DtoEstadisticaTestDataBuilder conJornada(int jornada) {
        this.jornada = jornada;
        return this;
    }

    public DtoEstadisticaTestDataBuilder conGoles(int goles) {
        this.goles = goles;
        return this;
    }
    public DtoEstadisticaTestDataBuilder conRemates(int remates) {
        this.remates = remates;
        return this;
    }

    public DtoEstadisticaTestDataBuilder conAsistencias(int asistencias) {
        this.asistencias = asistencias;
        return this;
    }
    public DtoEstadisticaTestDataBuilder conPases(int pases) {
        this.pases = pases;
        return this;
    }
    public DtoEstadisticaTestDataBuilder conRecuperaciones(int recuperaciones) {
        this.recuperaciones = recuperaciones;
        return this;
    }
    public DtoEstadisticaTestDataBuilder conPerdidas(int perdidas) {
        this.perdidas = perdidas;
        return this;
    }
    public DtoEstadisticaTestDataBuilder conFaltasCometidas(int faltasCometidas) {
        this.faltasCometidas = faltasCometidas;
        return this;
    }
    public DtoEstadisticaTestDataBuilder conFaltasRecibidas(int faltasRecibidas) {
        this.faltasRecibidas = faltasRecibidas;
        return this;
    }

    public DtoEstadisticaTestDataBuilder conJugador(Jugador jugador){
        this.jugador = jugador;
        return this;
    }



    public DtoEstadistica build() {
        return new DtoEstadistica(rival,fecha,jornada,goles,remates,asistencias,pases,recuperaciones,
                perdidas,faltasCometidas,faltasRecibidas,jugador);
    }
}
