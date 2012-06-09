delimiter $$

CREATE PROCEDURE `agregarProducto`(idMarca int, idTipoProducto int, codigo varchar(13), nombre varchar(100),
    precio decimal(7,2), garantia int, stock int, stockMinimo int, enVenta bit, descripcion varchar(1000))
BEGIN
-- Insertar solo si no hay duplicados y las FKs son válidas.
    INSERT INTO tbl_productos(idMarca, idTipoProducto, codigo, nombre, 
        precio, garantia, stock, stockMinimo, enVenta, descripcion)
    SELECT idMarca, idTipoProducto, codigo, nombre, 
        precio, garantia, stock, stockMinimo, enVenta, descripcion
    FROM dual
    WHERE NOT EXISTS ( -- Acá se comprueban duplicados.
        SELECT * 
        FROM tbl_productos
        WHERE tbl_productos.codigo = codigo
    ) AND
    -- Acá se comprueban las FKs.
        EXISTS (SELECT * FROM tbl_marcas WHERE tbl_marcas.idMarca = idMarca) AND
        EXISTS (SELECT * FROM tbl_tipos_producto WHERE tbl_tipos_producto.idTipoProducto = idTipoProducto);

    IF ROW_COUNT() = 0 THEN -- Si no se insertó nada entonces:
    -- Se trata de retornar el duplicado:
        SELECT ERROR_VALOR_DUPLICADO() AS CODIGO_ERROR, 
    		P.idProducto AS Producto_idProducto,
    		P.idMarca AS Producto_idMarca,
    		P.idTipoProducto AS Producto_idTipoProducto,
    		P.codigo AS Producto_codigo,
    		P.nombre AS Producto_nombre,
    		P.precio AS Producto_precio,
    		P.garantia AS Producto_garantia,
    		P.stock AS Producto_stock,
    		P.stockMinimo AS Producto_stockMinimo,
    		P.enVenta AS Producto_enVenta,
    		P.descripcion AS Producto_descripcion,
    	
    		M.idMarca AS Marca_idMarca,
    		M.nombre AS Marca_nombre,
    		M.sitioWeb AS Marca_sitioWeb,
    		M.contacto AS Marca_contacto,
    		M.infoAdicional AS Marca_infoAdicional,
    	
    		T.idTipoProducto AS TipoProducto_idTipoProducto,
    		T.nombre AS TipoProducto_nombre,
    		T.descripcion AS TipoProducto_descripcion
    	FROM tbl_productos P INNER JOIN
	        tbl_marcas M ON P.idMarca = M.idMarca INNER JOIN
    	    tbl_tipos_producto T ON P.idTipoProducto = T.idTipoProducto
    	WHERE P.codigo = codigo;
    
    -- Se trata de retornar los errores de FK:
        SELECT ERROR_REFERENCIA() AS CODIGO_ERROR, 
            tbl_marcas.idMarca AS idMarca, tbl_tipos_producto.idTipoProducto AS idTipoProducto
        FROM (SELECT 1 FROM dual) D LEFT JOIN
            tbl_marcas ON tbl_marcas.idMarca = idMarca LEFT JOIN
            tbl_tipos_producto ON tbl_tipos_producto.idTipoProducto = idTipoProducto
        WHERE tbl_marcas.idMarca IS NULL OR tbl_tipos_producto.idTipoProducto IS NULL;
    ELSE -- Si se insertó entonces se retorna el ID del producto nuevo.
        SELECT 0 AS CODIGO_ERROR, 
        	P.idProducto AS Producto_codigo
        FROM tbl_productos P
        WHERE P.idProducto = LAST_INSERT_ID();
    END IF;
END$$