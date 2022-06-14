package com.juan.estadistica.aplicacion.servicio.Jugador;

import com.juan.estadistica.aplicacion.dto.DtoJugador;
import com.juan.estadistica.aplicacion.dto.DtoRespuesta;
import com.juan.estadistica.dominio.modelo.Jugador;
import com.juan.estadistica.dominio.servicio.Jugador.ServicioGuardarJugador;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarJugador {

    private final ServicioGuardarJugador servicioGuardarJugador;

    public ServicioAplicacionGuardarJugador(ServicioGuardarJugador servicioGuardarJugador) {
        this.servicioGuardarJugador = servicioGuardarJugador;
    }

    public DtoRespuesta<Long> ejecutar(DtoJugador dto) {

        Jugador jugador = Jugador.of(dto.getNombre(),dto.getNumeroIdentificacion(), dto.getEquipo());

        return new DtoRespuesta<>(this.servicioGuardarJugador.ejecutar(jugador));
    }
}
