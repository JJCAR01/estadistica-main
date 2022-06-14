package com.juan.estadistica.dominio.puerto;

import com.juan.estadistica.aplicacion.dto.DtoUsuario;
import com.juan.estadistica.dominio.dto.DtoUsuarioActual;
import com.juan.estadistica.dominio.modelo.Usuario;

import java.util.List;

public interface RepositorioUsuario {

    List<Usuario> listar();
    Usuario consultarPorId(Long id);
    Long guardar(Usuario usuario);
    boolean existe(Usuario usuario);
    Long eliminar(Long id);
    Long modificar(Usuario usuario, Long id);
    Usuario consultar(String usuario, String clave);
}
