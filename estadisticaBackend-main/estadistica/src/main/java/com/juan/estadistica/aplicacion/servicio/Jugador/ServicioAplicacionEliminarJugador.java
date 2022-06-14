package com.juan.estadistica.aplicacion.servicio.Jugador;

import com.juan.estadistica.aplicacion.dto.DtoRespuesta;
import com.juan.estadistica.dominio.servicio.Jugador.ServicioEliminarJugador;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarJugador {

    private final ServicioEliminarJugador servicioEliminarJugador;

    public ServicioAplicacionEliminarJugador(ServicioEliminarJugador servicioEliminarJugador) {
        this.servicioEliminarJugador = servicioEliminarJugador;
    }

    public DtoRespuesta<Long> ejecutar(long codigo) {

        return new DtoRespuesta<>(this.servicioEliminarJugador.ejecutar(codigo));
    }
}
