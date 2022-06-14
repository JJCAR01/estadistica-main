package com.juan.estadistica.aplicacion.servicio.Jugador;

import com.juan.estadistica.dominio.modelo.Jugador;
import com.juan.estadistica.dominio.puerto.RepositorioJugador;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarJugador {

    private final RepositorioJugador repositorioJugador;

    public ServicioAplicacionListarJugador(RepositorioJugador repositorioJugador) {
        this.repositorioJugador = repositorioJugador;
    }

    public List<Jugador> ejecutar() {
        return this.repositorioJugador.listar();
    }

    public Jugador consultar(Long id) {return this.repositorioJugador.consultarPorId(id);}
}
