DELIMITER $$

CREATE PROCEDURE `buscarUsuario`(id_usuario int)
BEGIN
    select u.idUsuario as Usuario_idUsuario,
        u.nombre as Usuario_nombre,
        u.contrasena as Usuario_contrasena,
        u.rol as Usuario_rol,
        u.activo as Usuario_activo
    from tbl_usuarios u
    where u.idUsuario = IFNULL(id_usuario,u.idUsuario)
    ORDER BY u.nombre;
END$$