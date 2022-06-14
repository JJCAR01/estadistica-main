package com.juan.estadistica.infraestructura.adaptador.excepcion;

public class TechnicalException extends RuntimeException{
    public TechnicalException(Exception e) {
        super(e);
    }
}
