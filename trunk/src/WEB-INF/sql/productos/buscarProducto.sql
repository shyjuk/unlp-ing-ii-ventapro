delimiter $$

CREATE PROCEDURE `buscarProducto`(idMarca int, idTipoProducto int, codigo varchar(13), 
    nombre varchar(100), enVenta bit)
BEGIN
    SELECT
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
    WHERE (P.idMarca = idMarca OR idMarca IS NULL) AND
        (P.idTipoProducto = idTipoProducto OR idTipoProducto IS NULL) AND
        (P.codigo = codigo OR codigo IS NULL) AND
        (P.nombre LIKE CONCAT(nombre, '%') OR nombre IS NULL) AND
        (P.enVenta = enVenta OR enVenta IS NULL)
    ORDER BY T.nombre, M.nombre, P.nombre, P.codigo, P.enVenta;
END$$