DELIMITER $$

CREATE PROCEDURE `buscarCliente`(nroDocumento varchar(20), nombre varchar(100))
BEGIN
    SELECT 
    	C.idPersona Cliente_idPersona,
    	C.nombre Cliente_nombre,
    	C.tipoDocumento Cliente_tipoDocumento,
    	C.nroDocumento Cliente_nroDocumento,
    	C.telefono Cliente_telefono,
    	C.celular Cliente_celular,
    	C.email Cliente_email,
    	C.calle Cliente_calle,
    	C.numeroCalle Cliente_numeroCalle,
    	C.dpto Cliente_dpto,
    	L.nombre Cliente_localidad
FROM tbl_personas C INNER JOIN
	tbl_localidades L on C.idLocalidad = L.idlocalidad
WHERE (C.nroDocumento = nroDocumento OR nroDocumento IS NULL) AND
	(C.nombre LIKE nombre OR nombre IS NULL);
END$$