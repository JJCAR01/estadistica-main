package com.juan.estadistica.infraestructura.aspectos.excepcion;

public class ExceptionUserUnauthorized extends RuntimeException{

    public static final long serialVersionUID = 1L;

    public ExceptionUserUnauthorized(String message) {
        super(message);
    }
}