package com.congreso.backend.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrivilegiosDto {
    private int id_subm;
    private int id_priv;
    private String alias;
    private String description;
}
