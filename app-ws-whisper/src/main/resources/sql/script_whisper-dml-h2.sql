
-- INSERT USUARIOS
INSERT INTO usuarios(usuario,contrasenia,nombres, apellidos, correo, estado, fecha_creacion)
VALUES ('rsanchez','1234','ROY ABEL','SANCHEZ CABRERA','abelsancheez@gmail.com','A', current_timestamp());

-- INSERT GRUPOS
INSERT INTO grupos (id_usuario, nombre_grupo, estado)
VALUES (1,'FAMILIA SANCHEZ2','A');

-- INSERT MIEMBROS
INSERT INTO miembros (id_grupo, nombres, apellidos, correo, celular, cumpleanios)
VALUES (1,'PALMIRA','CABRERA FERNANDEZ','abelsancheez@gmail.com','991466072', PARSEDATETIME('24-11-2023','dd-MM-yyyy'));

