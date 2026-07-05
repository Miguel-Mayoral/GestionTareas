package com.test.gestionTareas.repository;

import com.test.gestionTareas.controller.ProyectoController;
import com.test.gestionTareas.models.ComentarioModel;
import com.test.gestionTareas.models.ProyectoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoRepository extends JpaRepository<ProyectoModel,Integer> {
}
