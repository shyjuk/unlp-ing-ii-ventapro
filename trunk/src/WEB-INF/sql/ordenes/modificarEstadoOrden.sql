delimiter $$

CREATE PROCEDURE `modificarEstadoOrden`(id int, nuevo_estado int)
BEGIN
    
	DECLARE done BOOLEAN DEFAULT FALSE;
    declare producto_var int;
    declare cantidad_var int;
    declare cursor_test cursor for select idProducto, cantidad from tbl_items where idOrdenVenta = id;
    DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET done = TRUE;
    
    if `nuevo_estado` = 2 then begin 
	    open cursor_test;
	    
	    actualizacion: LOOP
		fetch cursor_test into producto_var, cantidad_var;
	        IF `done` 
	        	THEN LEAVE actualizacion; 
	        END IF; 
	        update tbl_productos 
		    set stock = stock + cantidad_var
		    where idProducto = producto_var;  
		END LOOP actualizacion;
	    
	    close cursor_test; 
    end;
    end if;
	
	UPDATE tbl_ordenes_venta
    SET estado = nuevo_estado
    WHERE idOrdenVenta = id;
    
    SELECT 0 AS CODIGO_ERROR
    FROM dual;
 
END$$