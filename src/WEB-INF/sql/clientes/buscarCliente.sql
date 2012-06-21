DELIMITER $$

CREATE PROCEDURE `buscarCliente`(nroDoc varchar(50))
BEGIN
    select c.idPersona Cliente_idPersona,
    c.nombre Cliente_nombre,
    c.tipoDocumento Cliente_tipoDocumento,
    c.nroDocumento Cliente_nroDocumento,
    c.telefono Cliente_telefono,
    c.celular Cliente_celular,
    c.email Cliente_email,
    c.calle Cliente_calle,
    c.numeroCalle Cliente_numeroCalle,
    c.dpto Cliente_dpto,
    l.idLocalidad Localidad_idLocalidad,
    l.nombre Localidad_nombre
from db_ventapro.tbl_personas c  
    left join db_ventapro.tbl_localidades l on c.idLocalidad = l.idlocalidad
where c.nroDocumento = nroDoc;
END$$