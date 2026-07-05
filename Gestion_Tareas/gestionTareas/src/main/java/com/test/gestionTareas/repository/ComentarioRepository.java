package com.test.gestionTareas.repository;

import com.test.gestionTareas.models.ComentarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<ComentarioModel,Integer> {

}
