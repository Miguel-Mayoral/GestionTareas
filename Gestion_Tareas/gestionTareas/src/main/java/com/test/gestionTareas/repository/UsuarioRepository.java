package com.test.gestionTareas.repository;

import com.test.gestionTareas.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<UsuarioModel,Integer> {
    List<UsuarioModel> findByEstado(Integer estado);
}
