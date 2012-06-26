delimiter $$

CREATE PROCEDURE `modificarCliente`(idPersona int, nombre varchar(100), tipoDocumento tinyint, nroDocumento varchar(20), 
	telefono varchar(20), celular varchar(20), email varchar(50),
	localidad varchar(50), calle varchar(50), numeroCalle int, dpto varchar(4))
BEGIN
-- Insertar localidad si no existe aún
	INSERT INTO tbl_localidades(nombre)
	SELECT localidad
	FROM dual
	WHERE NOT EXISTS (
		SELECT *
		FROM tbl_localidades
		WHERE tbl_localidades.nombre = localidad
	);
	
-- Actualizar solo si no causa duplicación.
    UPDATE tbl_personas A LEFT JOIN tbl_personas B ON 
        A.idPersona <> B.idPersona AND B.nroDocumento = nroDocumento -- Se comprueban duplicados
    SET A.idPersona = idPersona,
        A.nombre = nombre,
        A.tipoDocumento = tipoDocumento,
        A.nroDocumento = nroDocumento,
        A.telefono = telefono,
        A.celular = celular,
        A.email = email,
        A.idLocalidad = (SELECT L.idLocalidad FROM tbl_localidades L WHERE L.nombre = localidad),
        A.calle = calle,
        A.numeroCalle = numeroCalle,
        A.dpto = dpto
    WHERE A.idPersona = idPersona AND 
        B.nroDocumento IS NULL; -- Si hay duplicado entonces B.idPersona no va ser NULL

-- Borrar localidades que ya no tengan clientes
	DELETE FROM tbl_localidades 
	WHERE NOT EXISTS (
		SELECT *
		FROM tbl_personas
		WHERE tbl_personas.idLocalidad = tbl_localidades.idLocalidad
	);
        
-- ROW_COUNT() retorna 0 si lo que se actualiza ya tenía los mismos datos así que no se puede usar acá.

-- Si no se actualizó nada entonces se retorna el existente.
	SELECT ERROR_VALOR_DUPLICADO() AS CODIGO_ERROR, 
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
    WHERE C.nroDocumento = nroDocumento AND
    	C.idPersona <> idPersona;
            
-- Si se actualizó entonces se indica el éxito de la operación.
    SELECT 0 AS CODIGO_ERROR
    FROM dual
    WHERE EXISTS (
        SELECT * 
        FROM tbl_personas
        WHERE tbl_personas.idPersona = idPersona AND
            tbl_personas.nroDocumento = nroDocumento
    );
 
END$$