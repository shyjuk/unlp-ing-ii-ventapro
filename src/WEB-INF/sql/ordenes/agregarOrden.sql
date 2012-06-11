delimiter $$

CREATE PROCEDURE `agregarOrden`(idOrden int,idCliente int, idVendedor int, fechaHora Date, estado varchar(20))
BEGIN
-- Insertar solo si no hay duplicados y las FKs son válidas.
    INSERT INTO tbl_ordenes_venta(idOrden, idCliente, idVendedor, fechaHora, estado) 
    SELECT idOrden, idCliente, idVendedor, fechaHora, estado
    FROM dual
    WHERE NOT EXISTS ( -- Acá se comprueban duplicados.
        SELECT * 
        FROM tbl_ordenes_venta
        WHERE tbl_ordenes_venta.idOrden = idOrden
    ) AND
    -- Acá se comprueban las FKs.
        EXISTS (SELECT * FROM tbl_personas WHERE tbl_personas.idCliente = idCliente) AND
        EXISTS (SELECT * FROM tbl_usuarios WHERE tbl_usuarios.idUsuario = idVendedor);

    IF ROW_COUNT() = 0 THEN -- Si no se insertó nada entonces:
    -- Se trata de retornar el duplicado:
        SELECT ERROR_VALOR_DUPLICADO() AS CODIGO_ERROR, 
    		O.idOrden AS Orden_idOrden,
    		O.fechaHora AS Orden_fechaHora,
    		O.estado AS Orden_estado,
    	
    		P.idPersona AS Persona_idPersona,
    		P.nombre AS Persona_nombre,
    		P.nroDocumento AS Persona_nroDocumento,
    		P.fechaNac AS Persona_fechaNac,
    		P.calle AS Persona_calle,
    		P.nroCalle AS Persona_nroCalle,
    		P.codPostal AS Persona_codPostal,
    		P.email AS Persona_email,
    	
    		U.nombre AS Usuario_nombre,
    	FROM tbl_ordenes_venta O INNER JOIN
	        tbl_personas P ON O.idCliente = P.idPersona INNER JOIN
    	    tbl_usuarios U ON O.idVendedor = T.idUsuario
    	WHERE O.idOrden = idOrden;
    
    -- Se trata de retornar los errores de FK:
        SELECT ERROR_REFERENCIA() AS CODIGO_ERROR, 
            tbl_personas.idPersona AS idPersona, tbl_usuarios.idUsuario AS idUsuario
        FROM (SELECT 1 FROM dual) D LEFT JOIN
            tbl_usuarios ON tbl_usuarios.idUsuario = idVendedor LEFT JOIN
            tbl_personas ON tbl_personas.idPersona = idCliente
        WHERE tbl_personas.idPersona IS NULL OR tbl_usuarios.idUsuarios IS NULL;
    ELSE -- Si se insertó entonces se retorna el ID del producto nuevo.
        SELECT 0 AS CODIGO_ERROR, 
        	O.idOrden AS Orden_idOrden
        FROM tbl_ordenes_venta O
        WHERE O.idOrden = LAST_INSERT_ID();
    END IF;
END$$