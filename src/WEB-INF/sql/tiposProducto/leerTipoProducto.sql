delimiter $$

CREATE PROCEDURE `leerTipoProducto`(idTipoProducto int)
BEGIN
    SELECT 
        T.idTipoProducto AS TipoProducto_idTipoProducto,
        T.nombre AS TipoProducto_nombre,
        T.descripcion AS TipoProducto_descripcion
    FROM tbl_tipos_producto T
    WHERE T.idTipoProducto = idTipoProducto;
END$$