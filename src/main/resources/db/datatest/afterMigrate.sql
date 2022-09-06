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

INSERT INTO restaurant(name, fee, active, opened, address_address, address_address2, address_number, address_district, city_id, cookery_id, created_at, updated_at) 
VALUES('Andrades Rest', 50.7, 1, 1, 'Rua Alagoas', 'Bar', '664', 'Centro', 1, 1, utc_timestamp, utc_timestamp);

INSERT INTO restaurant(name, fee, active, opened, address_address, address_number, address_district, city_id, cookery_id, created_at, updated_at) 
VALUES('Outback', 123.7, 1, 0, 'Alameda Terracota', '545 - 1079', 'Cerâmica',1 , 3, utc_timestamp, utc_timestamp);

INSERT INTO restaurant_payment(restaurant_id, payment_id) VALUES(1, 2), (2, 1), (1, 1), (2, 3);

INSERT INTO user(name, email, password) VALUES('Jonh Doe', 'johndoe@email.com', '123456');
INSERT INTO user(name, email, password) VALUES('Jonh Doe 2 ', 'johndoe2@email.com', '654321');

INSERT INTO order_(sub_total, fee, total_amount, status, payment_id, restaurant_id, user_id, address_address, address_address2, address_number, address_district, city_id, created_at)
VALUES(100, 35, 135, 'CRIADO', 1, 1, 2, 'Rua Alagoas', 'Bar', '664', 'Centro', 1, utc_timestamp);
INSERT INTO order_(sub_total, fee, total_amount, status, payment_id, restaurant_id, user_id, address_address, address_number, address_district, city_id, created_at)
VALUES(248, 34, 121, 'CRIADO', 1, 2, 1, 'Alameda Terracota', '545 - 1079', 'Cerâmica', 1, utc_timestamp);

INSERT INTO product(name, price, active, restaurant_id) VALUES('Parmegiana', 50.7, 1, 1);
INSERT INTO product(name, description, price, active, restaurant_id) VALUES('Beirute', 'Beirute de frango', 35.4, 0, 2);

INSERT INTO order_item(order_id, product_id, quantity, unit_price, total_price, observation) 
VALUES(1, 1, 4, 12.5, 50, 'Test observation');
INSERT INTO order_item(order_id, product_id, quantity, unit_price, total_price, observation) 
VALUES(2, 2, 4, 12.5, 50, 'Test observation 2');

INSERT INTO group_(name) VALUES('Administrators');
INSERT INTO group_(name) VALUES('Users');

INSERT INTO permission(name) VALUES('Admin');
INSERT INTO permission(name, description) VALUES('User', 'Default user');

INSERT INTO group_user(user_id, group_id) VALUES(1, 1);
INSERT INTO group_user(user_id, group_id) VALUES(2 ,2);

INSERT INTO group_permission(group_id, permission_id) VALUES(1, 1);
INSERT INTO group_permission(group_id, permission_id) VALUES(2, 2);






