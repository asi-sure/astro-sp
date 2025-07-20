package com.congreso.backend.entities.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InquilinosEDto {
    private Long id;
    private String nombre;
    private String ap;
    private String am;
}
