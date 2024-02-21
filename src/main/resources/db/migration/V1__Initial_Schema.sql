-- Eliminar tablas si existen
DROP table if exists superhero_powers;
DROP table if exists powers;
DROP table if exists superheroes;
DROP table if exists persons;

-- Eliminar el esquema si existe
DROP SCHEMA if exists SUPERHEROES_SCHEMA;

-- Crear el esquema
CREATE SCHEMA IF NOT EXISTS SUPERHEROES_SCHEMA;

-- Utilizar el esquema recién creado
USE SUPERHEROES_SCHEMA;

-- Crear la tabla para personas
CREATE TABLE persons (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

-- Crear la tabla para superhéroes que extiende de personas
CREATE TABLE superheroes (
    id BIGINT PRIMARY KEY,
    name_super VARCHAR(255),
    FOREIGN KEY (id) REFERENCES persons(id)
);

-- Crear la tabla para poderes
CREATE TABLE powers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

-- Crear la tabla de unión entre superhéroes y poderes
CREATE TABLE superhero_powers (
    superhero_id BIGINT,
    power_id BIGINT,
    PRIMARY KEY (superhero_id, power_id),
    FOREIGN KEY (superhero_id) REFERENCES superheroes(id),
    FOREIGN KEY (power_id) REFERENCES powers(id)
);
