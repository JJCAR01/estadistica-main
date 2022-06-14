package com.juan.estadistica.aplicacion.servicio.Usuario;

import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;
import com.juan.estadistica.aplicacion.dto.DtoUsuario;
import com.juan.estadistica.dominio.modelo.Usuario;
import com.juan.estadistica.dominio.puerto.RepositorioUsuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarUsuario {

    private final RepositorioUsuario repositorioUsuario;

    public ServicioAplicacionListarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public List<Usuario> ejecutar() {
        return this.repositorioUsuario.listar();
    }

    public Usuario consultar(Long id) {return this.repositorioUsuario.consultarPorId(id);}

}
