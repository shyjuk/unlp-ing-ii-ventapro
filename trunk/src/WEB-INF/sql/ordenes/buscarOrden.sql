

DELIMITER $$

CREATE PROCEDURE `buscarOrden`(
    comp_dni varchar(50), 
    comp_nombre varchar(50),
    vend_id varchar(50),
    prod_code varchar(50),
    fecha date,
    estado  varchar(50)
    )
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
        p.idlocalidad Localidad_idLocalidad,
        '' Localidad_nombre, 
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
        left join tbl_factura f on o.idOrdenVenta = f.idOrdenVenta
        inner join tbl_usuarios u on o.idVendedor = u.idUsuario
    WHERE o.idvendedor = IFNULL(vend_id,O.idvendedor)
    and P.nroDocumento = IFNULL(comp_dni,p.nroDocumento)
    and P.nombre like concat('%',IFNULL(comp_nombre,P.nombre),'%')
    and DATEDIFF(DATE_FORMAT(o.fechaHora, '%Y-%m-%d'),IFNULL(DATE_FORMAT(fecha, '%Y-%m-%d'),DATE_FORMAT(o.fechaHora, '%Y-%m-%d'))) = 0
    and O.estado = IFNULL(estado,O.estado)
    and O.estado <> 4
    and (prod_code is null or exists (select 1 from tbl_items i,
        tbl_productos prod
        where i.idordenventa = o.idordenventa
        and i.idproducto = prod.idproducto
        and prod.codigo = prod_code))
    ORDER BY O.fechaHora;
END$$
