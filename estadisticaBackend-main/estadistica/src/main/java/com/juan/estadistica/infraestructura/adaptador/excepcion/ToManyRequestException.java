package com.juan.estadistica.infraestructura.adaptador.excepcion;

public class ToManyRequestException extends RuntimeException {

    public ToManyRequestException(Exception e) {
        super(e);
    }
}
