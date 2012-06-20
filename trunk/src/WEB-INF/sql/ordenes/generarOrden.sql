delimiter $$

CREATE PROCEDURE `generarOrden`(idOrden int, idCli int)
BEGIN

    update tbl_ordenes_venta
    set estado = 1,
        idCliente = idCli
    where idOrdenVenta = idOrden;

END$$