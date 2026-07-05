package com.test.gestionTareas.controller;

import com.test.gestionTareas.dto.ApiResponse;
import com.test.gestionTareas.models.ProyectoModel;
import com.test.gestionTareas.models.UsuarioModel;
import com.test.gestionTareas.service.ProyectoService;
import com.test.gestionTareas.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.test.gestionTareas.utils.UtilConstantes.*;


@RestController
@RequestMapping("/api/proyectos")
@AllArgsConstructor
public class ProyectoController {
    private final ProyectoService proyectoService;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> registrar(@RequestBody ProyectoModel request){
        return ResponseEntity.ok(new ApiResponse<>(true,MSG7,proyectoService.registrar(request)));
    }
}
