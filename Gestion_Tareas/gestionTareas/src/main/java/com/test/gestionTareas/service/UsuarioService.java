package com.test.gestionTareas.service;

import com.test.gestionTareas.dto.UsuarioModelDTO;
import com.test.gestionTareas.models.ComentarioModel;
import com.test.gestionTareas.models.UsuarioModel;
import com.test.gestionTareas.repository.ComentarioRepository;
import com.test.gestionTareas.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.test.gestionTareas.utils.UtilConstantes.*;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioModelDTO registrar(UsuarioModel usuario){
        usuarioRepository.save(usuario);
        return new UsuarioModelDTO(usuario.getIdUsuario(),usuario.getNombre());
    }

    public List<UsuarioModel> listar(){
        return usuarioRepository.findByEstado(CODEPOS);
    }

    public UsuarioModel listarId(Integer id){
        return usuarioRepository.findById(id).orElseThrow(()->new RuntimeException(MSG4));
    }

    public UsuarioModel actualizar(Integer id, UsuarioModel request ){
        UsuarioModel usuario = listarId(id);
        usuario.setNombre(request.getNombre());
        usuario.setApellido(request.getApellido());
        usuario.setCorreo(request.getCorreo());
        usuario.setTelefono(request.getTelefono());
        return usuarioRepository.save(usuario);
    }

    public UsuarioModel eliminar(Integer id){
        UsuarioModel usuario = listarId(id);
        usuario.setEstado(CODENEG);
        return usuarioRepository.save(usuario);
    }
}
