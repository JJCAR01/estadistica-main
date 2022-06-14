package com.juan.estadistica.infraestructura.testdatabuilder;

import com.juan.estadistica.aplicacion.dto.DtoJugador;

public class DtoJugadorTestDataBuilder {

    private String nombre;
    private String numeroIdentificacion;
    private String equipo;

    public DtoJugadorTestDataBuilder() {
        this.nombre = "Juan";
        this.numeroIdentificacion = "23234324f";
        this.equipo = "Nal";
    }

    public DtoJugadorTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public DtoJugadorTestDataBuilder conNumeroIdentificacion(String apellido) {
        this.numeroIdentificacion = numeroIdentificacion;
        return this;
    }
    public DtoJugadorTestDataBuilder conEquipo(String equipo) {
        this.equipo = equipo;
        return this;
    }

    public DtoJugador build() {
        return new DtoJugador(nombre, numeroIdentificacion,equipo);
    }
}
