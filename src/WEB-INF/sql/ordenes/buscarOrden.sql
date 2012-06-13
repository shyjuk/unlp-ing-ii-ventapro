

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
	      concat(P.nroDocumento,' - ',P.nombre) as OrdenDeVenta_comprador,
      	u.nombre as OrdenDeVenta_vendedor,
        '' as Factura_idFactura,
        '' as Factura_tipo,
        '' as Factura_monto,
        '' as Factura_medioPago,
        ''  as Factura_anulada
    FROM tbl_ordenes_venta  o,
        tbl_personas P,
        tbl_usuarios u
    WHERE o.idcliente = p.idpersona
    and o.idVendedor = u.idUsuario
    and o.idvendedor = IFNULL(vend_id,O.idvendedor)
    and P.nroDocumento = IFNULL(comp_dni,p.nroDocumento)
    and P.nombre like concat('%',IFNULL(comp_nombre,P.nombre),'%')
    and DATEDIFF(DATE_FORMAT(o.fechaHora, '%Y-%m-%d'),IFNULL(DATE_FORMAT(fecha, '%Y-%m-%d'),DATE_FORMAT(o.fechaHora, '%Y-%m-%d'))) = 0
    and O.estado = IFNULL(estado,O.estado)
    and (prod_code is null or exists (select 1 from tbl_items i,
        tbl_productos prod
        where i.idordenventa = o.idordenventa
        and i.idproducto = prod.idproducto
        and prod.codigo = prod_code))
    ORDER BY O.fechaHora;
END$$
