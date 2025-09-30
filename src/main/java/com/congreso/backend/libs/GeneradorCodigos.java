package com.congreso.backend.libs;

public class GeneradorCodigos {
    public static String generarCodigo(String cadd,int numeroSecuencial,int anio) {
        // Usamos String.format() para formatear el número
        // "C%04d" significa:
        // C: Prefijo literal
        // %: Indica que viene una especificación de formato
        // 0: Rellena con ceros a la izquierda (padding)
        // 4: Número total de caracteres que tendrá la parte numérica (0001 a 9999)
        // d: Indica que el argumento es un entero decimal
        String code = String.format(cadd+"%04d", numeroSecuencial);
        return code+"/"+anio;
    }
}
