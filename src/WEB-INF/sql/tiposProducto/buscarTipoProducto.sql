delimiter $$

CREATE PROCEDURE `buscarTipoProducto`(nombre varchar(50))
BEGIN
    SELECT 
        T.idTipoProducto AS TipoProducto_idTipoProducto,
        T.nombre AS TipoProducto_nombre,
        T.descripcion AS TipoProducto_descripcion
    FROM tbl_tipos_producto T
    WHERE T.nombre LIKE CONCAT(nombre, '%') OR nombre IS NULL
    ORDER BY T.nombre;
END$$