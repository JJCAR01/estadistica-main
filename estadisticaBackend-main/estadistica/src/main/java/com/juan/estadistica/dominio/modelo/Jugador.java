package com.juan.estadistica.dominio.modelo;

import com.juan.estadistica.aplicacion.dto.DtoJugador;
import com.juan.estadistica.dominio.utilidad.ValidacionNumero;
import com.juan.estadistica.dominio.utilidad.ValidacionTexto;

import java.util.List;

public class Jugador {

    private final String nombre;
    private final String numeroIdentificacion;
    private final String equipo;

    public static Jugador of(String nombre, String numeroIdentificacion,String equipo){
        ValidacionTexto.validarObligatorio(nombre,"El ombre no puede ser vacio");
        ValidacionTexto.validarObligatorio(numeroIdentificacion,"El numero de Identificacion no puede ser vació");
        ValidacionTexto.validarObligatorio(equipo,"El nombre del equipo no puede ser vacio");
        return new Jugador(nombre,numeroIdentificacion,equipo);
    }

    public Jugador(String nombre, String numeroIdentificacion, String equipo) {
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
        this.equipo = equipo;
    }

    public String getNombre() {return nombre;}

    public String getNumeroIdentificacion() {return numeroIdentificacion;}

    public String getEquipo() {return equipo;}
}
