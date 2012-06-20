delimiter $$

CREATE PROCEDURE `generarOrdenItem`(idOrden int, idProducto int, cantidad int, numero int,  precioUnitario decimal)
BEGIN

    INSERT INTO tbl_items(idOrdenVenta, numero, idProducto, precioUnitario, cantidad)
    VALUES(
        idOrden,
        numero,
        idProducto,
        precioUnitario,
        cantidad);
   
END$$