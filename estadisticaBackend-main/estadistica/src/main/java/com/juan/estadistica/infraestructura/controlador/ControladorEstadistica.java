package com.juan.estadistica.infraestructura.controlador;

import com.juan.estadistica.aplicacion.dto.DtoEstadistica;
import com.juan.estadistica.aplicacion.dto.DtoJugador;
import com.juan.estadistica.aplicacion.dto.DtoRespuesta;
import com.juan.estadistica.aplicacion.servicio.Estadistica.ServicioAplicacionEliminarEstadistica;
import com.juan.estadistica.aplicacion.servicio.Estadistica.ServicioAplicacionGuardarEstadistica;
import com.juan.estadistica.aplicacion.servicio.Estadistica.ServicioAplicacionListarEstadistica;
import com.juan.estadistica.aplicacion.servicio.Estadistica.ServicioAplicacionModificarEstadistica;
import com.juan.estadistica.dominio.modelo.Estadistica;
import com.juan.estadistica.dominio.modelo.Jugador;
import com.juan.estadistica.infraestructura.aspectos.SecuredResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estadisticas")
public class ControladorEstadistica {
    private final ServicioAplicacionListarEstadistica servicioListarEstadistica;
    private final ServicioAplicacionGuardarEstadistica servicioGuardarEstadistica;
    private final ServicioAplicacionEliminarEstadistica servicioEliminarEstadistica;
    private final ServicioAplicacionModificarEstadistica servicioModificarEstadistica;

    public ControladorEstadistica(ServicioAplicacionListarEstadistica servicioListarEstadistica, ServicioAplicacionGuardarEstadistica servicioGuardarEstadistica,
                                  ServicioAplicacionEliminarEstadistica servicioEliminarEstadistica, ServicioAplicacionModificarEstadistica servicioModificarEstadistica) {
        this.servicioListarEstadistica = servicioListarEstadistica;
        this.servicioGuardarEstadistica = servicioGuardarEstadistica;
        this.servicioEliminarEstadistica = servicioEliminarEstadistica;
        this.servicioModificarEstadistica = servicioModificarEstadistica;
    }


    @GetMapping
    @SecuredResource(name = "EMPLEADO")
    public List<Estadistica> listar() {
        return servicioListarEstadistica.ejecutar();
    }

    @GetMapping("/{codigo}")
    @SecuredResource(name = "EMPLEADO")
    public Estadistica listar(@PathVariable Long codigo ) {
        return servicioListarEstadistica.consultar(codigo);
    }

    @PostMapping
    @SecuredResource(name = "EMPLEADO")
    public DtoRespuesta<Long> crear(@RequestBody DtoEstadistica dto) {
        return this.servicioGuardarEstadistica.ejecutar(dto);
    }

    @PutMapping("/{codigo}")
    @SecuredResource(name = "EMPLEADO")
    public DtoRespuesta<Long> modificar(@RequestBody DtoEstadistica estadistica, @PathVariable Long codigo)
    {
        return this.servicioModificarEstadistica.ejecutar(estadistica,codigo);
    }

    @DeleteMapping("/{codigo}")
    @SecuredResource(name = "EMPLEADO")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo)
    {
        return this.servicioEliminarEstadistica.ejecutar(codigo);
    }
}
