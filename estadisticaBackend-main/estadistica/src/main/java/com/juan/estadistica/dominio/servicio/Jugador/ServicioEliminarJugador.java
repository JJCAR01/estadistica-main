package com.juan.estadistica.dominio.servicio.Jugador;

import com.juan.estadistica.dominio.puerto.RepositorioJugador;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarJugador {
    private static final String MENSAJE_NO_EXISTE = "No existe el Jugador con los datos ingresados";

    private final RepositorioJugador repositorioJugador;

    public ServicioEliminarJugador(RepositorioJugador repositorioJugador) {
        this.repositorioJugador = repositorioJugador;
    }

    public Long ejecutar(Long codigo) {

        if(this.repositorioJugador.consultarPorId(codigo) == null) {
            throw new IllegalStateException(MENSAJE_NO_EXISTE);
        }
        return this.repositorioJugador.eliminar(codigo);
    }
}
