--Se verifica que no exista la tabla antes de ser creada, si existe que la borre
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE ESTADO_TAREA CASCADE CONSTRAINTS ';
EXCEPTION
    WHEN OTHERS THEN NULL;
end;
/
--Se elimina la sequecia por si ya fue creada anteriormente
BEGIN
    EXECUTE IMMEDIATE 'DROP SEQUENCE estadoTarea_seq';
EXCEPTION
    WHEN OTHERS THEN NULL;
end;
/

--Creacion de la tabla con sus rspectivos atributos acorde al historial de usuario
CREATE TABLE ESTADO_TAREA
(
    idEstado NUMBER PRIMARY KEY, --Llame primaria para el identificador unico
    nombre   VARCHAR2(20),

    estado   NUMBER DEFAULT 1
);
--creamos la sequencia iniciando en 1 con imcrementos de 1
CREATE SEQUENCE estadoTarea_seq START WITH 1 INCREMENT BY 1;

--Comentamoms la respectivas tabla, con sus respectivas columnas para una mejor compresion de la tabla a futuro
COMMENT ON TABLE ESTADO_TAREA IS 'Tabla que registra los ESTADO_TAREA';
COMMENT ON COLUMN ESTADO_TAREA.nombre IS 'Columna para el nombre del ESTADO_TAREA ';
COMMENT ON COLUMN ESTADO_TAREA.estado IS 'Columna para el estado del ESTADO_TAREA ';
commit;