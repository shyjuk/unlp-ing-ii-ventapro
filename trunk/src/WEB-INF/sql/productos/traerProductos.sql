delimiter $$

CREATE PROCEDURE `traerProductos`()
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
    	
    	T.idTipoProducto AS TipoProducto_idTipoProducto,
    	T.nombre AS TipoProducto_nombre
    FROM tbl_productos P INNER JOIN
        tbl_marcas M ON P.idMarca = M.idMarca INNER JOIN
        tbl_tipos_producto T ON P.idTipoProducto = T.idTipoProducto
    WHERE P.stock > 1 AND P.enVenta = 1
    ORDER BY P.codigo;
END$$