
--Se verifica que no exista la tabla antes de ser creada, si existe que la borre
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE  TAREA CASCADE CONSTRAINTS ';
EXCEPTION WHEN OTHERS THEN NULL;
end;
/
--Se elimina la sequecia por si ya fue creada anteriormente
BEGIN
    EXECUTE IMMEDIATE 'DROP SEQUENCE tarea_seq';
EXCEPTION WHEN OTHERS THEN NULL;
end;
/

--Creacion de la tabla con sus rspectivos atributos acorde al historial de usuario
CREATE TABLE TAREA(
    idTarea NUMBER PRIMARY KEY, --Llame primaria para el identificador unico
    titulo VARCHAR2(20),
    descripcion VARCHAR2(80),
    prioridad VARCHAR2(20),
    estado NUMBER DEFAULT 1,
    idProyecto NUMBER,
    idUsuarioAsignado NUMBER,
    idEstado NUMBER,
    fechaCreacion DATE DEFAULT SYSDATE,
    fechaLimite DATE,

    --Creacion de las llaves secundarias
    CONSTRAINT  fk_tarea_proyecto
    FOREIGN KEY(idProyecto)
    REFERENCES  PROYECTO(idProyecto),

    CONSTRAINT  fk_tarea_usuario
    FOREIGN KEY(idUsuarioAsignado)
    REFERENCES  USUARIO(idUsuario),

    CONSTRAINT  fk_tarea_estado
    FOREIGN KEY(idEstado)
    REFERENCES  ESTADO_TAREA(idEstado)


);
--creamos la sequencia iniciando en 1 con imcrementos de 1
CREATE SEQUENCE tarea_seq START WITH 1 INCREMENT BY 1;

--Comentamoms la respectivas tabla, con sus respectivas columnas para una mejor compresion de la tabla a futuro
COMMENT ON TABLE TAREA IS 'Tabla que registra las TAREAS';
COMMENT ON COLUMN TAREA.titulo IS 'Columna para el titulo de la TAREA ';
COMMENT ON COLUMN TAREA.descripcion IS 'Columna para el descripcion de la TAREA ';
COMMENT ON COLUMN TAREA.prioridad IS 'Columna para el prioridad de la TAREA ';
COMMENT ON COLUMN TAREA.estado IS 'Columna para el estado de la TAREA ';
COMMENT ON COLUMN TAREA.idProyecto IS 'Columna para el idProyecto de la TAREA ';
COMMENT ON COLUMN TAREA.idUsuarioAsignado IS 'Columna para el idUsuarioAsignado de la TAREA ';
COMMENT ON COLUMN TAREA.idEstado IS 'Columna para el idEstado de la TAREA ';
COMMENT ON COLUMN TAREA.fechaCreacion IS 'Columna para el fechaCreacion de la TAREA ';
COMMENT ON COLUMN TAREA.fechaLimite IS 'Columna para el fechaLimite de la TAREA ';

commit ;