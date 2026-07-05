package com.test.gestionTareas.service;

import com.test.gestionTareas.dto.UsuarioModelDTO;
import com.test.gestionTareas.models.ProyectoModel;
import com.test.gestionTareas.models.UsuarioModel;
import com.test.gestionTareas.repository.ProyectoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProyectoService {
    private final ProyectoRepository proyectoRepository;

    public ProyectoModel registrar(ProyectoModel request){
        return proyectoRepository.save(request);
    }

}
