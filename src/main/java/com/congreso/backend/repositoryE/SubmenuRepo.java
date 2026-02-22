package com.congreso.backend.repositoryE;

import com.congreso.backend.entities.PrivilegiosE;
import com.congreso.backend.entities.SubmenuE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmenuRepo extends JpaRepository<SubmenuE,Long> {
}
