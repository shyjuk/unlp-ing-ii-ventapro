delimiter $$

CREATE PROCEDURE `eliminarMarca`(idMarca int)
BEGIN
    DELETE FROM tbl_marcas
    WHERE tbl_marcas.idMarca = idMarca;
    
    -- Si se llega a este punto el DELETE funcionó, sino, ObjetoPersistente se va a encargar de reportar el error
    SELECT 0 AS CODIGO_ERROR
    FROM dual;
END$$