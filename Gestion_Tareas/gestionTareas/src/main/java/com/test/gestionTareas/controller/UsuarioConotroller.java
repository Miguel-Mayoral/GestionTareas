package com.test.gestionTareas.controller;

import com.test.gestionTareas.dto.ApiResponse;
import com.test.gestionTareas.models.ComentarioModel;
import com.test.gestionTareas.models.UsuarioModel;
import com.test.gestionTareas.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.test.gestionTareas.utils.UtilConstantes.*;

@RestController
@RequestMapping("/api/usuarios")
@AllArgsConstructor
public class UsuarioConotroller {
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> registrar(@RequestBody UsuarioModel usuario){
        return ResponseEntity.ok(new ApiResponse<>(true,MSG2,usuarioService.registrar(usuario)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<?>> listar(){
        return ResponseEntity.ok(new ApiResponse<>(true,MSG3,usuarioService.listar()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> listarId(@PathVariable Integer id){
        return ResponseEntity.ok(new ApiResponse<>(true,MSG3,usuarioService.listarId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> actualizar(@PathVariable Integer id, @RequestBody UsuarioModel request){
        return ResponseEntity.ok(new ApiResponse<>(true,MSG5,usuarioService.actualizar(id,request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> eliminar(@PathVariable Integer id){
        return ResponseEntity.ok(new ApiResponse<>(true,MSG6,usuarioService.eliminar(id)));
    }

}
