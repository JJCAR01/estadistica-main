package com.juan.estadistica.dominio.modelo;

import com.juan.estadistica.dominio.utilidad.ValidacionTexto;

import java.util.List;

public class Usuario {

    private final String nombre;
    private final String apellido;
    private final String cargo;
    private String contrasena;
    private List<RolUsuario> roles;

    public static Usuario of(String nombre, String apellido ,String cargo, String contrasena,
                             List<RolUsuario> roles) {

        ValidacionTexto.validarObligatorio(nombre,"El nombre no puede ser vacio");
        ValidacionTexto.validarObligatorio(apellido, "El apellido no puede ser vacio");
        ValidacionTexto.validarObligatorio(cargo, "El cargo no puede ser vacio");
        ValidacionTexto.validarObligatorio(contrasena, "La contraseña no puede estar vacia");
        ValidacionTexto.validarLongitudContrasena(contrasena,"La contraseña debe tener como minimo 8 caracteres y maximo 16 caracteres");
        ValidacionTexto.caracteresEspecialesClave(contrasena,"La contrasena debe tener minimo una mayúscula y un numero");
        ValidacionTexto.validarListaNoVacia(roles, "Debe tener por lo menos un rol");
        return new Usuario(nombre, apellido, cargo, contrasena, roles);
    }
    private Usuario(String nombre, String apellido, String cargo, String contrasena, List<RolUsuario> roles) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.contrasena = contrasena;
        this.roles = roles;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public List<RolUsuario> getRoles() {
        return roles;
    }

    public void asignarClaveCifrada(String contrasena) {
        this.contrasena = contrasena;
    }
}
