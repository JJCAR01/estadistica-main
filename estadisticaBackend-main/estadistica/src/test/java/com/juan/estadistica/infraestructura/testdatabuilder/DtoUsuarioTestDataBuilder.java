package com.juan.estadistica.infraestructura.testdatabuilder;

import com.juan.estadistica.aplicacion.dto.DtoUsuario;

public class DtoUsuarioTestDataBuilder {

    private String nombre;
    private String apellido;
    private String cargo;
    private String contrasena;

    public DtoUsuarioTestDataBuilder() {
        this.nombre = "Juan";
        this.apellido = "CARDONA";
        this.cargo = "empleado";
        this.contrasena = "Asdfghjks1234";
    }

    public DtoUsuarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public DtoUsuarioTestDataBuilder conApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public DtoUsuarioTestDataBuilder conCargo(String cargo) {
        this.cargo = cargo;
        return this;
    }

    public DtoUsuarioTestDataBuilder conContrasena(String contrasena) {
        this.contrasena = contrasena;
        return this;
    }

    public DtoUsuario build() {
        return new DtoUsuario(nombre, apellido, cargo, contrasena);
    }
}