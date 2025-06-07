package com.congreso.backend.enumeration;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
public enum RolSecurityEnum {
    ADMINISTRADOR("ADMINISTRADOR"),
    INVITED("INVITED");

    private String valor;

    private RolSecurityEnum(String valor) {
        this.valor = valor;
    }

    public static Optional<RolSecurityEnum> fromText(String text) {
        return Arrays.stream(values())
                .filter(vl -> vl.valor.equalsIgnoreCase(text))
                .findFirst();
    }
}
