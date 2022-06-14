package com.juan.estadistica.dominio.modelo;

import com.juan.estadistica.dominio.utilidad.ValidacionTexto;

public class RolUsuario {
    private final String rol;

    public static RolUsuario of(String rol) {

        ValidacionTexto.validarObligatorio(rol, "El rol no puede ser vacio");

        return new RolUsuario(rol);
    }

    private RolUsuario(String rol) {
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }
}