package com.juan.estadistica.infraestructura.testdatabuilder;

import com.juan.estadistica.aplicacion.dto.DtoLogin;

public class DtoLoginTestDataBuilder {

    private String usuario;
    private String clave;

    public DtoLoginTestDataBuilder() {
        this.usuario = "Jose";
        this.clave = "Asfsfdf36";
    }

    public DtoLoginTestDataBuilder conUsuario(String usuario) {
        this.usuario = usuario;
        return this;
    }

    public DtoLogin build() {
        return new DtoLogin(usuario, clave);
    }
}
