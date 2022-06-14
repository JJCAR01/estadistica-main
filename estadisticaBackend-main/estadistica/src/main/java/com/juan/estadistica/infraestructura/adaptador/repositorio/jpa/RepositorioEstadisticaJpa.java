package com.juan.estadistica.infraestructura.adaptador.repositorio.jpa;

import com.juan.estadistica.infraestructura.adaptador.entidad.EntidadEstadistica;
import com.juan.estadistica.infraestructura.adaptador.entidad.EntidadJugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEstadisticaJpa extends JpaRepository<EntidadEstadistica, Long> {

    EntidadEstadistica findByGolesAndRematesAndAsistencias(int goles, int remates, int asistencias);
}
