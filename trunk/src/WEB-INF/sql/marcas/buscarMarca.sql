delimiter $$

CREATE PROCEDURE `buscarMarca`(nombre varchar(50))
BEGIN
    SELECT
    	M.idMarca AS Marca_idMarca,
    	M.nombre AS Marca_nombre,
    	M.sitioWeb AS Marca_sitioWeb,
    	M.contacto AS Marca_contacto,
    	M.infoAdicional AS Marca_infoAdicional
    FROM tbl_marcas M
    WHERE M.nombre LIKE CONCAT(nombre, '%') OR nombre IS NULL
    ORDER BY M.nombre;
END$$