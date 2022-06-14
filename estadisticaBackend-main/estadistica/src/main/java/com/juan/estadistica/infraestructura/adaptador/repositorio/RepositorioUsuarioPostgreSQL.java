package com.juan.estadistica.infraestructura.adaptador.repositorio;

import com.juan.estadistica.dominio.dto.DtoUsuarioActual;
import com.juan.estadistica.dominio.modelo.RolUsuario;
import com.juan.estadistica.dominio.modelo.Usuario;
import com.juan.estadistica.dominio.puerto.RepositorioUsuario;
import com.juan.estadistica.infraestructura.adaptador.entidad.EntidadRolUsuario;
import com.juan.estadistica.infraestructura.adaptador.entidad.EntidadUsuario;
import com.juan.estadistica.infraestructura.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioUsuarioPostgreSQL implements RepositorioUsuario {

    private final RepositorioUsuarioJpa repositorioUsuarioJpa;


    public RepositorioUsuarioPostgreSQL(RepositorioUsuarioJpa repositorioUsuarioJpa) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
    }


    @Override
    public List<Usuario> listar() {
        return null;
    }

    @Override
    public Usuario consultarPorId(Long id) {
        return null;
    }

    @Override
    public Long guardar(Usuario usuario) {

        List<EntidadRolUsuario> roles = usuario.getRoles().stream().map(rol -> new EntidadRolUsuario(rol.getRol())).toList();
        EntidadUsuario entidadUsuario = new EntidadUsuario(usuario.getNombre(), usuario.getApellido(), usuario.getCargo(), usuario.getContrasena(),roles);

        return this.repositorioUsuarioJpa.save(entidadUsuario).getId();

    }

    @Override
    public boolean existe(Usuario usuario) {
        return this.repositorioUsuarioJpa.findByNombreAndApellido(usuario.getNombre(), usuario.getApellido()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioUsuarioJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Usuario usuario, Long id) {

        repositorioUsuarioJpa.findById(id);
        EntidadUsuario entidadUsuario = new EntidadUsuario();
        entidadUsuario.setId(id);
        entidadUsuario.setNombre(usuario.getNombre());
        entidadUsuario.setApellido(usuario.getApellido());
        entidadUsuario.setCargo(usuario.getCargo());
        entidadUsuario.setContrasena(usuario.getContrasena());
        repositorioUsuarioJpa.save(entidadUsuario);
        return id;
    }

    @Override
    public Usuario consultar(String usuario, String clave) {
        EntidadUsuario entidadUsuario = this.repositorioUsuarioJpa.findByNombreAndContrasena(usuario, clave);

        if(entidadUsuario == null) {
            return null;
        }

        List<RolUsuario> roles = entidadUsuario.getRoles().stream().map(rol -> RolUsuario.of(rol.getRol())).toList();

        return Usuario.of(entidadUsuario.getNombre(), entidadUsuario.getApellido(), entidadUsuario.getCargo(), entidadUsuario.getContrasena(), roles);
    }
}
