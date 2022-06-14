package com.juan.estadistica.infraestructura.adaptador.repositorio.jpa;

import com.juan.estadistica.infraestructura.adaptador.entidad.EntidadJugador;
import com.juan.estadistica.infraestructura.adaptador.entidad.EntidadUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioJugadorJpa extends JpaRepository<EntidadJugador, Long> {

    EntidadJugador findByNombreAndEquipo(String nombre, String equipo);
}
