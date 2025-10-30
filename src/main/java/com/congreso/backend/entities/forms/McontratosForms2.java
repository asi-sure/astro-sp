package com.congreso.backend.entities.forms;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class McontratosForms2 {
    private String codcon;
    private float monto;
    private String obs;
    private int codresponsable;
}
