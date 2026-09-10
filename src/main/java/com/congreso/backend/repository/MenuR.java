package com.congreso.backend.repository;

import com.congreso.backend.model.Menu;
//import com.congreso.backend.model.Persons;
//import com.congreso.backend.model.Submenu;
import com.congreso.backend.model.Submenu;
import com.congreso.backend.model.dto.*;

import java.util.List;

public interface MenuR {

    List<Menu> findAll();
    List<Menu> findAll_2(boolean xstatus);
    List<MenuDto> findByPerson(Long id_person);
    List<MenusDto> findMenuByPerson(Long id_person);
    List<SubmenuDto> findSubmenuByPerson(Long id_person);
    List<PrivilegiosDto> findPrivilegiosByPerson(Long id_person);
    List<Submenu> findAll_SubmenuSinAsignar(int id_menu);
    List<SubmenuPrivDto> findAll_SubmenuAsignados(int id_menu);
    Long saveMenu(Menu me);
    boolean update(Menu me, int id_menu);
    boolean deleteById(int id_menu);



}
