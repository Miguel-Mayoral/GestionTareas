
--Se verifica que no exista la tabla antes de ser creada, si existe que la borre
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE  COMENTARIO CASCADE CONSTRAINTS ';
EXCEPTION WHEN OTHERS THEN NULL;
end;
/
--Se elimina la sequecia por si ya fue creada anteriormente
BEGIN
    EXECUTE IMMEDIATE 'DROP SEQUENCE comentario_seq';
EXCEPTION WHEN OTHERS THEN NULL;
end;
/

--Creacion de la tabla con sus rspectivos atributos acorde al historial de usuario
CREATE TABLE COMENTARIO(
    idComentario NUMBER PRIMARY KEY, --Llame primaria para el identificador unico
    idTarea NUMBER,
    idUsuario NUMBER,
    comentario VARCHAR2(80),
    estado NUMBER DEFAULT 1,
    fechaComentario DATE DEFAULT SYSDATE,

    CONSTRAINT fk_comentario_tarea
    FOREIGN KEY (idTarea)
    REFERENCES TAREA(idTarea),

    CONSTRAINT fk_usiario_tarea
    FOREIGN KEY (idUsuario)
    REFERENCES USUARIO(idUsuario)
);
--creamos la sequencia iniciando en 1 con imcrementos de 1
CREATE SEQUENCE comentario_seq START WITH 1 INCREMENT BY 1;

--Comentamoms la respectivas tabla, con sus respectivas columnas para una mejor compresion de la tabla a futuro
COMMENT ON TABLE COMENTARIO IS 'Tabla que registra los COMENTARIOS';
COMMENT ON COLUMN COMENTARIO.idComentario IS 'Columna para la idComentario de COMENTARIO ';
COMMENT ON COLUMN COMENTARIO.idUsuario IS 'Columna para la idUsuario de COMENTARIO ';
COMMENT ON COLUMN COMENTARIO.comentario IS 'Columna para la comentario de COMENTARIO ';
COMMENT ON COLUMN COMENTARIO.estado IS 'Columna para la estado de COMENTARIO ';
COMMENT ON COLUMN COMENTARIO.fechaComentario IS 'Columna para la fechaComentario de COMENTARIO ';

commit ;