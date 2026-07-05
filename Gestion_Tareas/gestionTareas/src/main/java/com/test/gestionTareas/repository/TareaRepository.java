package com.test.gestionTareas.repository;

import com.test.gestionTareas.models.ComentarioModel;
import com.test.gestionTareas.models.TareaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<TareaModel,Integer> {
}
