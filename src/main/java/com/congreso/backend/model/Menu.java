package com.congreso.backend.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Menu {
    private Long id_menu;
    private String name;
    private String description;
    private String icon;
    private String type_menu;
    private Boolean status;
}