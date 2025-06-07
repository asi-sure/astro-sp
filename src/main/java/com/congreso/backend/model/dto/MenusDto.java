package com.congreso.backend.model.dto;

import com.congreso.backend.model.Submenu;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenusDto {
    private  int id_role;
    private  int id_menu;
    private  String name;
    private  String description;
    private  String type_menu;
    private  String icon;

    private List<SubmenuDto> submenu;
/*    public MenusDto(int id_role, int id_menu, String name, String icon, String description, List<SubmenuDto> hijo) {
        this.id_role = id_role;
        this.id_menu = id_menu;
        this.name = name;
        this.icon = icon;
        this.description = description;
        this.submenu = hijo;
    }*/
}
