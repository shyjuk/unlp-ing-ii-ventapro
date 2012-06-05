delimiter $$

CREATE PROCEDURE `agregarTipoProducto`(nombre VARCHAR(50), descripcion VARCHAR(100))
BEGIN
-- Insertar solo si no hay duplicados.
    INSERT INTO tbl_tipos_producto(nombre, descripcion)
    SELECT nombre, descripcion
    FROM dual
    WHERE NOT EXISTS ( -- Acá se comprueban duplicados.
        SELECT * 
        FROM tbl_tipos_producto
        WHERE UPPER(tbl_tipos_producto.nombre) = UPPER(nombre) COLLATE utf8_bin
    );

    IF ROW_COUNT() = 0 THEN -- Si no se insertó nada entonces se retorna el existente.
        SELECT ERROR_VALOR_DUPLICADO() AS CODIGO_ERROR, tbl_tipos_producto.*
        FROM tbl_tipos_producto
        WHERE UPPER(tbl_tipos_producto.nombre) = UPPER(nombre) COLLATE utf8_bin;
    ELSE -- Si se insertó entonces se retorna el ID del tipo de producto nuevo.
        SELECT 0 AS CODIGO_ERROR, idTipoProducto
        FROM tbl_tipos_producto
        WHERE tbl_tipos_producto.idTipoProducto = LAST_INSERT_ID();
    END IF;
END$$