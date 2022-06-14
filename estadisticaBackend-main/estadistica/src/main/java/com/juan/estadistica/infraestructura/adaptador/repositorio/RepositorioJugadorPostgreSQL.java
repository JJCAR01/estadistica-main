package com.juan.estadistica.infraestructura.adaptador.repositorio;

import com.juan.estadistica.dominio.modelo.Jugador;
import com.juan.estadistica.dominio.puerto.RepositorioJugador;
import com.juan.estadistica.infraestructura.adaptador.entidad.EntidadJugador;
import com.juan.estadistica.infraestructura.adaptador.repositorio.jpa.RepositorioJugadorJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioJugadorPostgreSQL implements RepositorioJugador {

    private final RepositorioJugadorJpa repositorioJugadorJpa;

    public RepositorioJugadorPostgreSQL(RepositorioJugadorJpa repositorioJugadorJpa) {
        this.repositorioJugadorJpa = repositorioJugadorJpa;
    }

    @Override
    public List<Jugador> listar() {
        List<EntidadJugador> entidades = this.repositorioJugadorJpa.findAll();
        return entidades.stream().map(entidad -> Jugador.of(entidad.getNombre(),entidad.getNumeroIdentificacion(),
                entidad.getEquipo())).toList();
    }

    @Override
    public Jugador consultarPorId(Long id) {
        return this.repositorioJugadorJpa
                .findById(id)
                .map(entidad -> Jugador.of(entidad.getNombre(),entidad.getNumeroIdentificacion(), entidad.getEquipo()))
                .orElse(null);
    }

    @Override
    public Long guardar(Jugador jugador) {
        EntidadJugador entidadJugador  = new EntidadJugador(jugador.getNombre(),jugador.getNumeroIdentificacion(),
                jugador.getEquipo());

        return this.repositorioJugadorJpa.save(entidadJugador).getId();
    }

    @Override
    public boolean existe(Jugador jugador) {
        return this.repositorioJugadorJpa.findByNombreAndEquipo(jugador.getNombre(), jugador.getEquipo()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioJugadorJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Jugador jugador, Long id) {

        repositorioJugadorJpa.findById(id);
        EntidadJugador entidadJugador = new EntidadJugador();
        entidadJugador.setId(id);
        entidadJugador.setNombre(jugador.getNombre());
        entidadJugador.setNumeroIdentificacion(jugador.getNumeroIdentificacion());
        entidadJugador.setEquipo(jugador.getEquipo());
        repositorioJugadorJpa.save(entidadJugador);
        return id;
    }


}
