delimiter $$

CREATE PROCEDURE `generarOrden`(idOrden int, idCli int)
BEGIN
	
	 declare fin int default 0;
    declare producto_var int;
    declare cantidad_var int;
    declare cursor_test cursor for select idProducto, cantidad from tbl_items where idOrdenVenta = idOrden;
    declare continue handler for sqlstate '02000' set fin = 1;
    
    update tbl_ordenes_venta
    set estado = 1,
        idCliente = idCli
    where idOrdenVenta = idOrden;
    
    open cursor_test;
    
    actualizacion: loop
        
        fetch cursor_test into producto_var, cantidad_var;
        
        if not fin then begin
            update tbl_productos 
            set stock = stock - cantidad_var
            where idProducto = producto_var;  
            end;
        end if;
        commit;
    end loop actualizacion;
    
    close cursor_test;

END$$