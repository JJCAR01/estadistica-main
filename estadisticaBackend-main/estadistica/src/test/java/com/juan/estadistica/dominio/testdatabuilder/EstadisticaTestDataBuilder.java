package com.juan.estadistica.dominio.testdatabuilder;

import com.juan.estadistica.dominio.modelo.Estadistica;
import com.juan.estadistica.dominio.modelo.Jugador;

import java.time.LocalDateTime;

public class EstadisticaTestDataBuilder {

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

    public EstadisticaTestDataBuilder() {
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
    public EstadisticaTestDataBuilder conRival(String rival) {
        this.rival = rival;
        return this;
    }

    public EstadisticaTestDataBuilder conFecha(LocalDateTime fecha) {
        this.fecha = fecha;
        return this;
    }
    public EstadisticaTestDataBuilder conJornada(int jornada) {
        this.jornada = jornada;
        return this;
    }

    public EstadisticaTestDataBuilder conGoles(int goles) {
        this.goles = goles;
        return this;
    }
    public EstadisticaTestDataBuilder conRemates(int remates) {
        this.remates = remates;
        return this;
    }

    public EstadisticaTestDataBuilder conAsistencias(int asistencias) {
        this.asistencias = asistencias;
        return this;
    }
    public EstadisticaTestDataBuilder conPases(int pases) {
        this.pases = pases;
        return this;
    }
    public EstadisticaTestDataBuilder conRecuperaciones(int recuperaciones) {
        this.recuperaciones = recuperaciones;
        return this;
    }
    public EstadisticaTestDataBuilder conPerdidas(int perdidas) {
        this.perdidas = perdidas;
        return this;
    }
    public EstadisticaTestDataBuilder conFaltasCometidas(int faltasCometidas) {
        this.faltasCometidas = faltasCometidas;
        return this;
    }
    public EstadisticaTestDataBuilder conFaltasRecibidas(int faltasRecibidas) {
        this.faltasRecibidas = faltasRecibidas;
        return this;
    }

    public EstadisticaTestDataBuilder conJugador(Jugador jugador){
        this.jugador = jugador;
        return this;
    }



    public Estadistica build() {
        return new Estadistica(rival,fecha,jornada,goles,remates,asistencias,pases,recuperaciones,
                perdidas,faltasCometidas,faltasRecibidas,jugador);
    }
}
