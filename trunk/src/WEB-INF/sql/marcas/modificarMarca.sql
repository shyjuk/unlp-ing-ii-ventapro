delimiter $$

CREATE DEFINER=`hernan`@`%` PROCEDURE `modificarMarca`(idMarca int, nombre varchar(50), sitioWeb varchar(100), 
                            contacto varchar(1000), infoAdicional varchar(1000))
BEGIN
-- Actualizar solo si no causa duplicación.
    UPDATE tbl_marcas A LEFT JOIN tbl_marcas B ON 
        A.idMarca <> B.idMarca AND UPPER(B.nombre) = UPPER(nombre) -- Se comprueban duplicados
    SET A.idMarca = idMarca,
        A.nombre = nombre,
        A.sitioWeb = sitioWeb,
        A.contacto = contacto,
        A.infoAdicional = infoAdicional
    WHERE A.idMarca = idMarca AND 
    B.idMarca IS NULL; -- Si hay duplicado entonces B.idMarca no va ser NULL

-- ROW_COUNT() retorna 0 si lo que se actualiza ya tenía los mismos datos así que no se puede usar acá.

-- Si no se actualizó nada entonces se retorna el existente.
    SELECT ERROR_VALOR_DUPLICADO() AS CODIGO_ERROR, tbl_marcas.*
    FROM tbl_marcas
    WHERE UPPER(tbl_marcas.nombre) = UPPER(nombre) AND
            tbl_marcas.idMarca <> idMarca;
            
-- Si se actualizó entonces se indica el éxito de la operación.
    SELECT 0 AS CODIGO_ERROR
    FROM dual
    WHERE EXISTS(
        SELECT * 
        FROM tbl_marcas
        WHERE tbl_marcas.idMarca = idMarca AND
            UPPER(tbl_marcas.nombre) = UPPER(nombre));
END$$