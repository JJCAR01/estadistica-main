package com.juan.estadistica.dominio.modelo;

import com.juan.estadistica.aplicacion.dto.DtoJugador;
import com.juan.estadistica.dominio.utilidad.ValidacionNumero;
import com.juan.estadistica.dominio.utilidad.ValidacionTexto;
import net.bytebuddy.asm.Advice;

import java.time.LocalDateTime;
import java.util.Date;

public class Estadistica {

    private final String rival;
    private final LocalDateTime fecha;
    private final int jornada;
    private final int goles;
    private final int remates;
    private final int asistencias;
    private final int pases;
    private final int recuperaciones;
    private final int perdidas;
    private final int faltasRecibidas;
    private final int faltasCometidas;
    private Jugador jugador;

    public static Estadistica of(String rival, LocalDateTime fecha, int jornada, int goles, int remates, int asistencias,
                                 int pases, int recuperaciones, int perdidas, int faltasRecibidas, int faltasCometidas, Jugador jugador) {
        ValidacionTexto.validarObligatorio(rival,"El rival no puede ser vacio");
        ValidacionTexto.validarNoVacia(fecha,"La fecha no puede ser vacia");
        ValidacionTexto.validarObligatorio(String.valueOf(jornada),"La jornada no puede ser vacio");
        ValidacionNumero.numeroMayorACero(jornada,"La jornada debe ser mayor a cero");
        ValidacionNumero.numeroMayorACero(goles,"Los goles debe ser mayor a cero o igual");
        ValidacionNumero.numeroMayorACero(remates,"Los remates debe ser mayor a cero o igual");
        ValidacionNumero.numeroMayorACero(asistencias,"Las asistencias debe ser mayor a cero o igual");
        ValidacionNumero.numeroMayorACero(pases,"Los pases debe ser mayor a cero o igual");
        ValidacionNumero.numeroMayorACero(recuperaciones,"Las recuperaciones debe ser mayor a cero o igual");
        ValidacionNumero.numeroMayorACero(perdidas,"Las perdidas debe ser mayor a cero  o igual");
        ValidacionNumero.numeroMayorACero(faltasRecibidas,"Las faltasRecibidas debe ser mayor a cero o igual");
        ValidacionNumero.numeroMayorACero(faltasCometidas,"Las faltasCometidas debe ser mayor a cero o igual");
        ValidacionNumero.numeroMayorACero(recuperaciones,"Las recuperaciones debe ser mayor a cero o igual");

        ValidacionTexto.validarNoVacia(jugador,"El jugador no puede ser vacio");

        return new Estadistica(rival, fecha, jornada, goles, remates, asistencias, pases, recuperaciones, perdidas, faltasRecibidas, faltasCometidas, jugador);
    }

    public Estadistica(String rival, LocalDateTime fecha, int jornada, int goles, int remates, int asistencias,
                       int pases, int recuperaciones, int perdidas, int faltasRecibidas, int faltasCometidas, Jugador jugador) {
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

    public String getRival() {
        return rival;
    }

    public LocalDateTime getFecha() {return fecha;}

    public int getJornada() {
        return jornada;
    }

    public int getGoles() {
        return goles;
    }

    public int getRemates() {
        return remates;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public int getPases() {
        return pases;
    }

    public int getRecuperaciones() {
        return recuperaciones;
    }

    public int getPerdidas() {
        return perdidas;
    }

    public int getFaltasRecibidas() {
        return faltasRecibidas;
    }

    public int getFaltasCometidas() {
        return faltasCometidas;
    }

    public Jugador getJugador() {
        return jugador;
    }
}
