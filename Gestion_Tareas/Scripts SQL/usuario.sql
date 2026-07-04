
--Se verifica que no exista la tabla antes de ser creada, si existe que la borre
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE  USUARIO CASCADE CONSTRAINTS ';
EXCEPTION WHEN OTHERS THEN NULL;
end;
/
--Se elimina la sequecia por si ya fue creada anteriormente
BEGIN
    EXECUTE IMMEDIATE 'DROP SEQUENCE usuario_seq';
EXCEPTION WHEN OTHERS THEN NULL;
end;
/

--Creacion de la tabla con sus rspectivos atributos acorde al historial de usuario
CREATE TABLE USUARIO(
    idUsuario NUMBER PRIMARY KEY, --Llame primaria para el identificador unico
    nombre VARCHAR2(20),
    apellido VARCHAR2(20),
    correo VARCHAR2(30),
    telefono VARCHAR2(20),
    estado NUMBER DEFAULT 1,
    fechaRegistro DATE DEFAULT SYSDATE
);
--creamos la sequencia iniciando en 1 con imcrementos de 1
CREATE SEQUENCE usuario_seq START WITH 1 INCREMENT BY 1;

--Comentamoms la respectivas tabla, con sus respectivas columnas para una mejor compresion de la tabla a futuro
COMMENT ON TABLE USUARIO IS 'Tabla que registra los clientes';
COMMENT ON COLUMN USUARIO.idUsuario IS 'Columna para el ID del respectivo usuario (Clave primaria)';
COMMENT ON COLUMN USUARIO.nombre IS 'Columna para el nombre del usuario ';
COMMENT ON COLUMN USUARIO.apellido IS 'Columna para el apellido del usuario ';
COMMENT ON COLUMN USUARIO.correo IS 'Columna para el correo del usuario ';
COMMENT ON COLUMN USUARIO.telefono IS 'Columna para el telefono del usuario ';
COMMENT ON COLUMN USUARIO.estado IS 'Columna para el estado del usuario ';
COMMENT ON COLUMN USUARIO.fechaRegistro IS 'Columna para la fechaRegistro del usuario ';
commit ;