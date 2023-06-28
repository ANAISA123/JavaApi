package com.ejemplo.repository;

import com.ejemplo.models.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais,Long> {
}
