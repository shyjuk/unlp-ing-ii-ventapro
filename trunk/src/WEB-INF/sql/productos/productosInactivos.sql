delimiter $$

CREATE PROCEDURE `productosInactivos`()
BEGIN
    SELECT codigo,nombre,precio,garantia,stock,stockMinimo,
   	IF(enVenta=0,'No','Si') as enVenta,
 	descripcion 
    FROM tbl_productos 
    WHERE enVenta='No'
    ORDER BY codigo;
END$$