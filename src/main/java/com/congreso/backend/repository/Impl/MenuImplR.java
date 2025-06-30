package com.congreso.backend.repository.Impl;

import com.congreso.backend.model.Departament;
import com.congreso.backend.model.Menu;
import com.congreso.backend.model.Submenu;
import com.congreso.backend.model.dto.MenuDto;
import com.congreso.backend.model.dto.MenusDto;
import com.congreso.backend.model.dto.SubmenuDto;
import com.congreso.backend.repository.MenuR;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MenuImplR implements MenuR {
    public final JdbcTemplate db;
    private String sql;
    @Override
    public List<Menu> findAll() {
        sql = "SELECT * FROM menu WHERE status = true;";
        return db.query(sql, new BeanPropertyRowMapper<Menu>(Menu.class));
    }
    public List<Menu> findAll_2(boolean xstatus) {
        sql = "SELECT * FROM menu WHERE status = ?;";
        return db.query(sql, new BeanPropertyRowMapper<Menu>(Menu.class),xstatus);
    }
    @Override
    public List<MenuDto> findByPerson(Long id_person) {
        sql =   " select r.id_role,me.id_menu,me.description, me.name, su.name as name_subm, su.description as description_subm, su.link as link_subm "
               +" from rolper r, rolme m, mesub s, menu me, submenu su "
               +" where  (r.id_person= ? )and "
               +"        (r.id_role=m.id_role)and "
               +"        (m.id_menu=s.id_menu)and "
               +"        (s.id_subm=su.id_subm)and "
               +"        (m.id_menu=me.id_menu) "
               +" order by r.id_role,me.id_menu, me.name; ";
        return db.query(sql, new BeanPropertyRowMapper<MenuDto>(MenuDto.class),id_person);
    }
    @Override
    public List<MenusDto> findMenuByPerson(Long id_person) {
        sql =    " select r.id_role,me.id_menu,me.description,me.type_menu, me.name, me.icon "
                +" from rolper r, rolme m,menu me "
                +" where  (r.id_person= ? )and "
                +" (r.id_role=m.id_role)and "
                +" (m.id_menu=me.id_menu) "
                +" order by r.id_role,me.id_menu, me.name; ";
        return db.query(sql, new BeanPropertyRowMapper<MenusDto>(MenusDto.class),id_person);
    }
    @Override
    public List<SubmenuDto> findSubmenuByPerson(Long id_person) {
        sql =    " select s.id_menu,su.id_subm,su.name, su.description,su.link "
                +" from rolper r, rolme m, mesub s, submenu su "
                +" where  (r.id_person= ? )and "
                +"        (r.id_role=m.id_role)and "
                +"        (m.id_menu=s.id_menu)and "
                +"        (s.id_subm=su.id_subm) "
                +" order by s.id_menu,su.id_subm, su.name; ";
        return db.query(sql, new BeanPropertyRowMapper<SubmenuDto>(SubmenuDto.class),id_person);
    }

    @Override
    public Long saveMenu(Menu me) {
        String sql = "  INSERT INTO menu(description,name,status,icon, type_menu) "
                + "   values (?,?,?,?,?) RETURNING id_menu;";
        return db.queryForObject(sql, new Object[]{me.getDescription(),me.getName(),true,me.getIcon(),me.getType_menu()}, Long.class);
    }
}
