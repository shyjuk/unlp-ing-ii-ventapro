delimiter $$

CREATE PROCEDURE `modificarEstadoOrden`(id int, nuevo_estado int)
BEGIN
    UPDATE tbl_ordenes_venta
    SET estado = nuevo_estado
    WHERE idOrdenVenta = id;
 
END$$