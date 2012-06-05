delimiter $$

CREATE PROCEDURE `buscarProducto`(idMarca int, idTipoProducto int, codigo varchar(13), 
    nombre varchar(100), enVenta bit)
BEGIN
    SELECT *
    FROM tbl_productos INNER JOIN
        tbl_marcas ON tbl_productos.idMarca = tbl_marcas.idMarca INNER JOIN
        tbl_tipos_producto ON tbl_productos.idTipoProducto = tbl_tipos_producto.idTipoProducto
    WHERE (tbl_productos.idMarca = idMarca OR idMarca IS NULL) AND
        (tbl_tipos_producto.idTipoProducto = idTipoProducto OR idTipoProducto IS NULL) AND
        (tbl_productos.codigo = codigo OR codigo IS NULL) AND
        (tbl_productos.nombre LIKE CONCAT(nombre, '%') OR nombre IS NULL) AND
        (tbl_productos.enVenta = enVenta OR enVenta IS NULL)
    ORDER BY tbl_marcas.nombre, tbl_tipos_producto.nombre, tbl_productos.nombre,
        tbl_productos.codigo, tbl_productos.enVenta;
END$$