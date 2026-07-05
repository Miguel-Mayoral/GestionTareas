package com.test.gestionTareas.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

import static com.test.gestionTareas.utils.UtilConstantes.CODEPOS;

@Entity
@Table(name = "TAREA")
@Data
public class TareaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tarea_seq")
    @SequenceGenerator(name = "tarea_seq",sequenceName = "tarea_seq",allocationSize = 1)
    @Column(name="id_Tarea")
    private Integer idTarea;

    @ManyToOne
    @JoinColumn(name="id_Proyecto")
    private ProyectoModel idProyecto;

    @ManyToOne
    @JoinColumn(name="id_Usuario")
    private UsuarioModel idUsuarioAsignado;

    @ManyToOne
    @JoinColumn(name="id_Estado")
    private EstadoTareaModel idEstado;

    @Column(name="titulo")
    private String titulo;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="prioridad")
    private String prioridad;

    @Column(name="estado")
    private Integer estado;

    @Column(name="fecha_Creacion")
    private Date fechaCreacion;

    @Column(name="fecha_Limite")
    private Date fechaLimite;

    @PrePersist
    public void prePresist(){
        if(estado==null)
            estado =CODEPOS;
        if (fechaCreacion==null)
            fechaCreacion = new Date() ;
    }
}
