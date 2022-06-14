package com.juan.estadistica.aplicacion.servicio.Usuario;

import com.juan.estadistica.aplicacion.dto.DtoRespuesta;
import com.juan.estadistica.aplicacion.dto.DtoUsuario;
import com.juan.estadistica.dominio.modelo.RolUsuario;
import com.juan.estadistica.dominio.modelo.Usuario;
import com.juan.estadistica.dominio.servicio.Usuario.ServicioModificarUsuario;

import java.util.Arrays;
import java.util.List;
/*
public class ServicioAplicacionModificarUsuario {

    private final ServicioModificarUsuario servicioModificarUsuario;

    public ServicioAplicacionModificarUsuario(ServicioModificarUsuario servicioModificarUsuario) {
        this.servicioModificarUsuario = servicioModificarUsuario;
    }

    public DtoRespuesta<Long> ejecutar(DtoUsuario dto, Long codigo) {

        List<RolUsuario> roles = Arrays.asList(RolUsuario.of("EMPLEADO"));

        Usuario usuario = Usuario.of( dto.getNombre(), dto.getApellido(), dto.getCargo(), dto.getContrasena(),roles);

        return new DtoRespuesta<>(this.servicioModificarUsuario.ejecutar(usuario, codigo));
    }
}

 */
