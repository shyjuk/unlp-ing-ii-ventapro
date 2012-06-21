delimiter $$

CREATE PROCEDURE `buscarLocalidad`(nombre varchar(50))
BEGIN
SELECT
    	l.idLocalidad AS Localidad_idLocalidad,
    	l.nombre AS Localidad_nombre
    FROM tbl_localidades l
    WHERE l.nombre like concat('%',IFNULL(nombre,l.nombre),'%')
    ORDER BY l.nombre;
END$$