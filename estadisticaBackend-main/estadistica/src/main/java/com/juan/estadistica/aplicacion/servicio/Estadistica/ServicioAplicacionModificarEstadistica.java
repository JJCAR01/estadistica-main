package com.juan.estadistica.aplicacion.servicio.Estadistica;

import com.juan.estadistica.aplicacion.dto.DtoEstadistica;
import com.juan.estadistica.aplicacion.dto.DtoRespuesta;
import com.juan.estadistica.dominio.modelo.Estadistica;
import com.juan.estadistica.dominio.modelo.Jugador;
import com.juan.estadistica.dominio.servicio.Estadistica.ServicioModificarEstadistica;
import com.juan.estadistica.dominio.servicio.Jugador.ServicioModificarJugador;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarEstadistica {

    private final ServicioModificarEstadistica servicioModificarEstadistica;

    public ServicioAplicacionModificarEstadistica(ServicioModificarEstadistica servicioModificarEstadistica) {
        this.servicioModificarEstadistica = servicioModificarEstadistica;
    }

    public DtoRespuesta<Long> ejecutar(DtoEstadistica dto, Long codigo) {

        Jugador jugador = Jugador.of(dto.getJugador().getNombre(),dto.getJugador().getNumeroIdentificacion(), dto.getJugador().getEquipo());

        Estadistica estadistica = Estadistica.of(dto.getRival(),dto.getFecha(),dto.getJornada(),dto.getGoles(),
                dto.getRemates(),dto.getAsistencias(),dto.getPases(),dto.getRecuperaciones(),dto.getPerdidas(),
                dto.getFaltasRecibidas(),dto.getFaltasCometidas(),jugador);


        return new DtoRespuesta<>(this.servicioModificarEstadistica.ejecutar(estadistica, codigo));
    }
}
