set foreign_key_checks=0;

delete from city;
delete from state;
delete from cookery;
delete from order_;
delete from order_item;
delete from payment;
delete from restaurant;
delete from user;
delete from restaurant_payment;

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
ALTER TABLE restaurant_payment auto_increment=1;