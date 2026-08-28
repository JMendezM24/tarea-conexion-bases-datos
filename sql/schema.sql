-- Clase 5 - Primer contacto con un motor de base de datos (MySQL)
-- Ejecuta este script en MySQL Workbench (o en la consola `mysql`) ANTES de correr el proyecto Java.
--
-- Si ya creaste la base `prog2_db` y la tabla `estudiantes` en la tarea de la Clase 3,
-- este script no te hara dano: usa IF NOT EXISTS y no duplica los datos de ejemplo
-- gracias a la restriccion UNIQUE sobre `carnet`.

CREATE DATABASE IF NOT EXISTS prog2_db;

USE prog2_db;

CREATE TABLE IF NOT EXISTS estudiantes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    carnet VARCHAR(20) NOT NULL UNIQUE
);

-- INSERT IGNORE: si el carnet ya existe (por ejemplo porque ya corriste este script
-- antes) MySQL ignora esa fila en lugar de lanzar un error de duplicado.
INSERT IGNORE INTO estudiantes (nombre, carnet) VALUES
    ('Ana Lopez', '2024001'),
    ('Carlos Perez', '2024002'),
    ('Maria Gonzalez', '2024003');


-- Tarea Proga2: Modificaciones a la estructura de la base de datos
-- 1. Agregar campo ACTIVO (1 = Activo, 0 = Inactivo)
ALTER TABLE estudiantes 
ADD COLUMN activo TINYINT(1) NOT NULL DEFAULT 1;

-- 2. Agregar campo TIPO
ALTER TABLE estudiantes 
ADD COLUMN tipo VARCHAR(20) NOT NULL DEFAULT 'Pregrado';

-- 3. Agregar campo EMAIL
ALTER TABLE estudiantes 
ADD COLUMN email VARCHAR(100) UNIQUE;

-- Agregar restricción para validar que el correo tenga formato básico de email
ALTER TABLE estudiantes 
ADD CONSTRAINT chk_email CHECK (email LIKE '%@%.%');