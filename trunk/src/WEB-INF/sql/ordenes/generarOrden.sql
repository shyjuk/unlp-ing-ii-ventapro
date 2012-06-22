delimiter $$

CREATE PROCEDURE `generarOrden`(idOrden int, idCli int)
BEGIN
	
	DECLARE done BOOLEAN DEFAULT FALSE;
    declare producto_var int;
    declare cantidad_var int;
    declare cursor_test cursor for select idProducto, cantidad from tbl_items where idOrdenVenta = idOrden;
    DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET done = TRUE;
    
    update tbl_ordenes_venta
    set estado = 1,
        idCliente = idCli
    where idOrdenVenta = idOrden;
    
    open cursor_test;
    
    actualizacion: LOOP
	fetch cursor_test into producto_var, cantidad_var;
        IF `done` 
        	THEN LEAVE actualizacion; 
        END IF; 
        update tbl_productos 
	    set stock = stock - cantidad_var
	    where idProducto = producto_var;  
	END LOOP actualizacion;
    
    close cursor_test; 
    
    SELECT 0 AS CODIGO_ERROR,
        	o.idOrdenVenta AS OrdenDeVenta_idOrdenVenta
        FROM tbl_ordenes_venta o
        WHERE o.idOrdenVenta = idOrden;

END$$