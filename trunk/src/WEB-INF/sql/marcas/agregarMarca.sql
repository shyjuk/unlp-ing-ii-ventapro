delimiter $$

CREATE PROCEDURE `agregarMarca`(nombre varchar(50), sitioWeb varchar(100), 
                            contacto varchar(1000), infoAdicional varchar(1000))
BEGIN    
-- Insertar solo si no hay duplicados.
    INSERT INTO tbl_marcas(nombre, sitioWeb, contacto, infoAdicional)
    SELECT nombre, sitioWeb, contacto, infoAdicional
    FROM dual
    WHERE NOT EXISTS ( -- Acá se comprueban duplicados.
        SELECT * 
        FROM tbl_marcas 
        WHERE UPPER(tbl_marcas.nombre) = UPPER(nombre) COLLATE utf8_bin
    );

    IF ROW_COUNT() = 0 THEN -- Si no se insertó nada entonces se retorna el existente.
        SELECT ERROR_VALOR_DUPLICADO() AS CODIGO_ERROR,
    		M.idMarca AS Marca_idMarca,
    		M.nombre AS Marca_nombre,
    		M.sitioWeb AS Marca_sitioWeb,
    		M.contacto AS Marca_contacto,
    		M.infoAdicional AS Marca_infoAdicional
    	FROM tbl_marcas M
        WHERE UPPER(M.nombre) = UPPER(nombre) COLLATE utf8_bin;
    ELSE -- Si se insertó entonces se retorna el ID de la marca nueva.
        SELECT 0 AS CODIGO_ERROR,
        	M.idMarca AS Marca_idMarca
        FROM tbl_marcas M
        WHERE M.idMarca = LAST_INSERT_ID();
    END IF;
END$$