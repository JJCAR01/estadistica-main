package com.juan.estadistica.dominio.servicio.Estadistica;

import com.juan.estadistica.dominio.modelo.Estadistica;
import com.juan.estadistica.dominio.modelo.Usuario;
import com.juan.estadistica.dominio.puerto.RepositorioEstadistica;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarEstadistica {

    private static final String MENSAJE_YA_EXISTE = "Ya existe la estadistica con los datos ingresados";

    private final RepositorioEstadistica repositorioEstadistica;

    public ServicioGuardarEstadistica(RepositorioEstadistica repositorioEstadistica) {
        this.repositorioEstadistica = repositorioEstadistica;
    }

    public Long ejecutar(Estadistica estadistica) {

        if(this.repositorioEstadistica.existe(estadistica)) {
            throw new IllegalStateException(MENSAJE_YA_EXISTE);
        }
        return this.repositorioEstadistica.guardar(estadistica);
    }
}


