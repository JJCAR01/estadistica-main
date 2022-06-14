package com.juan.estadistica.dominio.puerto;

import com.juan.estadistica.dominio.modelo.Estadistica;

import java.util.List;

public interface RepositorioEstadistica {

    List<Estadistica> listar();
    Estadistica consultarPorId(Long id);
    Long guardar(Estadistica estadistica);
    boolean existe(Estadistica estadistica);
    Long eliminar(Long id);
    Long modificar(Estadistica estadistica, Long id);
}
