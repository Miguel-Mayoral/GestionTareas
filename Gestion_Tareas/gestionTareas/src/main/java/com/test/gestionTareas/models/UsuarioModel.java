package com.test.gestionTareas.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

import static com.test.gestionTareas.utils.UtilConstantes.CODEPOS;

@Entity
@Table(name = "USUARIO")
@Data
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "usuario_seq")
    @SequenceGenerator(name = "usuario_seq",sequenceName = "usuario_seq",allocationSize = 1)
    @Column(name="id_Usuario")
    private Integer idUsuario;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="correo")
    private String correo;

    @Column(name="telefono")
    private String telefono;

    @Column(name="estado")
    private Integer estado;

    @Column(name="fecha_Registro")
    private Date fechaRegistro;

    @PrePersist
    public void prePresist(){
        if(estado==null)
            estado =CODEPOS;
        if (fechaRegistro==null)
            fechaRegistro = new Date() ;
    }
}
