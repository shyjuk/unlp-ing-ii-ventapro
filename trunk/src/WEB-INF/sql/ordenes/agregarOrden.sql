delimiter $$

CREATE PROCEDURE `agregarOrden`(fechaHora datetime)
BEGIN

    INSERT INTO tbl_ordenes_venta(idCliente, idVendedor, fechaHora, estado)
    VALUES(
    	(SELECT idPersona FROM tbl_personas LIMIT 1),
    	(SELECT idPersona FROM tbl_personas LIMIT 1),
    	fechaHora,
    	4
    );

    SELECT 0 AS CODIGO_ERROR,
    	O.idOrdenVenta AS OrdenDeVenta_idOrdenVenta
    FROM tbl_ordenes_venta O
    WHERE O.idOrdenVenta = LAST_INSERT_ID();
END$$