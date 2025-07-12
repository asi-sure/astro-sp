package com.congreso.backend.repository;

import com.congreso.backend.model.Person;
import com.congreso.backend.model.Persons;
import com.congreso.backend.model.SystemUsers;
import com.congreso.backend.model.dto.SystemUsersDto;

public interface SystemUsersR {
    Long save(SystemUsersDto user);
    boolean verificarUserName(String xusername);
}
