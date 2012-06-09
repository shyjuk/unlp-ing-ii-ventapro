delimiter $$

CREATE PROCEDURE `modificarTipoProducto`(idTipoProducto int, nombre varchar(50), descripcion varchar(100))
BEGIN
-- Actualizar solo si no causa duplicación.
    UPDATE tbl_tipos_producto A LEFT JOIN tbl_tipos_producto B ON 
        A.idTipoProducto <> B.idTipoProducto AND UPPER(B.nombre) = UPPER(nombre) -- Se comprueban duplicados
    SET A.idTipoProducto = idTipoProducto,
        A.nombre = nombre,
        A.descripcion = descripcion
    WHERE A.idTipoProducto = idTipoProducto AND 
        B.idTipoProducto IS NULL; -- Si hay duplicado entonces B.idTipoProducto no va ser NULL

-- ROW_COUNT() retorna 0 si lo que se actualiza ya tenía los mismos datos así que no se puede usar acá.

-- Si no se actualizó nada entonces se retorna el existente.
    SELECT ERROR_VALOR_DUPLICADO() AS CODIGO_ERROR,  
        T.idTipoProducto AS TipoProducto_idTipoProducto,
        T.nombre AS TipoProducto_nombre,
        T.descripcion AS TipoProducto_descripcion
    FROM tbl_tipos_producto T
    WHERE UPPER(T.nombre) = UPPER(nombre) AND
            T.idTipoProducto <> idTipoProducto;
            
-- Si se actualizó entonces se indica el éxito de la operación.
    SELECT 0 AS CODIGO_ERROR
    FROM dual
    WHERE EXISTS(
        SELECT * 
        FROM tbl_tipos_producto
        WHERE tbl_tipos_producto.idTipoProducto = idTipoProducto AND
            UPPER(tbl_tipos_producto.nombre) = UPPER(nombre));
 
END$$