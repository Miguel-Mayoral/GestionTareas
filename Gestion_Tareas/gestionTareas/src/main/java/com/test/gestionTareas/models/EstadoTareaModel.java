package com.test.gestionTareas.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

import static com.test.gestionTareas.utils.UtilConstantes.CODEPOS;

@Entity
@Table(name = "ESTADO_TAREA")
@Data
public class EstadoTareaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "estadoTarea_seq")
    @SequenceGenerator(name = "estadoTarea_seq",sequenceName = "estadoTarea_seq",allocationSize = 1)
    @Column(name="id_Estado")
    private Integer idEstado;

    @Column(name="nombre")
    private String nombre;

    @Column(name="estado")
    private Integer estado;

    @PrePersist
    public void prePresist(){
        if(estado==null)
            estado =CODEPOS;
    }
}
