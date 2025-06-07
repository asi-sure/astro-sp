package com.congreso.backend.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuDto {
    private  int id_role;
    private  int id_menu;
    private  String name;
    private  String description;
    private  String name_subm;
    private  String description_subm;
    private  String link_subm;
}