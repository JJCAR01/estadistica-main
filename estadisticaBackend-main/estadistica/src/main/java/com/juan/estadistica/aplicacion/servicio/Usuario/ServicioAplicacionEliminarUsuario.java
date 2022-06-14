package com.juan.estadistica.aplicacion.servicio.Usuario;

import com.juan.estadistica.aplicacion.dto.DtoRespuesta;
import com.juan.estadistica.dominio.servicio.Usuario.ServicioEliminarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarUsuario {

    private final ServicioEliminarUsuario servicioEliminarUsuario;

    public ServicioAplicacionEliminarUsuario(ServicioEliminarUsuario servicioEliminarUsuario) {
        this.servicioEliminarUsuario = servicioEliminarUsuario;
    }

    public DtoRespuesta<Long> ejecutar(long codigo) {

        return new DtoRespuesta<>(this.servicioEliminarUsuario.ejecutar(codigo));
    }
}
