package com.juan.estadistica.dominio.servicio.jugador;

import com.juan.estadistica.dominio.modelo.Jugador;
import com.juan.estadistica.dominio.modelo.Usuario;
import com.juan.estadistica.dominio.puerto.RepositorioJugador;
import com.juan.estadistica.dominio.puerto.RepositorioUsuario;
import com.juan.estadistica.dominio.servicio.Jugador.ServicioGuardarJugador;
import com.juan.estadistica.dominio.servicio.Usuario.ServicioGuardarUsuario;
import com.juan.estadistica.dominio.testdatabuilder.JugadorTestDataBuilder;
import com.juan.estadistica.dominio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioGuardarJugadorTest {
    @Test
    void siNombreYaExisteDeberiaRetornarError() {

        //arrange
        var jugador = new JugadorTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioJugador.class);
        var servicio = new ServicioGuardarJugador(repositorio);

        Mockito.when(repositorio.existe(Mockito.any())).thenReturn(true);

        //act - assert
        Assertions.assertEquals("Ya existe el jugador con los datos ingresados",
                Assertions.assertThrows(IllegalStateException.class, () ->
                        servicio.ejecutar(jugador)
                ).getMessage());

    }

    @Test
    void guardarExitoso() {

        // arrange
        var jugador = new JugadorTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioJugador.class);
        var servicio = new ServicioGuardarJugador(repositorio);


        Mockito.when(repositorio.guardar(Mockito.any(Jugador.class))).thenReturn(1l);

        // act
        var id = servicio.ejecutar(jugador);

        // assert
        Mockito.verify(repositorio, Mockito.times(1)).guardar(jugador);
        Assertions.assertEquals(1l, id);

    }
}
