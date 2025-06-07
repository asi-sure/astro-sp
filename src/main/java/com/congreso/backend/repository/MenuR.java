package com.congreso.backend.repository;

import com.congreso.backend.model.Menu;
import com.congreso.backend.model.Submenu;
import com.congreso.backend.model.dto.MenuDto;
import com.congreso.backend.model.dto.MenusDto;
import com.congreso.backend.model.dto.SubmenuDto;

import java.util.List;

public interface MenuR {

    List<Menu> findAll();

    List<MenuDto> findByPerson(Long id_person);
    List<MenusDto> findMenuByPerson(Long id_person);
    List<SubmenuDto> findSubmenuByPerson(Long id_person);



}
