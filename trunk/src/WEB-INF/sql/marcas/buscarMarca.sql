delimiter $$

CREATE PROCEDURE `buscarMarca`(nombre varchar(50))
BEGIN
    SELECT *
    FROM tbl_marcas
    WHERE tbl_marcas.nombre LIKE CONCAT(nombre, '%') OR nombre IS NULL
    ORDER BY tbl_marcas.nombre;
END$$