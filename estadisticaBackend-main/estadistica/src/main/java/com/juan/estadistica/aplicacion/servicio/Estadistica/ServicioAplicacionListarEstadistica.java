package com.juan.estadistica.aplicacion.servicio.Estadistica;

import com.juan.estadistica.dominio.modelo.Estadistica;
import com.juan.estadistica.dominio.modelo.Jugador;
import com.juan.estadistica.dominio.puerto.RepositorioEstadistica;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarEstadistica {

    private final RepositorioEstadistica repositorioEstadistica;

    public ServicioAplicacionListarEstadistica(RepositorioEstadistica repositorioEstadistica) {
        this.repositorioEstadistica = repositorioEstadistica;
    }

    public List<Estadistica> ejecutar() {
        return this.repositorioEstadistica.listar();
    }

    public Estadistica consultar(Long id) {return this.repositorioEstadistica.consultarPorId(id);}
}
