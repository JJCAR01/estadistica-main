package com.juan.estadistica.aplicacion.servicio.Jugador;

import com.juan.estadistica.aplicacion.dto.DtoJugador;
import com.juan.estadistica.aplicacion.dto.DtoRespuesta;
import com.juan.estadistica.dominio.modelo.Jugador;
import com.juan.estadistica.dominio.servicio.Jugador.ServicioModificarJugador;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionModificarJugador {

    private final ServicioModificarJugador servicioModificarJugador;

    public ServicioAplicacionModificarJugador(ServicioModificarJugador servicioModificarJugador) {
        this.servicioModificarJugador = servicioModificarJugador;
    }

    public DtoRespuesta<Long> ejecutar(DtoJugador dto, Long codigo) {

        Jugador jugador = Jugador.of(dto.getNombre(), dto.getNumeroIdentificacion(), dto.getEquipo());

        return new DtoRespuesta<>(this.servicioModificarJugador.ejecutar(jugador, codigo));
    }
}
