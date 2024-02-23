-- Insertar datos en la tabla persons
INSERT INTO SUPERHEROES_SCHEMA.persons (name) VALUES ('Clark Kent');
INSERT INTO SUPERHEROES_SCHEMA.persons (name) VALUES ('Bruce Wayne');
INSERT INTO SUPERHEROES_SCHEMA.persons (name) VALUES ('Peter Parker');
INSERT INTO SUPERHEROES_SCHEMA.persons (name) VALUES ('Diana Prince');
INSERT INTO SUPERHEROES_SCHEMA.persons (name) VALUES ('Barry Allen');
INSERT INTO SUPERHEROES_SCHEMA.persons (name) VALUES ('Tony Stark');
INSERT INTO SUPERHEROES_SCHEMA.persons (name) VALUES ('Carol Danvers');
INSERT INTO SUPERHEROES_SCHEMA.persons (name) VALUES ('Arthur Curry');
INSERT INTO SUPERHEROES_SCHEMA.persons (name) VALUES ('Wanda Maximoff');
INSERT INTO SUPERHEROES_SCHEMA.persons (name) VALUES ('Natasha Romanoff');

-- Insertar datos en la tabla superheroes
INSERT INTO SUPERHEROES_SCHEMA.superheroes (id, name_super) VALUES (1, 'Superman');
INSERT INTO SUPERHEROES_SCHEMA.superheroes (id, name_super) VALUES (2, 'Batman');
INSERT INTO SUPERHEROES_SCHEMA.superheroes (id, name_super) VALUES (3, 'Spiderman');
INSERT INTO SUPERHEROES_SCHEMA.superheroes (id, name_super) VALUES (4, 'Wonder Woman');
INSERT INTO SUPERHEROES_SCHEMA.superheroes (id, name_super) VALUES (5, 'Flash');
INSERT INTO SUPERHEROES_SCHEMA.superheroes (id, name_super) VALUES (6, 'Iron Man');
INSERT INTO SUPERHEROES_SCHEMA.superheroes (id, name_super) VALUES (7, 'Captain Marvel');
INSERT INTO SUPERHEROES_SCHEMA.superheroes (id, name_super) VALUES (8, 'Aquaman');
INSERT INTO SUPERHEROES_SCHEMA.superheroes (id, name_super) VALUES (9, 'Scarlet Witch');
INSERT INTO SUPERHEROES_SCHEMA.superheroes (id, name_super) VALUES (10, 'Black Widow');


-- Insertar datos en la tabla powers
INSERT INTO SUPERHEROES_SCHEMA.powers (name) VALUES ('Vuela');
INSERT INTO SUPERHEROES_SCHEMA.powers (name) VALUES ('Invencible');
INSERT INTO SUPERHEROES_SCHEMA.powers (name) VALUES ('Millonario');
INSERT INTO SUPERHEROES_SCHEMA.powers (name) VALUES ('Telaraña');
INSERT INTO SUPERHEROES_SCHEMA.powers (name) VALUES ('Fuerza sobrehumana');
INSERT INTO SUPERHEROES_SCHEMA.powers (name) VALUES ('Sigilo');
INSERT INTO SUPERHEROES_SCHEMA.powers (name) VALUES ('Vuelo');
INSERT INTO SUPERHEROES_SCHEMA.powers (name) VALUES ('Velocidad sobrehumana');
INSERT INTO SUPERHEROES_SCHEMA.powers (name) VALUES ('Inteligencia sobrehumana');
INSERT INTO SUPERHEROES_SCHEMA.powers (name) VALUES ('Control de la tecnología');

INSERT INTO SUPERHEROES_SCHEMA.powers (name) VALUES ('Fuerza cósmica');
INSERT INTO SUPERHEROES_SCHEMA.powers (name) VALUES ('Hidroquinesis');
INSERT INTO SUPERHEROES_SCHEMA.powers (name) VALUES ('Manipulación de la realidad');
INSERT INTO SUPERHEROES_SCHEMA.powers (name) VALUES ('Regeneración');
INSERT INTO SUPERHEROES_SCHEMA.powers (name) VALUES ('Espionaje');
INSERT INTO SUPERHEROES_SCHEMA.powers (name) VALUES ('Combate cuerpo a cuerpo');


-- Insertar datos en la tabla superhero_powers
INSERT INTO SUPERHEROES_SCHEMA.superhero_powers (superhero_id, power_id) VALUES (1, 1); -- Clark Kent tiene el poder de volar
INSERT INTO SUPERHEROES_SCHEMA.superhero_powers (superhero_id, power_id) VALUES (1, 2); -- Clark Kent tiene el poder de Invencible
INSERT INTO SUPERHEROES_SCHEMA.superhero_powers (superhero_id, power_id) VALUES (2, 3); -- Bruce Wayne tiene el poder de ser Millonario
INSERT INTO SUPERHEROES_SCHEMA.superhero_powers (superhero_id, power_id) VALUES (3, 4); -- Spiderman tiene el poder de telaraña
INSERT INTO SUPERHEROES_SCHEMA.superhero_powers (superhero_id, power_id) VALUES (3, 5); -- Spiderman tiene el poder de fuerza sobrehumana
INSERT INTO SUPERHEROES_SCHEMA.superhero_powers (superhero_id, power_id) VALUES (3, 6); -- Spiderman tiene el poder del Sigilo
INSERT INTO SUPERHEROES_SCHEMA.superhero_powers (superhero_id, power_id) VALUES (4, 7); -- Wonder Woman tiene el poder de vuelo
INSERT INTO SUPERHEROES_SCHEMA.superhero_powers (superhero_id, power_id) VALUES (4, 8); -- Wonder Woman tiene el poder de velocidad sobrehumana
INSERT INTO SUPERHEROES_SCHEMA.superhero_powers (superhero_id, power_id) VALUES (5, 8); -- Flash tiene el poder de velocidad sobrehumana
INSERT INTO SUPERHEROES_SCHEMA.superhero_powers (superhero_id, power_id) VALUES (5, 6); -- Flash tiene el poder de sigilo
INSERT INTO SUPERHEROES_SCHEMA.superhero_powers (superhero_id, power_id) VALUES (6, 9); -- Iron Man tiene el poder de inteligencia sobrehumana
INSERT INTO SUPERHEROES_SCHEMA.superhero_powers (superhero_id, power_id) VALUES (6, 10); -- Iron Man tiene el poder de control de la tecnología
INSERT INTO SUPERHEROES_SCHEMA.superhero_powers (superhero_id, power_id) VALUES (7, 9); -- Captain Marvel tiene el poder de inteligencia sobrehumana
INSERT INTO SUPERHEROES_SCHEMA.superhero_powers (superhero_id, power_id) VALUES (7, 11); -- Captain Marvel tiene el poder de fuerza cósmica
INSERT INTO SUPERHEROES_SCHEMA.superhero_powers (superhero_id, power_id) VALUES (8, 12); -- Aquaman tiene el poder de hidroquinesis
INSERT INTO SUPERHEROES_SCHEMA.superhero_powers (superhero_id, power_id) VALUES (9, 13); -- Scarlet Witch tiene el poder de manipulación de la realidad
INSERT INTO SUPERHEROES_SCHEMA.superhero_powers (superhero_id, power_id) VALUES (10, 14); -- Black Widow tiene el poder de regeneración
INSERT INTO SUPERHEROES_SCHEMA.superhero_powers (superhero_id, power_id) VALUES (10, 15); -- Black Widow tiene el poder de espionaje
INSERT INTO SUPERHEROES_SCHEMA.superhero_powers (superhero_id, power_id) VALUES (10, 16); -- Black Widow tiene el poder de combate cuerpo a cuerpo