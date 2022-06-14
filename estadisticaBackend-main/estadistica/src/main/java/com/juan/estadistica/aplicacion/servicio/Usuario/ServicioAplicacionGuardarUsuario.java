package com.juan.estadistica.aplicacion.servicio.Usuario;

import com.juan.estadistica.aplicacion.dto.DtoRespuesta;
import com.juan.estadistica.aplicacion.dto.DtoUsuario;
import com.juan.estadistica.dominio.modelo.RolUsuario;
import com.juan.estadistica.dominio.modelo.Usuario;
import com.juan.estadistica.dominio.servicio.ServicioCifrarTexto;
import com.juan.estadistica.dominio.servicio.Usuario.ServicioGuardarUsuario;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ServicioAplicacionGuardarUsuario {

    private final ServicioGuardarUsuario servicioGuardarUsuario;
    private final ServicioCifrarTexto servicioCifrarTexto;

    public ServicioAplicacionGuardarUsuario(ServicioGuardarUsuario servicioGuardarUsuario, ServicioCifrarTexto servicioCifrarTexto) {
        this.servicioGuardarUsuario = servicioGuardarUsuario;
        this.servicioCifrarTexto = servicioCifrarTexto;
    }

    public DtoRespuesta<Long> ejecutar(DtoUsuario dto) {

        List<RolUsuario> roles = Arrays.asList(RolUsuario.of("EMPLEADO"));

        Usuario usuario = Usuario.of(dto.getNombre(), dto.getApellido(), dto.getCargo(), dto.getContrasena(), roles);

        String claveCifrada = this.servicioCifrarTexto.ejecutar(usuario.getContrasena());

        usuario.asignarClaveCifrada(claveCifrada);

        return new DtoRespuesta<>(this.servicioGuardarUsuario.ejecutar(usuario));
    }
}
