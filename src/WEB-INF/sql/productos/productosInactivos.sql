delimiter $$

CREATE PROCEDURE `productosInactivos`()
BEGIN
    SELECT p.codigo,
    p.nombre,
    tp.nombre as tipo,
    m.nombre as marca,
    p.precio,
    p.garantia,
    p.stock,
    p.stockMinimo,
   	IF(p.enVenta=1,'Si','No') as enVenta,
 	p.descripcion
    FROM tbl_productos p 
    INNER JOIN tbl_marcas m ON p.idMarca=m.IdMarca
    INNER JOIN tbl_tipos_producto tp ON p.idTipoProducto=tp.idTipoProducto 
    WHERE enVenta='No'
    ORDER BY codigo;
END$$