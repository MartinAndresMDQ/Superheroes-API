USE SUPERHEROES_SCHEMA;
DROP table if exists superhero_powers;
DROP table if exists powers;
DROP table if exists superheroes;
DROP table if exists persons;
DROP SCHEMA if exists SUPERHEROES_SCHEMA;


-- Crear el esquema
CREATE SCHEMA IF NOT EXISTS SUPERHEROES_SCHEMA;

-- Utilizar el esquema recién creado
USE superheroes_schema;

-- Tabla para personas
CREATE TABLE persons (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

-- Tabla para superhéroes que extiende de personas
CREATE TABLE superheroes (
    id BIGINT PRIMARY KEY,
    name_super VARCHAR(255),
    FOREIGN KEY (id) REFERENCES persons(id)
);

-- Tabla para poderes
CREATE TABLE powers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

-- Tabla de unión entre superhéroes y poderes
CREATE TABLE superhero_powers (
    superhero_id BIGINT,
    power_id BIGINT,
    PRIMARY KEY (superhero_id, power_id),
    FOREIGN KEY (superhero_id) REFERENCES superheroes(id),
    FOREIGN KEY (power_id) REFERENCES powers(id)
);

-- Insertar datos en la tabla persons
INSERT INTO SUPERHEROES_SCHEMA.persons (name) VALUES ('Clark Kent');
INSERT INTO SUPERHEROES_SCHEMA.persons (name) VALUES ('Bruce Wayne');

-- Insertar datos en la tabla superheroes
INSERT INTO SUPERHEROES_SCHEMA.superheroes (id, name_super) VALUES (1, 'Superman');
INSERT INTO SUPERHEROES_SCHEMA.superheroes (id, name_super) VALUES (2, 'Batman');

-- Insertar datos en la tabla powers
INSERT INTO SUPERHEROES_SCHEMA.powers (name) VALUES ('Vuela');
INSERT INTO SUPERHEROES_SCHEMA.powers (name) VALUES ('Invencible');
INSERT INTO SUPERHEROES_SCHEMA.powers (name) VALUES ('Millonario');

-- Insertar datos en la tabla superhero_powers
INSERT INTO SUPERHEROES_SCHEMA.superhero_powers (superhero_id, power_id) VALUES (1, 1); -- Clark Kent tiene el poder de volar
INSERT INTO SUPERHEROES_SCHEMA.superhero_powers (superhero_id, power_id) VALUES (1, 2); -- Clark Kent tiene el poder de volar
INSERT INTO SUPERHEROES_SCHEMA.superhero_powers (superhero_id, power_id) VALUES (2, 3); -- Bruce Wayne tiene el poder de invisibilidad
