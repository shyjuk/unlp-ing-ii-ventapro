delimiter $$

CREATE PROCEDURE `rollbackGeneracionOrden`(idOrden int)
BEGIN
	
	DECLARE done BOOLEAN DEFAULT FALSE;
    declare producto_var int;
    declare cantidad_var int;
    declare cursor_test cursor for select idProducto, cantidad from tbl_items where idOrdenVenta = idOrden;
    DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET done = TRUE;
    
	/*open cursor_test;
    
    actualizacion: LOOP
	fetch cursor_test into producto_var, cantidad_var;
        IF `done` 
        	THEN LEAVE actualizacion; 
        END IF; 
        update tbl_productos 
	    set stock = stock + cantidad_var
	    where idProducto = producto_var;  
	END LOOP actualizacion;
    
    close cursor_test;*/ 
    
    delete from tbl_factura
	where idOrdenVenta = idOrden;
	
	delete from tbl_items
	where idOrdenVenta = idOrden; 
	
	SELECT 0 AS CODIGO_ERROR
    FROM dual;
END$$