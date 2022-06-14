package com.juan.estadistica.aplicacion.servicio.Estadistica;


import com.juan.estadistica.aplicacion.dto.DtoEstadistica;
import com.juan.estadistica.aplicacion.dto.DtoRespuesta;
import com.juan.estadistica.dominio.modelo.Estadistica;
import com.juan.estadistica.dominio.modelo.Jugador;
import com.juan.estadistica.dominio.servicio.Estadistica.ServicioGuardarEstadistica;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarEstadistica {

    private final ServicioGuardarEstadistica servicioGuardarEstadistica;

    public ServicioAplicacionGuardarEstadistica(ServicioGuardarEstadistica servicioGuardarEstadistica) {
        this.servicioGuardarEstadistica = servicioGuardarEstadistica;
    }

    public DtoRespuesta<Long> ejecutar(DtoEstadistica dto) {

        Jugador jugador = Jugador.of(dto.getJugador().getNombre(),dto.getJugador().getNumeroIdentificacion(), dto.getJugador().getEquipo());

        Estadistica estadistica = Estadistica.of(dto.getRival(),dto.getFecha(),dto.getJornada(),dto.getGoles(),
                dto.getRemates(),dto.getAsistencias(),dto.getPases(),dto.getRecuperaciones(),dto.getPerdidas(),
                dto.getFaltasRecibidas(),dto.getFaltasCometidas(),jugador);

        return new DtoRespuesta<>(this.servicioGuardarEstadistica.ejecutar(estadistica));
    }

}


