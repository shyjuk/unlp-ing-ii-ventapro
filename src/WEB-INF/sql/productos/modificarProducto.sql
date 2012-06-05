delimiter $$

CREATE PROCEDURE `modificarProducto`(idProducto int, idMarca int, idTipoProducto int, codigo varchar(13), 
    nombre varchar(100), precio decimal(7,2), garantia int, stock int, stockMinimo int, descripcion varchar(1000))
BEGIN
-- Insertar solo si no hay duplicados y las FKs son válidas.
    UPDATE tbl_productos A LEFT JOIN tbl_productos B ON
        A.idProducto <> B.idProducto AND B.codigo = codigo -- Se comprueban duplicados
    SET A.idMarca = idMarca,
        A.idTipoProducto = idTipoProducto, 
        A.codigo = codigo, 
        A.nombre = nombre, 
        A.precio = precio,
        A.garantia = garantia,
        A.stock = stock,
        A.stockMinimo = stockMinimo,
        A.descripcion = descripcion
    WHERE A.idProducto = idProducto AND 
        B.idProducto IS NULL AND -- Si hay duplicado entonces B.idProducto no va ser NULL
    -- Acá se comprueban las FKs.
        EXISTS (SELECT * FROM tbl_marcas WHERE tbl_marcas.idMarca = idMarca) AND
        EXISTS (SELECT * FROM tbl_tipos_producto WHERE tbl_tipos_producto.idTipoProducto = idTipoProducto);

-- ROW_COUNT() retorna 0 si lo que se actualiza ya tenía los mismos datos así que no se puede usar acá.

-- Si no se actualizó nada entonces:

    -- Se trata de retornar el duplicado:
        SELECT ERROR_VALOR_DUPLICADO() AS CODIGO_ERROR, tbl_productos.*
        FROM tbl_productos
        WHERE tbl_productos.codigo = codigo AND
            tbl_productos.idProducto <> idProducto;
    
    -- Se trata de retornar los errores de FK:
        SELECT ERROR_REFERENCIA() AS CODIGO_ERROR, 
            tbl_marcas.idMarca, tbl_tipos_producto.idTipoProducto
        FROM (SELECT 1 FROM dual) D LEFT JOIN
            tbl_marcas ON tbl_marcas.idMarca = idMarca LEFT JOIN
            tbl_tipos_producto ON tbl_tipos_producto.idTipoProducto = idTipoProducto
        WHERE tbl_marcas.idMarca IS NULL OR tbl_tipos_producto.idTipoProducto IS NULL;
        
    -- Si se actualizó entonces se indica el éxito de la operación.
        SELECT 0 AS CODIGO_ERROR
        FROM dual
        WHERE EXISTS(
            SELECT * 
            FROM tbl_productos
            WHERE tbl_productos.idProducto = idProducto AND
                tbl_productos.codigo = codigo AND
                tbl_productos.idMarca = idMarca AND
                tbl_productos.idTipoProducto = idTipoProducto);
END$$