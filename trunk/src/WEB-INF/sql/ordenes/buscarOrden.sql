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
      	u.nombre as OrdenDeVenta_vendedor
    FROM db_ventapro.tbl_ordenes_venta O,
        db_ventapro.tbl_personas P,
        db_ventapro.tbl_usuarios u
    WHERE o.idcliente = p.idpersona
    and o.idVendedor = u.idUsuario
    and o.idvendedor = IFNULL(vend_id,O.idvendedor)
    and P.nroDocumento = IFNULL(comp_dni,p.nroDocumento)
    and O.estado = IFNULL(estado,O.estado)
    and (prod_code is null or exists (select 1 from db_ventapro.tbl_items i,
        db_ventapro.tbl_productos prod
        where i.idordenventa = o.idordenventa
        and i.idproducto = prod.idproducto
        and prod.codigo = prod_code))
    ORDER BY O.fechaHora;
END$$
