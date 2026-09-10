package com.congreso.backend.repositoryE;

import com.congreso.backend.entities.MenuE;
import com.congreso.backend.entities.MesubE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesubRepo extends JpaRepository<MesubE,Integer> {
}
