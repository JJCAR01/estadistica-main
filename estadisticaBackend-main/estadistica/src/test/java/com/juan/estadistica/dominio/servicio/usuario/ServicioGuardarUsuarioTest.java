package com.juan.estadistica.dominio.servicio.usuario;

import com.juan.estadistica.dominio.modelo.Usuario;
import com.juan.estadistica.dominio.puerto.RepositorioUsuario;
import com.juan.estadistica.dominio.servicio.Usuario.ServicioGuardarUsuario;
import com.juan.estadistica.dominio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioGuardarUsuarioTest {

    @Test
    void siNombreYaExisteDeberiaRetornarError() {

        //arrange
        var usuario = new UsuarioTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioUsuario.class);
        var servicio = new ServicioGuardarUsuario(repositorio);

        Mockito.when(repositorio.existe(Mockito.any())).thenReturn(true);

        //act - assert
        Assertions.assertEquals("Ya existe el usuario con los datos ingresados",
                Assertions.assertThrows(IllegalStateException.class, () ->
                        servicio.ejecutar(usuario)
                ).getMessage());

    }

    @Test
    void guardarExitoso() {

        // arrange
        var usuario = new UsuarioTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioUsuario.class);
        var servicio = new ServicioGuardarUsuario(repositorio);


        Mockito.when(repositorio.guardar(Mockito.any(Usuario.class))).thenReturn(1l);

        // act
        var id = servicio.ejecutar(usuario);

        // assert
        Mockito.verify(repositorio, Mockito.times(1)).guardar(usuario);
        Assertions.assertEquals(1l, id);

    }
}
