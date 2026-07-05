package com.test.gestionTareas.repository;

import com.test.gestionTareas.models.ComentarioModel;
import com.test.gestionTareas.models.EstadoTareaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoTareaRepository  extends JpaRepository<EstadoTareaModel,Integer> {
}
