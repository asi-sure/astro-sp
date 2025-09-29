package com.congreso.backend.model.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrediosDto {
    private String codpre;
    private String nompredio;
    private String nomseccion;
    private String nomsector;
}
