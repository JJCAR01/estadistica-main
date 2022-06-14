package com.juan.estadistica.aplicacion.servicio.Estadistica;
import com.juan.estadistica.aplicacion.dto.DtoRespuesta;
import com.juan.estadistica.dominio.servicio.Estadistica.ServicioEliminarEstadistica;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarEstadistica {

    private final ServicioEliminarEstadistica servicioEliminarEstadistica;

    public ServicioAplicacionEliminarEstadistica(ServicioEliminarEstadistica servicioEliminarEstadistica) {
        this.servicioEliminarEstadistica = servicioEliminarEstadistica;
    }

    public DtoRespuesta<Long> ejecutar(long codigo) {

        return new DtoRespuesta<>(this.servicioEliminarEstadistica.ejecutar(codigo));
    }
}


