set foreign_key_checks=0;

delete from city;
delete from state;
delete from cookery;

set foreign_key_checks=1;

ALTER TABLE city auto_increment=1;
ALTER TABLE state auto_increment=1;
ALTER TABLE cookery auto_increment=1;

INSERT INTO cookery(name) VALUES('Brasileira');
INSERT INTO cookery(name) VALUES('Italiana');
INSERT INTO cookery(name) VALUES('Mineira');

INSERT INTO state(name) VALUES('São Paulo');
INSERT INTO state(name) VALUES('Rio de Janeiro');
INSERT INTO state(name) VALUES('Piauí');

INSERT INTO city(name, state_id) VALUES('São Caetano do Sul', 1);
INSERT INTO city(name, state_id) VALUES('Niterói', 2);
