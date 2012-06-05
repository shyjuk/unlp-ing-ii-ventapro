delimiter $$

CREATE PROCEDURE `leerMarca`(idMarca int)
BEGIN
    SELECT *
    FROM tbl_marcas
    WHERE tbl_marcas.idMarca = idMarca;
END$$