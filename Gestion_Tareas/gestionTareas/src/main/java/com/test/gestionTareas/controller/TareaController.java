package com.test.gestionTareas.controller;

import com.test.gestionTareas.dto.ApiResponse;
import com.test.gestionTareas.models.TareaModel;
import com.test.gestionTareas.models.UsuarioModel;
import com.test.gestionTareas.service.TareaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.test.gestionTareas.utils.UtilConstantes.*;


@RestController
@RequestMapping("/api/tareas")
@AllArgsConstructor
public class TareaController {
    private final TareaService tareaService;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> registrar(@RequestBody TareaModel request){
        return ResponseEntity.ok(new ApiResponse<>(true,MSG8,tareaService.registrar(request)));
    }
}
