delimiter $$

CREATE PROCEDURE `buscarOrdenActual` (idVendedor int) 
BEGIN
    SELECT
			o.idOrdenVenta as OrdenDeVenta_idOrdenVenta,
	      o.idCliente as OrdenDeVenta_idCliente,
	      o.idVendedor as OrdenDeVenta_idVendedor,
	      o.fechaHora as OrdenDeVenta_fechaHora,
	      o.estado as OrdenDeVenta_estado,
        p.idPersona  as Cliente_idPersona,
        p.nombre as Cliente_nombre,
        p.tipoDocumento as Cliente_tipoDocumento,
        p.nroDocumento as Cliente_nroDocumento,
        p.telefono as Cliente_telefono,
        p.celular as Cliente_celular,
        p.email as Cliente_email,
        p.localidad Localidad_idLocalidad,
        '' Localidad_nombre, 
        p.idProvincia Provincia_idProvincia,
        '' Provincia_nombre,
        p.calle as Cliente_calle,
        p.numeroCalle as Cliente_numeroCalle,
        p.dpto as Cliente_dpto,
      	u.nombre as OrdenDeVenta_vendedor,
        f.idFactura as Factura_idFactura,
        f.tipo as Factura_tipo,
        f.monto as Factura_monto,
        f.medioPago as Factura_medioPago,
        f.anulada  as Factura_anulada
    FROM tbl_ordenes_venta  o left join tbl_personas P on o.idcliente = p.idpersona
        left join tbl_factura f on o.idOrdenVenta = f.idFactura
        inner join tbl_usuarios u on o.idVendedor = u.idUsuario
    WHERE estado = 4
    and o.idVendedor = idVendedor;
END$$
