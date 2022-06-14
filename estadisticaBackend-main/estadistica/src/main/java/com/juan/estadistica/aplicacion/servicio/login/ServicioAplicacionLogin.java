package com.juan.estadistica.aplicacion.servicio.login;

import com.juan.estadistica.aplicacion.dto.DtoLogin;
import com.juan.estadistica.aplicacion.dto.DtoRespuesta;
import com.juan.estadistica.dominio.modelo.RolUsuario;
import com.juan.estadistica.dominio.modelo.Usuario;
import com.juan.estadistica.dominio.puerto.RepositorioUsuario;
import com.juan.estadistica.dominio.servicio.ServicioCifrarTexto;
import com.juan.estadistica.dominio.servicio.ServicioGenerarToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionLogin {

    private final ServicioGenerarToken servicioGenerarToken;
    private final ServicioCifrarTexto servicioCifrarTexto;
    private final RepositorioUsuario repositorioUsuario;

    public ServicioAplicacionLogin(ServicioGenerarToken servicioGenerarToken,ServicioCifrarTexto servicioCifrarTexto,
                                   RepositorioUsuario repositorioUsuario) {
        this.servicioGenerarToken = servicioGenerarToken;
        this.servicioCifrarTexto = servicioCifrarTexto;
        this.repositorioUsuario = repositorioUsuario;
    }

    public DtoRespuesta<String> ejecutar(DtoLogin dto) {

        String claveCifrada = this.servicioCifrarTexto.ejecutar(dto.getClave());
        Usuario usuario = this.repositorioUsuario.consultar(dto.getUsuario(), claveCifrada);

        if(usuario == null) {
            throw new IllegalStateException("Usuario o clave incorrecta");
        }

        List<String> roles = usuario.getRoles().stream().map(RolUsuario::getRol).toList();

        return new DtoRespuesta<>(this.servicioGenerarToken.ejecutar(dto.getUsuario(), roles));
    }

}
