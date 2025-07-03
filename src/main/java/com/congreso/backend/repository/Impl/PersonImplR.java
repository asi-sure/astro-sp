package com.congreso.backend.repository.Impl;

import com.congreso.backend.model.Person;
import com.congreso.backend.model.Persons;
import com.congreso.backend.repository.PersonR;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@RequiredArgsConstructor
@Repository
public class PersonImplR implements PersonR {
    private final JdbcTemplate db;
    private String sqlString;

    @Override
    public List<Person> findAll() {
        sqlString = "SELECT * FROM person WHERE status = true;";
        return db.query(sqlString, BeanPropertyRowMapper.newInstance(Person.class));
    }

    @Override
    public Person getById(Long id) {
        sqlString = "SELECT * FROM person WHERE id = ?;";
        return (Person) db.queryForObject(sqlString, BeanPropertyRowMapper.newInstance(Person.class),id);
    }

    @Override
    public Persons getById2(String username) {
        sqlString =  " SELECT p.* "
                    +" FROM persons p, system_users s "
                    +" WHERE (p.id=s.id_person)and(s.username= ? ) ";
        return (Persons) db.queryForObject(sqlString, BeanPropertyRowMapper.newInstance(Persons.class),username);
    }
    @Override
    public Long save(Person person) {
        String sqlString = "INSERT INTO person (ci, first_lastename, gender, name, second_lastname) values (?, ?, ?, ?, ?) RETURNING id;";
        return db.queryForObject(sqlString, new Object[]{person.getCi(), person.getFirstName(), person.getGender(), person.getName(), person.getSecondName()}, Long.class);
    }

    @Override
    public boolean update(Person person, Long id) {
        sqlString = "UPDATE person SET ci = ?, first_lastename = ?, gender = ?, name = ?, second_lastname = ?, id_system_user = ?, id_student = ? WHERE id = ?;";
        return db.update(sqlString, person.getCi(), person.getFirstName(), person.getGender(), person.getName(), person.getSecondName(), id) > 0;
    }

    @Override
    public boolean deleteById(Long id) {
        sqlString = "UPDATE person SET status = false WHERE id = ?;";
        return db.update(sqlString) > 0;
    }


    /*
    @Override
    public Person getById(Long id) {
        sqlString = "SELECT * FROM person WHERE id = ?;";
    try {
        return db.queryForObject(sqlString, BeanPropertyRowMapper.newInstance(Person.class), id);
    } catch (EmptyResultDataAccessException e) {
        // Manejar el caso en que no se encuentra ninguna persona con ese ID
        return null; // O lanzar una excepción personalizada
    }

    @Override
    public Departament findById(Integer id) {
        sql = "SELECT * FROM departament WHERE id = ?;";
        return (Departament) db.query(sql, new BeanPropertyRowMapper<>(Departament.class), id);
    }
    @Override
        public List<Permission> findPermissionListByRol(Long roleId) {
            sql = "SELECT p.* FROM permission p INNER JOIN rol_permission rp ON rp.permission_id =p.id  AND rp.rol_id  = ? WHERE p.status = true;";
            return db.query(sql, BeanPropertyRowMapper.newInstance(Permission.class), roleId);
        }
     */
}
