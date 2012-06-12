delimiter $$

CREATE PROCEDURE `leerOrden`(idOrdenVenta int)
BEGIN
    SELECT
			o.idOrdenVenta as OrdenDeVenta_idOrdenVenta,
	      o.idCliente as OrdenDeVenta_idCliente,
	      o.idVendedor as OrdenDeVenta_idVendedor,
	      o.fechaHora as OrdenDeVenta_fechaHora,
	      o.estado as OrdenDeVenta_estado,
	      concat(P.nroDocumento,' - ',P.nombre) as OrdenDeVenta_comprador,
      	u.nombre as OrdenDeVenta_vendedor,
        f.idFactura as Factura_idFactura,
        f.tipo as Factura_tipo,
        f.monto as Factura_monto,
        f.medioPago as Factura_medioPago,
        f.anulada  as Factura_anulada
    FROM tbl_ordenes_venta o LEFT JOIN
        tbl_factura f ON o.idOrdenVenta = f.idOrdenVenta
    WHERE O.idOrdenVenta = idOrdenVenta;
END$$