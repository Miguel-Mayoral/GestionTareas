
--Se verifica que no exista la tabla antes de ser creada, si existe que la borre
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE  PROYECTO CASCADE CONSTRAINTS ';
EXCEPTION WHEN OTHERS THEN NULL;
end;
/
--Se elimina la sequecia por si ya fue creada anteriormente
BEGIN
    EXECUTE IMMEDIATE 'DROP SEQUENCE proyecto_seq';
EXCEPTION WHEN OTHERS THEN NULL;
end;
/

--Creacion de la tabla con sus rspectivos atributos acorde al historial de usuario
CREATE TABLE PROYECTO(
    idProyecto NUMBER PRIMARY KEY, --Llame primaria para el identificador unico
    nombre VARCHAR2(20),
    descripcion VARCHAR2(20),
    estado NUMBER DEFAULT 1,
    fechaInicio DATE DEFAULT SYSDATE,
    fechaFin DATE
);
--creamos la sequencia iniciando en 1 con imcrementos de 1
CREATE SEQUENCE proyecto_seq START WITH 1 INCREMENT BY 1;

--Comentamoms la respectivas tabla, con sus respectivas columnas para una mejor compresion de la tabla a futuro
COMMENT ON TABLE PROYECTO IS 'Tabla que registra los PROYECTOS';
COMMENT ON COLUMN PROYECTO.nombre IS 'Columna para el nombre del PROYECTO ';
COMMENT ON COLUMN PROYECTO.descripcion IS 'Columna para la descripcion del PROYECTO ';
COMMENT ON COLUMN PROYECTO.estado IS 'Columna para el estado del PROYECTO ';
COMMENT ON COLUMN PROYECTO.fechaInicio IS 'Columna para la fechaInicio del PROYECTO ';
COMMENT ON COLUMN PROYECTO.fechaFin IS 'Columna para la fechaFin del PROYECTO ';

commit ;