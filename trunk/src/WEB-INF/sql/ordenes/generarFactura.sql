delimiter $$

CREATE PROCEDURE `generarFactura`(idOrden int, monto_ decimal, medioPago_ int)
BEGIN

    INSERT INTO tbl_factura(idOrdenVenta, tipo, monto, mediopago, anulada)
    VALUES(
        idOrden,
        1,
        monto_,
        medioPago_,
        0);

END$$