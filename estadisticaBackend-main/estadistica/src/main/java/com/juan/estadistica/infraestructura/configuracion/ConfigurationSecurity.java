package com.juan.estadistica.infraestructura.configuracion;

import com.juan.estadistica.infraestructura.filtro.FiltroAutenticacion;
import com.juan.estadistica.infraestructura.servicio.ServicioValidacionToken;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationSecurity {
    private static final String URL_PATTERN = "/*";

    @Bean
    public FilterRegistrationBean<FiltroAutenticacion> authenticationFilter(ServicioValidacionToken tokenValidationService){
        FilterRegistrationBean<FiltroAutenticacion> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new FiltroAutenticacion(tokenValidationService, new String[]{"/api/login","/api/usuarios","/api/equipos"
                ,"/api/jugadores","/api/estadisticas"}));
        registrationBean.addUrlPatterns(URL_PATTERN);

        return registrationBean;
    }
}