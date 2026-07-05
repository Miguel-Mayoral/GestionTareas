package com.test.gestionTareas.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

import static com.test.gestionTareas.utils.UtilConstantes.CODEPOS;

@Entity
@Table(name = "PROYECTO")
@Data
public class ProyectoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "proyecto_seq")
    @SequenceGenerator(name = "proyecto_seq",sequenceName = "proyecto_seq",allocationSize = 1)
    @Column(name="id_Proyecto")
    private Integer idProyecto;

    @Column(name="nombre")
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="estado")
    private Integer estado;

    @Column(name="fecha_Inicio")
    private Date fechaInicio;

    @Column(name="fecha_Fin")
    private Date fechaFin;

    @PrePersist
    public void prePresist(){
        if(estado==null)
            estado =CODEPOS;
        if (fechaInicio==null)
            fechaInicio = new Date() ;
    }
}
