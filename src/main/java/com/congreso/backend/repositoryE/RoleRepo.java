package com.congreso.backend.repositoryE;

import com.congreso.backend.entities.RoleE;
import com.congreso.backend.entities.RubrosE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<RoleE,Integer> {
}
