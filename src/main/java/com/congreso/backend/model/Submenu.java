package com.congreso.backend.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Submenu {
    private Long id_subm;
    private String name;
    private String description;
    private String link;
    private Boolean status;
}
