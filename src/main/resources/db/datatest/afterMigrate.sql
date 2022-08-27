set foreign_key_checks=0;

delete from city;
delete from state;
delete from cookery;
delete from order_;
delete from order_item;
delete from payment;
delete from restaurant;
delete from user;

set foreign_key_checks=1;

ALTER TABLE city auto_increment=1;
ALTER TABLE state auto_increment=1;
ALTER TABLE cookery auto_increment=1;
ALTER TABLE order_ auto_increment=1;
ALTER TABLE order_item auto_increment=1;
ALTER TABLE order_item auto_increment=1;
ALTER TABLE payment auto_increment=1;
ALTER TABLE restaurant auto_increment=1;
ALTER TABLE user auto_increment=1;

INSERT INTO cookery(name) VALUES('Brasileira');
INSERT INTO cookery(name) VALUES('Italiana');
INSERT INTO cookery(name) VALUES('Mineira');

INSERT INTO state(name) VALUES('São Paulo');
INSERT INTO state(name) VALUES('Rio de Janeiro');
INSERT INTO state(name) VALUES('Piauí');

INSERT INTO city(name, state_id) VALUES('São Caetano do Sul', 1);
INSERT INTO city(name, state_id) VALUES('Niterói', 2);

INSERT INTO payment(description) VALUES('Cash');
INSERT INTO payment(description) VALUES('Debit cards');
INSERT INTO payment(description) VALUES('Credit cards');

INSERT INTO restaurant(name, fee, active, opened, created_at, updated_at) VALUES('Andrades Rest', 50.7, 1, 1, utc_timestamp, utc_timestamp);
INSERT INTO restaurant(name, fee, active, opened, created_at, updated_at) VALUES('Outback', 123.7, 1, 0, utc_timestamp, utc_timestamp);

INSERT INTO user(name, email, password) VALUES('Jonh Doe', 'johndoe@email.com', '123456');
INSERT INTO user(name, email, password) VALUES('Jonh Doe 2 ', 'johndoe2@email.com', '654321');

INSERT INTO order_(sub_total, fee, total_amount, status, payment_id, restaurant_id, user_id, created_at)
VALUES(100, 35, 135, 'CRIADO', 1, 1, 2, utc_timestamp);
INSERT INTO order_(sub_total, fee, total_amount, status, payment_id, restaurant_id, user_id, created_at)
VALUES(248, 34, 121, 'CRIADO', 1, 2, 1, utc_timestamp);

INSERT INTO order_item(order_id, quantity, unit_price, total_price, observation) 
VALUES(1, 4, 12.5, 50, 'Test observation');
INSERT INTO order_item(order_id, quantity, unit_price, total_price, observation) 
VALUES(2, 4, 12.5, 50, 'Test observation 2');

