delimiter $$

CREATE PROCEDURE `buscarTipoProducto`(nombre varchar(50))
BEGIN
    SELECT *
    FROM tbl_tipos_producto
    WHERE tbl_tipos_producto.nombre LIKE CONCAT(nombre, '%') OR nombre IS NULL
    ORDER BY tbl_tipos_producto.nombre;
END$$