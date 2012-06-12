delimiter $$

CREATE PROCEDURE `agregarItemDeOrden`(idOrdenVenta int, idProducto int, precioUnitario decimal(7,2), cantidad int)
BEGIN    
-- Insertar solo si no hay duplicados.
    INSERT INTO tbl_items(idOrdenVenta, numero, idProducto, precioUnitario, cantidad)
    SELECT idOrdenVenta, 
    	(SELECT IFNULL(MAX(numero) + 1, 1) FROM tbl_items I WHERE I.idOrdenVenta = idOrdenVenta), 
    	idProducto,
    	precioUnitario,
    	cantidad
    FROM dual
    WHERE NOT EXISTS ( -- Acá se comprueban duplicados.
        SELECT * 
        FROM tbl_items I
        WHERE I.idOrdenVenta <> idOrdenVenta AND I.idProducto = idProducto
    );

    IF ROW_COUNT() = 0 THEN -- Si no se insertó nada entonces se actualiza el existente.
    	UPDATE tbl_items I
    	SET I.cantidad = I.cantidad + cantidad
    	WHERE I.idOrdenVenta = idOrdenVenta AND I.idProducto = idProducto;
    	
        SELECT 0 AS CODIGO_ERROR,
        	I.idOrdenVenta AS Item_idOrdenVenta,
        	I.numero AS Item_numero
        FROM tbl_item I
        WHERE I.idOrdenVenta = idOrdenVenta AND I.idProducto = idProducto;
    ELSE -- Si se insertó entonces se retorna el ID del item nuevo.
        SELECT 0 AS CODIGO_ERROR,
        	I.idOrdenVenta AS Item_idOrdenVenta,
        	I.numero AS Item_numero
        FROM tbl_item I
        WHERE I.idOrdenVenta = idOrdenVenta AND
        	I.numero = (SELECT MAX(numero) FROM tbl_item A WHERE A.idOrdenVenta = idOrdenVenta);
        -- TODO: Esta forma de recuperar el ID no tolera concurrencia sobre la misma orden (que es super improbable pero bue)
    END IF;
END$$