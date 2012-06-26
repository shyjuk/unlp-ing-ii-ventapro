delimiter $$

CREATE PROCEDURE `bajoMinimo`()
BEGIN
    SELECT codigo,nombre,precio,garantia,stock,stockMinimo,
   	IF(enVenta=1,'Si','No') as enVenta,
 	descripcion 
    FROM tbl_productos 
    WHERE stock<stockMinimo
    ORDER BY codigo, enVenta;
END$$