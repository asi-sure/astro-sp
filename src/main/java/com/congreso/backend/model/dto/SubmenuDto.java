package com.congreso.backend.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubmenuDto {
    private int id_menu;
    private int id_subm;
    private String name;
    private String description;
    private String link;

/*    public SubmenuDto(int id_menu,int id_subm, String name, String description, String link) {
        this.id_menu = id_menu;
        this.id_subm = id_subm;
        this.name = name;
        this.description = description;
        this.link = link;
    }*/
}
