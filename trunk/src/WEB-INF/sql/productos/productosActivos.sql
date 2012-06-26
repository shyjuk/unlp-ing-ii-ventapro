delimiter $$

CREATE PROCEDURE `productosActivos`()
BEGIN
    SELECT codigo,nombre,precio,garantia,stock,stockMinimo,
   	IF(enVenta=1,'Si','No') as enVenta,
 	descripcion 
    FROM tbl_productos 
    WHERE enVenta=1
    ORDER BY codigo;
END$$