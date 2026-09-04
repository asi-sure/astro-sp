package com.congreso.backend.repositoryE;

import com.congreso.backend.entities.MenuE;
import com.congreso.backend.entities.RubrosE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepo extends JpaRepository<MenuE,Integer> {
}
