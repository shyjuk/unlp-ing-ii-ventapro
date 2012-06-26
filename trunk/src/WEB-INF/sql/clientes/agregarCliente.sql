delimiter $$

CREATE PROCEDURE `agregarCliente`(nombre varchar(100), tipoDocumento tinyint, nroDocumento varchar(20), 
	telefono varchar(20), celular varchar(20), email varchar(50),
	localidad varchar(50), calle varchar(50), numeroCalle int, dpto varchar(4))
BEGIN

	START TRANSACTION; -- Para volver atrás con la localidad si hace falta

	-- Insertar localidad si no existe aún
	INSERT INTO tbl_localidades(nombre)
	SELECT localidad
	FROM dual
	WHERE NOT EXISTS (
		SELECT *
		FROM tbl_localidades
		WHERE tbl_localidades.nombre = localidad
	);

	-- Insertar solo si no hay duplicados.
	INSERT INTO tbl_personas(nombre, tipoDocumento, nroDocumento, telefono, celular, eMail, 
    	idLocalidad, calle, numeroCalle, dpto)
    SELECT nombre, tipoDocumento, nroDocumento, telefono, celular, email,
    	(SELECT L.idLocalidad FROM tbl_localidades L WHERE L.nombre = localidad), calle, numeroCalle, dpto
    FROM dual
    WHERE NOT EXISTS ( -- Acá se comprueban duplicados.
        SELECT * 
        FROM tbl_personas
        WHERE tbl_personas.nroDocumento = nroDocumento
    );

    IF ROW_COUNT() = 0 THEN -- Si no se insertó nada entonces se retorna el existente.
    	ROLLBACK;
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
		WHERE C.nroDocumento = nroDocumento;
    ELSE -- Si se insertó entonces se retorna el ID del cliente nuevo.
    	COMMIT;
        SELECT 0 AS CODIGO_ERROR, 
            C.idPersona Cliente_idPersona
        FROM tbl_personas C
        WHERE C.idPersona = LAST_INSERT_ID();
    END IF;
END$$