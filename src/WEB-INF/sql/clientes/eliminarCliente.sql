delimiter $$

CREATE PROCEDURE `eliminarCliente`(idPersona int)
BEGIN
    DELETE FROM tbl_personas
    WHERE tbl_personas.idPersona = idPersona;
    
    -- Si se llega a este punto el DELETE funcionó, sino, ObjetoPersistente se va a encargar de reportar el error
    SELECT 0 AS CODIGO_ERROR
    FROM dual;
END$$