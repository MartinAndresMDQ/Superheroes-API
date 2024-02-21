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
