delimiter $$

CREATE PROCEDURE `eliminarTipoProducto`(idTipoProducto int)
BEGIN
    DELETE FROM tbl_tipos_producto
    WHERE tbl_tipos_producto.idTipoProducto = idTipoProducto;
    
    -- Si se llega a este punto el DELETE funcionó, sino, ObjetoPersistente se va a encargar de reportar el error
    SELECT 0 AS CODIGO_ERROR
    FROM dual;
END$$