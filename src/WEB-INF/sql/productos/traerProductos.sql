delimiter $$

CREATE PROCEDURE `traerProductos`()
BEGIN
    SELECT codigo,nombre,precio,garantia,stock,stockMinimo,
   	IF(enVenta=1,'Si','No') as enVenta,
 	descripcion 
    FROM tbl_productos 
    ORDER BY codigo, enVenta;
END$$