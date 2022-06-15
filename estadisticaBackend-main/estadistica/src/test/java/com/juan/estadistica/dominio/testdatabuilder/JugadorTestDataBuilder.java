    package com.juan.estadistica.dominio.testdatabuilder;

    import com.juan.estadistica.dominio.modelo.Jugador;

    public class JugadorTestDataBuilder {

    private String nombre;
    private String numeroIdentificacion;
    private String equipo ;

    public JugadorTestDataBuilder() {
        this.nombre = "juan";
        this.numeroIdentificacion = "a32453455";
        this.equipo = "Nal";

    }

    public JugadorTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public JugadorTestDataBuilder conNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
        return this;
    }

    public JugadorTestDataBuilder conEquipo(String equipo) {
        this.equipo = equipo;
        return this;
    }

    public Jugador build() {
        return Jugador.of(nombre, numeroIdentificacion, equipo);
    }
}
