package com.test.gestionTareas.service;

import com.test.gestionTareas.models.ComentarioModel;
import com.test.gestionTareas.repository.ComentarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ComentarioService {
    private final ComentarioRepository comentarioRepository;

    public ComentarioModel registrar(ComentarioModel comentario){
        return comentarioRepository.save(comentario);
    }
}
