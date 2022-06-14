package com.juan.estadistica.infraestructura.controlador;

import com.juan.estadistica.aplicacion.dto.DtoJugador;
import com.juan.estadistica.aplicacion.dto.DtoRespuesta;
import com.juan.estadistica.aplicacion.servicio.Jugador.ServicioAplicacionEliminarJugador;
import com.juan.estadistica.aplicacion.servicio.Jugador.ServicioAplicacionGuardarJugador;
import com.juan.estadistica.aplicacion.servicio.Jugador.ServicioAplicacionListarJugador;
import com.juan.estadistica.aplicacion.servicio.Jugador.ServicioAplicacionModificarJugador;
import com.juan.estadistica.dominio.modelo.Jugador;
import com.juan.estadistica.infraestructura.aspectos.SecuredResource;
import org.springframework.web.bind.annotation.*;

import java.time.temporal.JulianFields;
import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
public class ControladorJugador {

    private final ServicioAplicacionListarJugador servicioListarJugador;
    private final ServicioAplicacionGuardarJugador servicioGuardarJugador;
    private final ServicioAplicacionEliminarJugador servicioEliminarJugador;
    private final ServicioAplicacionModificarJugador servicioModificarJugador;

    public ControladorJugador(ServicioAplicacionListarJugador servicioListarJugador,
                              ServicioAplicacionGuardarJugador servicioGuardarJugador,
                              ServicioAplicacionEliminarJugador servicioEliminarJugador,
                              ServicioAplicacionModificarJugador servicioModificarJugador) {
        this.servicioListarJugador = servicioListarJugador;
        this.servicioGuardarJugador = servicioGuardarJugador;
        this.servicioEliminarJugador = servicioEliminarJugador;
        this.servicioModificarJugador = servicioModificarJugador;
    }

    @GetMapping
    @SecuredResource(name = "EMPLEADO")
    public List<Jugador> listar() {
        return servicioListarJugador.ejecutar();
    }

    @GetMapping("/{codigo}")
    @SecuredResource(name = "EMPLEADO")
    public Jugador listar(@PathVariable Long codigo ) {
        return servicioListarJugador.consultar(codigo);
    }

    @PostMapping
    @SecuredResource(name = "EMPLEADO")
    public DtoRespuesta<Long> crear(@RequestBody DtoJugador dto) {
        return this.servicioGuardarJugador.ejecutar(dto);
    }

    @PutMapping("/{codigo}")
    @SecuredResource(name = "EMPLEADO")
    public DtoRespuesta<Long> modificar(@RequestBody DtoJugador jugador, @PathVariable Long codigo)
    {
        return this.servicioModificarJugador.ejecutar(jugador,codigo);
    }

    @DeleteMapping("/{codigo}")
    @SecuredResource(name = "EMPLEADO")
    public DtoRespuesta<Long> eliminar(@PathVariable Long codigo)
    {
        return this.servicioEliminarJugador.ejecutar(codigo);
    }
}
