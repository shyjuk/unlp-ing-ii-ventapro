delimiter $$

CREATE PROCEDURE `buscarProvincia`(nombre varchar(50))
BEGIN
SELECT
    	p.idProvincia AS Provincia_idProvincia,
    	p.nombre AS Provincia_nombre
    FROM tbl_provincias p
    WHERE p.nombre like concat('%',IFNULL(nombre, p.nombre),'%')
    ORDER BY  p.nombre;
END$$