package com.juan.estadistica.dominio.servicio.Estadistica;

import com.juan.estadistica.dominio.puerto.RepositorioEstadistica;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarEstadistica {
    private static final String MENSAJE_NO_EXISTE = "No existe la estadistica con los datos ingresados";

    private final RepositorioEstadistica repositorioEstadistica;

    public ServicioEliminarEstadistica(RepositorioEstadistica repositorioEstadistica) {
        this.repositorioEstadistica = repositorioEstadistica;
    }

    public Long ejecutar(Long codigo) {

        if(this.repositorioEstadistica.consultarPorId(codigo) == null) {
            throw new IllegalStateException(MENSAJE_NO_EXISTE);
        }
        return this.repositorioEstadistica.eliminar(codigo);
    }
}


