package com.juan.estadistica.infraestructura.controlador;

import com.juan.estadistica.aplicacion.dto.DtoRespuesta;
import com.juan.estadistica.aplicacion.dto.DtoUsuario;
import com.juan.estadistica.aplicacion.servicio.Usuario.ServicioAplicacionEliminarUsuario;
import com.juan.estadistica.aplicacion.servicio.Usuario.ServicioAplicacionGuardarUsuario;
import com.juan.estadistica.aplicacion.servicio.Usuario.ServicioAplicacionListarUsuario;
import com.juan.estadistica.dominio.modelo.Usuario;
import com.juan.estadistica.infraestructura.aspectos.SecuredResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class ControladorUsuario {

    private final ServicioAplicacionListarUsuario servicioListarUsuario;
    private final ServicioAplicacionGuardarUsuario servicioGuardarUsuario;
    private final ServicioAplicacionEliminarUsuario servicioEliminarUsuario;
    /*
    private final ServicioAplicacionModificarUsuario servicioModificarUsuario;

     */

    public ControladorUsuario(ServicioAplicacionListarUsuario servicioListarUsuario,
                              ServicioAplicacionGuardarUsuario servicioGuardarUsuario,
                              ServicioAplicacionEliminarUsuario servicioEliminarUsuario) {
        this.servicioListarUsuario = servicioListarUsuario;
        this.servicioGuardarUsuario = servicioGuardarUsuario;
        this.servicioEliminarUsuario = servicioEliminarUsuario;

    }

    @GetMapping("/{codigo}")
    public Usuario listar(@PathVariable Long codigo ) {
        return servicioListarUsuario.consultar(codigo);
    }

    @PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoUsuario dto) {
        return this.servicioGuardarUsuario.ejecutar(dto);
    }

    /*
    @PutMapping("/{codigo}")
    @SecuredResource(name = "EMPLEADO")
    public DtoRespuesta<Long> modificar(@RequestBody DtoUsuario usuario, @PathVariable Long codigo)
    {
        return this.servicioModificarUsuario.ejecutar(usuario,codigo);
    }

     */

    @DeleteMapping("/{codigo}")
    @SecuredResource(name = "EMPLEADO")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo)
    {
        return this.servicioEliminarUsuario.ejecutar(codigo);
    }

}
