package com.juan.estadistica.infraestructura.adaptador.repositorio;

import com.juan.estadistica.dominio.modelo.Estadistica;
import com.juan.estadistica.dominio.modelo.Jugador;
import com.juan.estadistica.dominio.puerto.RepositorioEstadistica;
import com.juan.estadistica.infraestructura.adaptador.entidad.EntidadEstadistica;
import com.juan.estadistica.infraestructura.adaptador.entidad.EntidadJugador;
import com.juan.estadistica.infraestructura.adaptador.repositorio.jpa.RepositorioEstadisticaJpa;
import com.juan.estadistica.infraestructura.adaptador.repositorio.jpa.RepositorioJugadorJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioEstadisticaPostgreSQL implements RepositorioEstadistica {

    private final RepositorioEstadisticaJpa repositorioEstadisticaJpa;
    private final RepositorioJugadorJpa repositorioJugadorJpa;

    public RepositorioEstadisticaPostgreSQL(RepositorioEstadisticaJpa repositorioEstadisticaJpa, RepositorioJugadorJpa repositorioJugadorJpa) {
        this.repositorioEstadisticaJpa = repositorioEstadisticaJpa;
        this.repositorioJugadorJpa = repositorioJugadorJpa;
    }

    @Override
    public List<Estadistica> listar() {
        List<EntidadEstadistica> entidades = this.repositorioEstadisticaJpa.findAll();
        return entidades.stream().map(entidad-> Estadistica.of(entidad.getRival(),entidad.getFecha(),
                entidad.getJornada(),entidad.getGoles(),entidad.getRemates(),entidad.getAsistencias(),
                entidad.getPases(),entidad.getRecuperaciones(),entidad.getPerdidas(),
                entidad.getFaltasCometidas(),entidad.getFaltasRecibidas(),
                Jugador.of(entidad.getJugador().getNombre(),entidad.getJugador().getNumeroIdentificacion(),
                        entidad.getJugador().getEquipo()))).toList();
    }

    @Override
    public Estadistica consultarPorId(Long id) {
        return this.repositorioEstadisticaJpa
                .findById(id)
                .map(entidad -> Estadistica.of(entidad.getRival(),entidad.getFecha(),
                        entidad.getJornada(),entidad.getGoles(),entidad.getRemates(),entidad.getAsistencias(),
                        entidad.getPases(),entidad.getRecuperaciones(),entidad.getPerdidas(),
                        entidad.getFaltasCometidas(),entidad.getFaltasRecibidas(),
                        Jugador.of(entidad.getJugador().getNombre(),entidad.getJugador().getNumeroIdentificacion(),
                                entidad.getJugador().getEquipo()))).orElse(null);
    }

    @Override
    public Long guardar(Estadistica estadistica) {
        EntidadJugador entidadJugador = this.repositorioJugadorJpa.findByNombreAndEquipo(estadistica.getJugador().getNombre(),
                estadistica.getJugador().getEquipo());

        EntidadEstadistica entidadEstadistica  = new EntidadEstadistica(estadistica.getRival(),estadistica.getFecha(),
                estadistica.getJornada(),estadistica.getGoles(),estadistica.getRemates(),estadistica.getAsistencias(),
                estadistica.getPases(),estadistica.getRecuperaciones(),estadistica.getPerdidas(),
                estadistica.getFaltasCometidas(),estadistica.getFaltasRecibidas(),
                entidadJugador);

        return this.repositorioEstadisticaJpa.save(entidadEstadistica).getId();
    }

    @Override
    public boolean existe(Estadistica estadistica) {
        return this.repositorioEstadisticaJpa.findByGolesAndRematesAndAsistencias(estadistica.getGoles(),estadistica.getRemates(),
                estadistica.getAsistencias()) != null;
    }

    @Override
    public Long eliminar(Long id) {
        this.repositorioEstadisticaJpa.deleteById(id);
        return id;
    }

    @Override
    public Long modificar(Estadistica estadistica, Long id) {
        repositorioEstadisticaJpa.findById(id);
        EntidadJugador entidadJugador = this.repositorioJugadorJpa.findByNombreAndEquipo(estadistica.getJugador().getNombre(),
                estadistica.getJugador().getEquipo());

        EntidadEstadistica entidadEstadistica = new EntidadEstadistica();
        entidadEstadistica.setId(id);
        entidadEstadistica.setRival(estadistica.getRival());
        entidadEstadistica.setFecha(estadistica.getFecha());
        entidadEstadistica.setJornada(estadistica.getJornada());
        entidadEstadistica.setGoles(estadistica.getGoles());
        entidadEstadistica.setRemates(estadistica.getRemates());
        entidadEstadistica.setPases(estadistica.getPases());
        entidadEstadistica.setAsistencias(estadistica.getAsistencias());
        entidadEstadistica.setPerdidas(estadistica.getPerdidas());
        entidadEstadistica.setRecuperaciones(estadistica.getRecuperaciones());
        entidadEstadistica.setFaltasRecibidas(estadistica.getFaltasRecibidas());
        entidadEstadistica.setFaltasCometidas(estadistica.getFaltasCometidas());


        entidadEstadistica.setJugador(entidadJugador);

        repositorioEstadisticaJpa.save(entidadEstadistica);
        return id;
    }
}
