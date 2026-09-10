package com.congreso.backend.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubmenuPrivDto {
    private Long id_mesub;
    private Long id_subm;
    private String name;
    private String description;
    private String link;
    private Boolean status;
}
