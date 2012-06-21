delimiter $$

CREATE PROCEDURE `generarOrdenItem`(idOrden int, idProducto int, cantidad int, numero int,  precioUnitario decimal)
BEGIN

    INSERT INTO tbl_items(idOrdenVenta, numero, idProducto, precioUnitario, cantidad)
    VALUES(
        idOrden,
        numero,
        idProducto,
        precioUnitario,
        cantidad);
        
     SELECT 0 AS CODIGO_ERROR, 
        	i.idProducto AS Item_idProducto,
        	i.idOrdenVenta AS Item_idOrdenVenta
        FROM tbl_items I
        WHERE I.idProducto = idProducto
        AND I.idOrdenVenta = idOrden;   
   
END$$