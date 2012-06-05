delimiter $$

CREATE PROCEDURE `eliminarProducto`(idProducto int)
BEGIN
    DELETE FROM tbl_productos
    WHERE tbl_productos.idProducto = idProducto;
    
    -- Si se llega a este punto el DELETE funcionó, sino, ObjetoPersistente se va a encargar de reportar el error
    SELECT 0 AS CODIGO_ERROR
    FROM dual;
END$$