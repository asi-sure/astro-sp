package com.congreso.backend.libs;

public class FormatoNumeros {
    public static float getNumber(float numeroOriginal,int decimal) {
        // "% .2f" significa:
        // %: Indica que viene una especificación de formato
        // .: Indica el inicio de la sección de precisión
        // 2: Número de dígitos después del punto decimal
        // f: Indica que el argumento es un número de punto flotante
        String numeroFormateado = String.format("%."+decimal+"f", numeroOriginal);
//        System.out.println("este tiene formato:"+numeroFormateado);
        return Float.parseFloat(numeroFormateado);
    }
}
