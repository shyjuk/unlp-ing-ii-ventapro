delimiter $$

CREATE PROCEDURE `reporteProductos`(enVenta bit, bajoStock bit)
BEGIN
    SELECT
    	P.codigo AS Producto_codigo,
    	P.nombre AS Producto_nombre,
    	P.precio AS Producto_precio,
    	P.stock AS Producto_stock,
    	P.stockMinimo AS Producto_stockMinimo,
    	
    	M.nombre AS Marca_nombre,
    	
    	T.nombre AS TipoProducto_nombre
    FROM tbl_productos P INNER JOIN
        tbl_marcas M ON P.idMarca = M.idMarca INNER JOIN
        tbl_tipos_producto T ON P.idTipoProducto = T.idTipoProducto
    WHERE (P.enVenta = enVenta) AND (bajoStock = 0 OR P.stock < P.stockMinimo)
    ORDER BY T.nombre, M.nombre, P.nombre, P.codigo;
END$$