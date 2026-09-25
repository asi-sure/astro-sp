package com.congreso.backend.repositoryE;

import com.congreso.backend.entities.GeneralE;
import com.congreso.backend.entities.MesesE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesesRepo extends JpaRepository<MesesE,Integer> {
}
