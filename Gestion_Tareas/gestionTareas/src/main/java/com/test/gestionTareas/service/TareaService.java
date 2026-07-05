package com.test.gestionTareas.service;


import com.test.gestionTareas.dto.UsuarioModelDTO;
import com.test.gestionTareas.models.EstadoTareaModel;
import com.test.gestionTareas.models.ProyectoModel;
import com.test.gestionTareas.models.TareaModel;
import com.test.gestionTareas.models.UsuarioModel;
import com.test.gestionTareas.repository.EstadoTareaRepository;
import com.test.gestionTareas.repository.ProyectoRepository;
import com.test.gestionTareas.repository.TareaRepository;
import com.test.gestionTareas.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.test.gestionTareas.utils.UtilConstantes.*;

@Service
@RequiredArgsConstructor
public class TareaService {
    private final TareaRepository tareaRepository;
    private final ProyectoRepository proyectoRepository;
    private final UsuarioRepository usuarioRepository;
    private final EstadoTareaRepository estadoTareaRepository;

    public TareaModel registrar(TareaModel request){
        ProyectoModel proyecto =     proyectoRepository.findById(request.getIdProyecto().getIdProyecto()).orElseThrow(()-> new RuntimeException(MSG9));
        UsuarioModel usuario =        usuarioRepository.findById(request.getIdUsuarioAsignado().getIdUsuario()).orElseThrow(()-> new RuntimeException(MSG4));
        EstadoTareaModel estado = estadoTareaRepository.findById(request.getIdEstado().getIdEstado()).orElseThrow(()-> new RuntimeException(MSG10));

        TareaModel tarea = new TareaModel();
        tarea.setDescripcion(request.getDescripcion());
        tarea.setIdProyecto (proyecto);
        tarea.setIdUsuarioAsignado(usuario);
        tarea.setFechaLimite(request.getFechaLimite());
        tarea.setPrioridad(request.getPrioridad());
        tarea.setTitulo(request.getTitulo());
        tarea.setIdEstado(estado);

        return tareaRepository.save(tarea);
    }
}
