package com.juan.estadistica.dominio.servicio.usuario;

import com.juan.estadistica.dominio.puerto.RepositorioUsuario;
import com.juan.estadistica.dominio.servicio.Usuario.ServicioModificarUsuario;
import com.juan.estadistica.dominio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioModificarUsuarioTest {

    @Test
    void verificarNoExistaProducto()
    {
        var usuario = new UsuarioTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioUsuario.class);
        var servicio = new ServicioModificarUsuario(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe el Usuario con los datos ingresados", Assertions.assertThrows(IllegalStateException.class, () -> servicio.ejecutar(usuario,1L)).getMessage());
    }
}
