package com.test.gestionTareas.controller;

import com.test.gestionTareas.dto.ApiResponse;
import com.test.gestionTareas.models.ComentarioModel;
import com.test.gestionTareas.service.ComentarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.test.gestionTareas.utils.UtilConstantes.MSG1;

@RestController
@RequestMapping("/api/comentarios")
@AllArgsConstructor
public class ComentarioController {
    private final ComentarioService comentarioService;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> registrar(@RequestBody ComentarioModel comentario){
        return ResponseEntity.ok(new ApiResponse<>(true,MSG1,comentarioService.registrar(comentario)));
    }
}
