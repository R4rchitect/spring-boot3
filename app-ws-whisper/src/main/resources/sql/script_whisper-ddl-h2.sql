-- TABLA USUARIOS
CREATE TABLE usuarios (
    id_usuario INT NOT NULL UNIQUE AUTO_INCREMENT,
    usuario VARCHAR(30) NOT NULL UNIQUE,
    contrasenia VARCHAR(30) NOT NULL,
    nombres VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    correo VARCHAR(50) NOT NULL,
    estado VARCHAR(1) NOT NULL DEFAULT 'A',
    fecha_creacion DATETIME NOT NULL,
    PRIMARY KEY (id_usuario)
);

-- TABLA GRUPOS
CREATE TABLE grupos (
    id_grupo INT NOT NULL UNIQUE AUTO_INCREMENT,
    id_usuario INT NOT NULL,
    nombre_grupo VARCHAR(50) NOT NULL UNIQUE,
    estado VARCHAR(1) NOT NULL,
    PRIMARY KEY (id_grupo)
);

-- TABLA MIEMBROS
CREATE TABLE miembros (
    id_miembro INT NOT NULL UNIQUE AUTO_INCREMENT,
    id_grupo INT NOT NULL,
    nombres VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    correo VARCHAR(50) NOT NULL,
    celular int NOT NULL,
    cumpleanios DATETIME NOT NULL,
    PRIMARY KEY (id_miembro)
);

-- CONSTRAINT
ALTER TABLE grupos
ADD CONSTRAINT fk_grupo_usuario
FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario);

ALTER TABLE miembros
ADD CONSTRAINT fk_miembro_grupo
FOREIGN KEY (id_grupo) REFERENCES grupos(id_grupo);