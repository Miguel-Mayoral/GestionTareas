package com.test.gestionTareas.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

import static com.test.gestionTareas.utils.UtilConstantes.*;

@Entity
@Table(name = "COMENTARIO")
@Data
public class ComentarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "comentario_seq")
    @SequenceGenerator(name = "comentario_seq",sequenceName = "comentario_seq",allocationSize = 1)
    @Column(name="id_Comentario")
    private Integer idComentario;

    @ManyToOne
    @JoinColumn (name="id_Tarea")
    private TareaModel idTarea;

    @ManyToOne
    @JoinColumn(name="id_Usuario")
    private UsuarioModel idUsuario;

    @Column(name="estado")
    private Integer estado;

    @Column(name="comentario")
    private String comentario;

    @Column(name="fecha_Comentario")
    private Date fechaComentario;

    @PrePersist
    public void prePresist(){
        if(estado==null)
            estado =CODEPOS;
        if (fechaComentario==null)
            fechaComentario = new Date() ;
    }
}
