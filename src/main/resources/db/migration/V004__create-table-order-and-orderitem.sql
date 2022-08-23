CREATE TABLE order_(
	id bigint not null auto_increment,
    sub_total decimal(10,2) not null,
    fee decimal(10,2) not null,
    total_amount decimal(10,2) not null,
    status varchar(20) not null,
    created_at datetime not null,
    confirmed_at datetime ,
    canceled_at datetime,
    finished_at datetime,
    
    primary key(id)
) engine=InnoDB default charset=utf8;

CREATE TABLE order_item(
	id bigint not null auto_increment,
    order_id bigint not null,
    quantity integer not null,
    unit_price decimal(10,2) not null,
    total_price decimal(10,2) not null,
    observation varchar(80),
    
    primary key(id)
) engine=InnoDB default charset=utf8;

ALTER TABLE order_item add constraint fk_order_orderitem
foreign key (order_id) references order_ (id);