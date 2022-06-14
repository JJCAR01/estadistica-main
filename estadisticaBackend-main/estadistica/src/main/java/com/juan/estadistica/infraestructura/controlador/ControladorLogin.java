package com.juan.estadistica.infraestructura.controlador;

import com.juan.estadistica.aplicacion.dto.DtoLogin;
import com.juan.estadistica.aplicacion.dto.DtoRespuesta;
import com.juan.estadistica.aplicacion.servicio.login.ServicioAplicacionLogin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class ControladorLogin {

    private final ServicioAplicacionLogin servicioAplicacionLogin;

    public ControladorLogin(ServicioAplicacionLogin servicioAplicacionLogin) {
        this.servicioAplicacionLogin = servicioAplicacionLogin;
    }

    @PostMapping
    public DtoRespuesta<String> login(@RequestBody DtoLogin dto) {
        return this.servicioAplicacionLogin.ejecutar(dto);
    }

}