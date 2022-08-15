INSERT INTO cookery(name) VALUES('Brasileira');
INSERT INTO cookery(name) VALUES('Italiana');
INSERT INTO cookery(name) VALUES('Mineira');

INSERT INTO restaurant(name, fee, cookery_id) VALUES('Outback', '111.90', 1);
INSERT INTO restaurant(name, fee, cookery_id) VALUES('Madero', '90.5', 2);
INSERT INTO restaurant(name, fee, cookery_id) VALUES('Bar do Peixe', '35', 3);
INSERT INTO restaurant(name, fee, cookery_id) VALUES('Andrades Restaurant', 0,  2);
INSERT INTO restaurant(name, fee, cookery_id) VALUES('Valderi', 0, 1);

INSERT INTO payment(description) VALUES('Cash');
INSERT INTO payment(description) VALUES('Debit cards');
INSERT INTO payment(description) VALUES('Credit cards');

INSERT INTO permission(description) VALUES('Admin');
INSERT INTO permission(description) VALUES('User');

INSERT INTO state(name) VALUES('São Paulo');
INSERT INTO state(name) VALUES('Rio de Janeiro');
INSERT INTO state(name) VALUES('Piauí');

INSERT INTO city(name, state_id) VALUES('São Caetano do Sul', 1);
INSERT INTO city(name, state_id) VALUES('Niterói', 2);

INSERT INTO restaurant_payment(restaurant_id, payment_id) VALUES(1, 2), (1, 3), (2, 1), (2, 3), (3, 1), (4, 3), (5, 1), (5, 2), (5, 3)

