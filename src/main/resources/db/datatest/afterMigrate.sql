set foreign_key_checks=0;

delete from city;
delete from state;
delete from cookery;
delete from order_;
delete from order_item;

set foreign_key_checks=1;

ALTER TABLE city auto_increment=1;
ALTER TABLE state auto_increment=1;
ALTER TABLE cookery auto_increment=1;
ALTER TABLE order_ auto_increment=1;
ALTER TABLE order_item auto_increment=1;

INSERT INTO cookery(name) VALUES('Brasileira');
INSERT INTO cookery(name) VALUES('Italiana');
INSERT INTO cookery(name) VALUES('Mineira');

INSERT INTO state(name) VALUES('São Paulo');
INSERT INTO state(name) VALUES('Rio de Janeiro');
INSERT INTO state(name) VALUES('Piauí');

INSERT INTO city(name, state_id) VALUES('São Caetano do Sul', 1);
INSERT INTO city(name, state_id) VALUES('Niterói', 2);

INSERT INTO order_(sub_total, fee, total_amount, status, created_at)
VALUES(100, 35, 135, 'CRIADO', utc_timestamp);

INSERT INTO order_item(order_id, quantity, unit_price, total_price, observation) 
VALUES(1, 4, 12.5, 50, 'Test observation');