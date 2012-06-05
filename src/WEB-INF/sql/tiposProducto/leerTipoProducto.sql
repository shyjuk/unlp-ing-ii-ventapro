delimiter $$

CREATE PROCEDURE `leerTipoProducto`(idTipoProducto int)
BEGIN
    SELECT *
    FROM tbl_tipos_producto
    WHERE tbl_tipos_producto.idTipoProducto = idTipoProducto;
END$$