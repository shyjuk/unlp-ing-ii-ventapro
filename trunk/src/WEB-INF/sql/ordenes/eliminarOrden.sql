delimiter $$

CREATE PROCEDURE `eliminarOrden`(idOrden int)
BEGIN
    DELETE FROM tbl_ordenes_venta
    WHERE idOrdenVenta = idOrden;
    
    -- Si se llega a este punto el DELETE funcionó, sino, ObjetoPersistente se va a encargar de reportar el error
    SELECT 0 AS CODIGO_ERROR
    FROM dual;
END$$