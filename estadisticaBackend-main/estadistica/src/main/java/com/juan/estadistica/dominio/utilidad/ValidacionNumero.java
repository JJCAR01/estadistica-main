package com.juan.estadistica.dominio.utilidad;

public class ValidacionNumero {

    public static void numeroMayorACero(int numero,String mensaje)
    {
        if(numero <= 0)
            throw new IllegalArgumentException(mensaje);
    }

}
