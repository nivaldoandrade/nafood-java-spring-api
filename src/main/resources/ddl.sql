create table city (id bigint not null auto_increment, name varchar(255), state_id bigint, primary key (id)) engine=InnoDB;
create table cookery (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table group_ (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table group_permission (group_id bigint not null, permission_id bigint not null) engine=InnoDB;
create table payment (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB;
create table permission (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB;
create table product (id bigint not null auto_increment, active bit not null, description varchar(255), name varchar(255), price decimal(19,2), restaurant_id bigint, primary key (id)) engine=InnoDB;
create table restaurant (id bigint not null auto_increment, address_address varchar(255), address_address2 varchar(255), address_district varchar(255), address_number varchar(255), created_at datetime not null, fee decimal(19,2), name varchar(255), updated_at datetime not null, city_id bigint, cookery_id bigint, primary key (id)) engine=InnoDB;
create table restaurant_payment (restaurant_id bigint not null, payment_id bigint not null) engine=InnoDB;
create table state (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table user (id bigint not null auto_increment, created_at datetime not null, email varchar(255), name varchar(255), password varchar(255), primary key (id)) engine=InnoDB;
create table user_group (user_id bigint not null, group_id bigint not null) engine=InnoDB;
alter table city add constraint FK6p2u50v8fg2y0js6djc6xanit foreign key (state_id) references state (id);
alter table group_permission add constraint FKss14p30qbokhpkpdov4ha3wro foreign key (permission_id) references permission (id);
alter table group_permission add constraint FKfaw9e4t7wpfql8yhgxs8i4dl foreign key (group_id) references group_ (id);
alter table product add constraint FKp4b7e36gck7975p51raud8juk foreign key (restaurant_id) references restaurant (id);
alter table restaurant add constraint FKl968d8d7966yymvsxtdsni1vw foreign key (city_id) references city (id);
alter table restaurant add constraint FKlch220ylkt6j9gqobs684uxko foreign key (cookery_id) references cookery (id);
alter table restaurant_payment add constraint FK1orlck741hv6ova9t9a3hdhd5 foreign key (payment_id) references payment (id);
alter table restaurant_payment add constraint FK2g4321jti3ytjt2i6cesxg49x foreign key (restaurant_id) references restaurant (id);
alter table user_group add constraint FKfg5uskgw0vfhwtkknccotnc2h foreign key (group_id) references group_ (id);
alter table user_group add constraint FK1c1dsw3q36679vaiqwvtv36a6 foreign key (user_id) references user (id);
INSERT INTO cookery(name) VALUES('Brasileira');
INSERT INTO cookery(name) VALUES('Italiana');
INSERT INTO cookery(name) VALUES('Mineira');
INSERT INTO state(name) VALUES('São Paulo');
INSERT INTO state(name) VALUES('Rio de Janeiro');
INSERT INTO state(name) VALUES('Piauí');
INSERT INTO city(name, state_id) VALUES('São Caetano do Sul', 1);
INSERT INTO city(name, state_id) VALUES('Niterói', 2);
INSERT INTO restaurant(name, fee, cookery_id, created_at, updated_at, address_address, address_number, address_district, city_id) VALUES('Outback', '111.90', 1, utc_timestamp, utc_timestamp, 'Alameda Terracota', '545 - 1079', 'Cerâmica', 1);
INSERT INTO restaurant(name, fee, cookery_id, created_at, updated_at) VALUES('Madero', '90.5', 2, utc_timestamp, utc_timestamp);
INSERT INTO restaurant(name, fee, cookery_id, created_at, updated_at) VALUES('Bar do Peixe', '35', 3, utc_timestamp, utc_timestamp);
INSERT INTO restaurant(name, fee, cookery_id, created_at, updated_at) VALUES('Andrades Restaurant', 0,  2, utc_timestamp, utc_timestamp);
INSERT INTO restaurant(name, fee, cookery_id, created_at, updated_at) VALUES('Valderi', 0, 1, utc_timestamp, utc_timestamp);
INSERT INTO product(name, description, price, active, restaurant_id) VALUES('Parmegiana', 'Prato é deliciosa por si só, pois trata-se de filé empanado, recheado com presunto e mussarela', '119.00', true, 4);
INSERT INTO payment(description) VALUES('Cash');
INSERT INTO payment(description) VALUES('Debit cards');
INSERT INTO payment(description) VALUES('Credit cards');
INSERT INTO user(name, email, password, created_at) VALUES('Nivaldo Andrade', 'nivaldo.andrade@mail.com', '123', utc_timestamp);
INSERT INTO user(name, email, password, created_at) VALUES('Jonh Doe', 'john.doe@mail.com', '321', utc_timestamp);
INSERT INTO group_(name) VALUES('Administrators');
INSERT INTO group_(name) VALUES('Users');
INSERT INTO permission(description) VALUES('Admin');
INSERT INTO permission(description) VALUES('User');
INSERT INTO user_group(user_id, group_id) VALUES(1, 1);
INSERT INTO user_group(user_id, group_id) VALUES(2 ,2);
INSERT INTO group_permission(group_id, permission_id) VALUES(1, 1);
INSERT INTO group_permission(group_id, permission_id) VALUES(2, 2);
INSERT INTO restaurant_payment(restaurant_id, payment_id) VALUES(1, 2), (1, 3), (2, 1), (2, 3), (3, 1), (4, 3), (5, 1), (5, 2), (5, 3);
create table city (id bigint not null auto_increment, name varchar(255), state_id bigint, primary key (id)) engine=InnoDB;
create table cookery (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table group_ (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table group_permission (group_id bigint not null, permission_id bigint not null) engine=InnoDB;
create table payment (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB;
create table permission (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB;
create table product (id bigint not null auto_increment, active bit not null, description varchar(255), name varchar(255), price decimal(19,2), restaurant_id bigint, primary key (id)) engine=InnoDB;
create table restaurant (id bigint not null auto_increment, address_address varchar(255), address_address2 varchar(255), address_district varchar(255), address_number varchar(255), created_at datetime not null, fee decimal(19,2), name varchar(255), updated_at datetime not null, city_id bigint, cookery_id bigint, primary key (id)) engine=InnoDB;
create table restaurant_payment (restaurant_id bigint not null, payment_id bigint not null) engine=InnoDB;
create table state (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table user (id bigint not null auto_increment, created_at datetime not null, email varchar(255), name varchar(255), password varchar(255), primary key (id)) engine=InnoDB;
create table user_group (user_id bigint not null, group_id bigint not null) engine=InnoDB;
alter table city add constraint FK6p2u50v8fg2y0js6djc6xanit foreign key (state_id) references state (id);
alter table group_permission add constraint FKss14p30qbokhpkpdov4ha3wro foreign key (permission_id) references permission (id);
alter table group_permission add constraint FKfaw9e4t7wpfql8yhgxs8i4dl foreign key (group_id) references group_ (id);
alter table product add constraint FKp4b7e36gck7975p51raud8juk foreign key (restaurant_id) references restaurant (id);
alter table restaurant add constraint FKl968d8d7966yymvsxtdsni1vw foreign key (city_id) references city (id);
alter table restaurant add constraint FKlch220ylkt6j9gqobs684uxko foreign key (cookery_id) references cookery (id);
alter table restaurant_payment add constraint FK1orlck741hv6ova9t9a3hdhd5 foreign key (payment_id) references payment (id);
alter table restaurant_payment add constraint FK2g4321jti3ytjt2i6cesxg49x foreign key (restaurant_id) references restaurant (id);
alter table user_group add constraint FKfg5uskgw0vfhwtkknccotnc2h foreign key (group_id) references group_ (id);
alter table user_group add constraint FK1c1dsw3q36679vaiqwvtv36a6 foreign key (user_id) references user (id);
INSERT INTO cookery(name) VALUES('Brasileira');
INSERT INTO cookery(name) VALUES('Italiana');
INSERT INTO cookery(name) VALUES('Mineira');
INSERT INTO state(name) VALUES('São Paulo');
INSERT INTO state(name) VALUES('Rio de Janeiro');
INSERT INTO state(name) VALUES('Piauí');
INSERT INTO city(name, state_id) VALUES('São Caetano do Sul', 1);
INSERT INTO city(name, state_id) VALUES('Niterói', 2);
INSERT INTO restaurant(name, fee, cookery_id, created_at, updated_at, address_address, address_number, address_district, city_id) VALUES('Outback', '111.90', 1, utc_timestamp, utc_timestamp, 'Alameda Terracota', '545 - 1079', 'Cerâmica', 1);
INSERT INTO restaurant(name, fee, cookery_id, created_at, updated_at) VALUES('Madero', '90.5', 2, utc_timestamp, utc_timestamp);
INSERT INTO restaurant(name, fee, cookery_id, created_at, updated_at) VALUES('Bar do Peixe', '35', 3, utc_timestamp, utc_timestamp);
INSERT INTO restaurant(name, fee, cookery_id, created_at, updated_at) VALUES('Andrades Restaurant', 0,  2, utc_timestamp, utc_timestamp);
INSERT INTO restaurant(name, fee, cookery_id, created_at, updated_at) VALUES('Valderi', 0, 1, utc_timestamp, utc_timestamp);
INSERT INTO product(name, description, price, active, restaurant_id) VALUES('Parmegiana', 'Prato é deliciosa por si só, pois trata-se de filé empanado, recheado com presunto e mussarela', '119.00', true, 4);
INSERT INTO payment(description) VALUES('Cash');
INSERT INTO payment(description) VALUES('Debit cards');
INSERT INTO payment(description) VALUES('Credit cards');
INSERT INTO user(name, email, password, created_at) VALUES('Nivaldo Andrade', 'nivaldo.andrade@mail.com', '123', utc_timestamp);
INSERT INTO user(name, email, password, created_at) VALUES('Jonh Doe', 'john.doe@mail.com', '321', utc_timestamp);
INSERT INTO group_(name) VALUES('Administrators');
INSERT INTO group_(name) VALUES('Users');
INSERT INTO permission(description) VALUES('Admin');
INSERT INTO permission(description) VALUES('User');
INSERT INTO user_group(user_id, group_id) VALUES(1, 1);
INSERT INTO user_group(user_id, group_id) VALUES(2 ,2);
INSERT INTO group_permission(group_id, permission_id) VALUES(1, 1);
INSERT INTO group_permission(group_id, permission_id) VALUES(2, 2);
INSERT INTO restaurant_payment(restaurant_id, payment_id) VALUES(1, 2), (1, 3), (2, 1), (2, 3), (3, 1), (4, 3), (5, 1), (5, 2), (5, 3);
create table city (id bigint not null auto_increment, name varchar(255), state_id bigint, primary key (id)) engine=InnoDB;
create table cookery (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table group_ (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table group_permission (group_id bigint not null, permission_id bigint not null) engine=InnoDB;
create table payment (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB;
create table permission (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB;
create table product (id bigint not null auto_increment, active bit not null, description varchar(255), name varchar(255), price decimal(19,2), restaurant_id bigint, primary key (id)) engine=InnoDB;
create table restaurant (id bigint not null auto_increment, address_address varchar(255), address_address2 varchar(255), address_district varchar(255), address_number varchar(255), created_at datetime not null, fee decimal(19,2), name varchar(255), updated_at datetime not null, city_id bigint, cookery_id bigint, primary key (id)) engine=InnoDB;
create table restaurant_payment (restaurant_id bigint not null, payment_id bigint not null) engine=InnoDB;
create table state (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table user (id bigint not null auto_increment, created_at datetime not null, email varchar(255), name varchar(255), password varchar(255), primary key (id)) engine=InnoDB;
create table user_group (user_id bigint not null, group_id bigint not null) engine=InnoDB;
alter table city add constraint FK6p2u50v8fg2y0js6djc6xanit foreign key (state_id) references state (id);
alter table group_permission add constraint FKss14p30qbokhpkpdov4ha3wro foreign key (permission_id) references permission (id);
alter table group_permission add constraint FKfaw9e4t7wpfql8yhgxs8i4dl foreign key (group_id) references group_ (id);
alter table product add constraint FKp4b7e36gck7975p51raud8juk foreign key (restaurant_id) references restaurant (id);
alter table restaurant add constraint FKl968d8d7966yymvsxtdsni1vw foreign key (city_id) references city (id);
alter table restaurant add constraint FKlch220ylkt6j9gqobs684uxko foreign key (cookery_id) references cookery (id);
alter table restaurant_payment add constraint FK1orlck741hv6ova9t9a3hdhd5 foreign key (payment_id) references payment (id);
alter table restaurant_payment add constraint FK2g4321jti3ytjt2i6cesxg49x foreign key (restaurant_id) references restaurant (id);
alter table user_group add constraint FKfg5uskgw0vfhwtkknccotnc2h foreign key (group_id) references group_ (id);
alter table user_group add constraint FK1c1dsw3q36679vaiqwvtv36a6 foreign key (user_id) references user (id);
INSERT INTO cookery(name) VALUES('Brasileira');
INSERT INTO cookery(name) VALUES('Italiana');
INSERT INTO cookery(name) VALUES('Mineira');
INSERT INTO state(name) VALUES('São Paulo');
INSERT INTO state(name) VALUES('Rio de Janeiro');
INSERT INTO state(name) VALUES('Piauí');
INSERT INTO city(name, state_id) VALUES('São Caetano do Sul', 1);
INSERT INTO city(name, state_id) VALUES('Niterói', 2);
INSERT INTO restaurant(name, fee, cookery_id, created_at, updated_at, address_address, address_number, address_district, city_id) VALUES('Outback', '111.90', 1, utc_timestamp, utc_timestamp, 'Alameda Terracota', '545 - 1079', 'Cerâmica', 1);
INSERT INTO restaurant(name, fee, cookery_id, created_at, updated_at) VALUES('Madero', '90.5', 2, utc_timestamp, utc_timestamp);
INSERT INTO restaurant(name, fee, cookery_id, created_at, updated_at) VALUES('Bar do Peixe', '35', 3, utc_timestamp, utc_timestamp);
INSERT INTO restaurant(name, fee, cookery_id, created_at, updated_at) VALUES('Andrades Restaurant', 0,  2, utc_timestamp, utc_timestamp);
INSERT INTO restaurant(name, fee, cookery_id, created_at, updated_at) VALUES('Valderi', 0, 1, utc_timestamp, utc_timestamp);
INSERT INTO product(name, description, price, active, restaurant_id) VALUES('Parmegiana', 'Prato é deliciosa por si só, pois trata-se de filé empanado, recheado com presunto e mussarela', '119.00', true, 4);
INSERT INTO payment(description) VALUES('Cash');
INSERT INTO payment(description) VALUES('Debit cards');
INSERT INTO payment(description) VALUES('Credit cards');
INSERT INTO user(name, email, password, created_at) VALUES('Nivaldo Andrade', 'nivaldo.andrade@mail.com', '123', utc_timestamp);
INSERT INTO user(name, email, password, created_at) VALUES('Jonh Doe', 'john.doe@mail.com', '321', utc_timestamp);
INSERT INTO group_(name) VALUES('Administrators');
INSERT INTO group_(name) VALUES('Users');
INSERT INTO permission(description) VALUES('Admin');
INSERT INTO permission(description) VALUES('User');
INSERT INTO user_group(user_id, group_id) VALUES(1, 1);
INSERT INTO user_group(user_id, group_id) VALUES(2 ,2);
INSERT INTO group_permission(group_id, permission_id) VALUES(1, 1);
INSERT INTO group_permission(group_id, permission_id) VALUES(2, 2);
INSERT INTO restaurant_payment(restaurant_id, payment_id) VALUES(1, 2), (1, 3), (2, 1), (2, 3), (3, 1), (4, 3), (5, 1), (5, 2), (5, 3);
create table city (id bigint not null auto_increment, name varchar(255), state_id bigint, primary key (id)) engine=InnoDB;
create table cookery (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table group_ (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table group_permission (group_id bigint not null, permission_id bigint not null) engine=InnoDB;
create table payment (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB;
create table permission (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB;
create table product (id bigint not null auto_increment, active bit not null, description varchar(255), name varchar(255), price decimal(19,2), restaurant_id bigint, primary key (id)) engine=InnoDB;
create table restaurant (id bigint not null auto_increment, address_address varchar(255), address_address2 varchar(255), address_district varchar(255), address_number varchar(255), created_at datetime not null, fee decimal(19,2), name varchar(255), updated_at datetime not null, city_id bigint, cookery_id bigint, primary key (id)) engine=InnoDB;
create table restaurant_payment (restaurant_id bigint not null, payment_id bigint not null) engine=InnoDB;
create table state (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table user (id bigint not null auto_increment, created_at datetime not null, email varchar(255), name varchar(255), password varchar(255), primary key (id)) engine=InnoDB;
create table user_group (user_id bigint not null, group_id bigint not null) engine=InnoDB;
alter table city add constraint FK6p2u50v8fg2y0js6djc6xanit foreign key (state_id) references state (id);
alter table group_permission add constraint FKss14p30qbokhpkpdov4ha3wro foreign key (permission_id) references permission (id);
alter table group_permission add constraint FKfaw9e4t7wpfql8yhgxs8i4dl foreign key (group_id) references group_ (id);
alter table product add constraint FKp4b7e36gck7975p51raud8juk foreign key (restaurant_id) references restaurant (id);
alter table restaurant add constraint FKl968d8d7966yymvsxtdsni1vw foreign key (city_id) references city (id);
alter table restaurant add constraint FKlch220ylkt6j9gqobs684uxko foreign key (cookery_id) references cookery (id);
alter table restaurant_payment add constraint FK1orlck741hv6ova9t9a3hdhd5 foreign key (payment_id) references payment (id);
alter table restaurant_payment add constraint FK2g4321jti3ytjt2i6cesxg49x foreign key (restaurant_id) references restaurant (id);
alter table user_group add constraint FKfg5uskgw0vfhwtkknccotnc2h foreign key (group_id) references group_ (id);
alter table user_group add constraint FK1c1dsw3q36679vaiqwvtv36a6 foreign key (user_id) references user (id);
INSERT INTO cookery(name) VALUES('Brasileira');
INSERT INTO cookery(name) VALUES('Italiana');
INSERT INTO cookery(name) VALUES('Mineira');
INSERT INTO state(name) VALUES('São Paulo');
INSERT INTO state(name) VALUES('Rio de Janeiro');
INSERT INTO state(name) VALUES('Piauí');
INSERT INTO city(name, state_id) VALUES('São Caetano do Sul', 1);
INSERT INTO city(name, state_id) VALUES('Niterói', 2);
INSERT INTO restaurant(name, fee, cookery_id, created_at, updated_at, address_address, address_number, address_district, city_id) VALUES('Outback', '111.90', 1, utc_timestamp, utc_timestamp, 'Alameda Terracota', '545 - 1079', 'Cerâmica', 1);
INSERT INTO restaurant(name, fee, cookery_id, created_at, updated_at) VALUES('Madero', '90.5', 2, utc_timestamp, utc_timestamp);
INSERT INTO restaurant(name, fee, cookery_id, created_at, updated_at) VALUES('Bar do Peixe', '35', 3, utc_timestamp, utc_timestamp);
INSERT INTO restaurant(name, fee, cookery_id, created_at, updated_at) VALUES('Andrades Restaurant', 0,  2, utc_timestamp, utc_timestamp);
INSERT INTO restaurant(name, fee, cookery_id, created_at, updated_at) VALUES('Valderi', 0, 1, utc_timestamp, utc_timestamp);
INSERT INTO product(name, description, price, active, restaurant_id) VALUES('Parmegiana', 'Prato é deliciosa por si só, pois trata-se de filé empanado, recheado com presunto e mussarela', '119.00', true, 4);
INSERT INTO payment(description) VALUES('Cash');
INSERT INTO payment(description) VALUES('Debit cards');
INSERT INTO payment(description) VALUES('Credit cards');
INSERT INTO user(name, email, password, created_at) VALUES('Nivaldo Andrade', 'nivaldo.andrade@mail.com', '123', utc_timestamp);
INSERT INTO user(name, email, password, created_at) VALUES('Jonh Doe', 'john.doe@mail.com', '321', utc_timestamp);
INSERT INTO group_(name) VALUES('Administrators');
INSERT INTO group_(name) VALUES('Users');
INSERT INTO permission(description) VALUES('Admin');
INSERT INTO permission(description) VALUES('User');
INSERT INTO user_group(user_id, group_id) VALUES(1, 1);
INSERT INTO user_group(user_id, group_id) VALUES(2 ,2);
INSERT INTO group_permission(group_id, permission_id) VALUES(1, 1);
INSERT INTO group_permission(group_id, permission_id) VALUES(2, 2);
INSERT INTO restaurant_payment(restaurant_id, payment_id) VALUES(1, 2), (1, 3), (2, 1), (2, 3), (3, 1), (4, 3), (5, 1), (5, 2), (5, 3);
create table city (id bigint not null auto_increment, name varchar(255), state_id bigint, primary key (id)) engine=InnoDB;
create table cookery (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table group_ (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table group_permission (group_id bigint not null, permission_id bigint not null) engine=InnoDB;
create table payment (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB;
create table permission (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB;
create table product (id bigint not null auto_increment, active bit not null, description varchar(255), name varchar(255), price decimal(19,2), restaurant_id bigint, primary key (id)) engine=InnoDB;
create table restaurant (id bigint not null auto_increment, address_address varchar(255), address_address2 varchar(255), address_district varchar(255), address_number varchar(255), created_at datetime not null, fee decimal(19,2), name varchar(255), updated_at datetime not null, city_id bigint, cookery_id bigint, primary key (id)) engine=InnoDB;
create table restaurant_payment (restaurant_id bigint not null, payment_id bigint not null) engine=InnoDB;
create table state (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table user (id bigint not null auto_increment, created_at datetime not null, email varchar(255), name varchar(255), password varchar(255), primary key (id)) engine=InnoDB;
create table user_group (user_id bigint not null, group_id bigint not null) engine=InnoDB;
alter table city add constraint FK6p2u50v8fg2y0js6djc6xanit foreign key (state_id) references state (id);
alter table group_permission add constraint FKss14p30qbokhpkpdov4ha3wro foreign key (permission_id) references permission (id);
alter table group_permission add constraint FKfaw9e4t7wpfql8yhgxs8i4dl foreign key (group_id) references group_ (id);
alter table product add constraint FKp4b7e36gck7975p51raud8juk foreign key (restaurant_id) references restaurant (id);
alter table restaurant add constraint FKl968d8d7966yymvsxtdsni1vw foreign key (city_id) references city (id);
alter table restaurant add constraint FKlch220ylkt6j9gqobs684uxko foreign key (cookery_id) references cookery (id);
alter table restaurant_payment add constraint FK1orlck741hv6ova9t9a3hdhd5 foreign key (payment_id) references payment (id);
alter table restaurant_payment add constraint FK2g4321jti3ytjt2i6cesxg49x foreign key (restaurant_id) references restaurant (id);
alter table user_group add constraint FKfg5uskgw0vfhwtkknccotnc2h foreign key (group_id) references group_ (id);
alter table user_group add constraint FK1c1dsw3q36679vaiqwvtv36a6 foreign key (user_id) references user (id);
INSERT INTO cookery(name) VALUES('Brasileira');
INSERT INTO cookery(name) VALUES('Italiana');
INSERT INTO cookery(name) VALUES('Mineira');
INSERT INTO state(name) VALUES('São Paulo');
INSERT INTO state(name) VALUES('Rio de Janeiro');
INSERT INTO state(name) VALUES('Piauí');
INSERT INTO city(name, state_id) VALUES('São Caetano do Sul', 1);
INSERT INTO city(name, state_id) VALUES('Niterói', 2);
INSERT INTO restaurant(name, fee, cookery_id, created_at, updated_at, address_address, address_number, address_district, city_id) VALUES('Outback', '111.90', 1, utc_timestamp, utc_timestamp, 'Alameda Terracota', '545 - 1079', 'Cerâmica', 1);
INSERT INTO restaurant(name, fee, cookery_id, created_at, updated_at) VALUES('Madero', '90.5', 2, utc_timestamp, utc_timestamp);
INSERT INTO restaurant(name, fee, cookery_id, created_at, updated_at) VALUES('Bar do Peixe', '35', 3, utc_timestamp, utc_timestamp);
INSERT INTO restaurant(name, fee, cookery_id, created_at, updated_at) VALUES('Andrades Restaurant', 0,  2, utc_timestamp, utc_timestamp);
INSERT INTO restaurant(name, fee, cookery_id, created_at, updated_at) VALUES('Valderi', 0, 1, utc_timestamp, utc_timestamp);
INSERT INTO product(name, description, price, active, restaurant_id) VALUES('Parmegiana', 'Prato é deliciosa por si só, pois trata-se de filé empanado, recheado com presunto e mussarela', '119.00', true, 4);
INSERT INTO payment(description) VALUES('Cash');
INSERT INTO payment(description) VALUES('Debit cards');
INSERT INTO payment(description) VALUES('Credit cards');
INSERT INTO user(name, email, password, created_at) VALUES('Nivaldo Andrade', 'nivaldo.andrade@mail.com', '123', utc_timestamp);
INSERT INTO user(name, email, password, created_at) VALUES('Jonh Doe', 'john.doe@mail.com', '321', utc_timestamp);
INSERT INTO group_(name) VALUES('Administrators');
INSERT INTO group_(name) VALUES('Users');
INSERT INTO permission(description) VALUES('Admin');
INSERT INTO permission(description) VALUES('User');
INSERT INTO user_group(user_id, group_id) VALUES(1, 1);
INSERT INTO user_group(user_id, group_id) VALUES(2 ,2);
INSERT INTO group_permission(group_id, permission_id) VALUES(1, 1);
INSERT INTO group_permission(group_id, permission_id) VALUES(2, 2);
INSERT INTO restaurant_payment(restaurant_id, payment_id) VALUES(1, 2), (1, 3), (2, 1), (2, 3), (3, 1), (4, 3), (5, 1), (5, 2), (5, 3);
