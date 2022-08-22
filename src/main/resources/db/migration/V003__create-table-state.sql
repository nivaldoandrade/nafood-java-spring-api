CREATE TABLE state(
	id bigint not null auto_increment,
    name varchar(80) not null,
    
    primary key(id)
) engine=InnoDB default charset=utf8;

INSERT INTO state(name) select distinct name_state from city;

ALTER TABLE city add column state_id bigint not null;

UPDATE city c SET c.state_id = (SELECT s.id FROM state s WHERE c.name_state = s.name);

ALTER TABLE city add constraint fk_city_state
foreign key (state_id) references state (id);

ALTER TABLE city drop column name_state;

ALTER TABLE city change name_city name varchar(80) not null;