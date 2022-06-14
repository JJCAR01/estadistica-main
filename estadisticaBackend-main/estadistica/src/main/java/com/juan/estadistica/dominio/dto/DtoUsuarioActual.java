package com.juan.estadistica.dominio.dto;

import lombok.Getter;

import java.util.List;
@Getter
public class DtoUsuarioActual {

    private String nombre;
    private String apellido;
    private String cargo;

    public DtoUsuarioActual() {
    }

    public DtoUsuarioActual(String nombre, String apellido, String cargo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
    }
}
