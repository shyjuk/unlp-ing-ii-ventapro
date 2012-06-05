delimiter $$

CREATE PROCEDURE `leerProducto`(idProducto int)
BEGIN
    SELECT *
    FROM tbl_productos
    WHERE tbl_productos.idProducto = idProducto;
END$$