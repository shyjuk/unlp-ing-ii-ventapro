delimiter $$

CREATE PROCEDURE `buscarLocalidad`(nombre varchar(50))
BEGIN
SELECT
    	l.idLocalidad AS Localidad_idLocalidad,
    	l.nombre AS Localidad_nombre,
    	p.idProvincia AS Provincia_idProvincia,
    	p.nombre AS Provincia_nombre
    FROM tbl_localidades l,
    tbl_provincias p
    WHERE l.idProvincia = p.idProvincia
    and l.nombre like concat('%',IFNULL(nombre,l.nombre),'%')
    ORDER BY l.nombre;
END$$