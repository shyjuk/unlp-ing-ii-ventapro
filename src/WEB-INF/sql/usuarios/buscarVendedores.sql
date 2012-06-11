DELIMITER $$

CREATE PROCEDURE `buscarUsuario`(id_usuario int)
BEGIN
    select u.idUsuario as Vendedor_idVendedor,
        P.nombre as Vendedor_nombre
    from tbl_usuarios u INNER JOIN tbl_personas P
    	ON u.idUsuario = P.idPersona
    ORDER BY u.nombre;
END$$