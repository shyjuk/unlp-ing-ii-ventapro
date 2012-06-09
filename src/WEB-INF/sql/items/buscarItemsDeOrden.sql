DELIMITER $$

CREATE PROCEDURE  `buscarItemsDeOrden`(id_orden int)
BEGIN
    select i.idOrdenVenta  as Item_idOrdenVenta,
        i.numero as Item_numero,
        i.idProducto as Item_idProducto,
        i.precioUnitario as Item_precioUnitario,
        i.cantidad as Item_cantidad,
        
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
    from db_ventapro.tbl_items i,
        db_ventapro.tbl_productos p,
        db_ventapro.tbl_marcas m,
        db_ventapro.tbl_tipos_producto t
    where i.idordenventa = id_orden
    and i.idproducto = p.idproducto
    and p.idMarca = m.idMarca
    and p.idTipoProducto = t.idTipoProducto
    ORDER BY i.numero;
END $$
