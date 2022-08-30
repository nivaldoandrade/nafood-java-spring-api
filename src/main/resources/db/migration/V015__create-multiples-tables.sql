CREATE TABLE product(
	id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(80) NOT NULL,
    description TEXT ,
    price DECIMAL(10,2) NOT NULL,
    active BOOLEAN NOT NULL,

	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE group_(
	id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(80)  NOT NULL,
    
    PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permission(
	id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(80) NOT NULL,
    description TEXT,
    
    PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE group_permission(
	group_id BIGINT NOT NULL,
    permission_id BIGINT NOT NULL
    
)ENGINE=InnoDB DEFAULT CHARSET=utf8; 

CREATE TABLE group_user(
	group_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL
    
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE group_user ADD CONSTRAINT fk_user_group_user
FOREIGN KEY (user_id) REFERENCES user (id);

ALTER TABLE group_user ADD CONSTRAINT fk_group_group_user
FOREIGN KEY (group_id) REFERENCES group_ (id);

ALTER TABLE group_permission ADD CONSTRAINT fk_group_group_permission
FOREIGN KEY (group_id) REFERENCES group_ (id);

ALTER TABLE group_permission ADD CONSTRAINT fk_permission_group_permission
FOREIGN KEY (permission_id) REFERENCES permission (id);

ALTER TABLE product ADD COLUMN restaurant_id BIGINT NOT NULL;

ALTER TABLE product ADD CONSTRAINT fk_restaurant_product
FOREIGN KEY (restaurant_id) REFERENCES restaurant (id);

ALTER TABLE order_item ADD COLUMN product_id BIGINT NOT NULL;

ALTER TABLE order_item ADD CONSTRAINT fk_product_order_item
FOREIGN KEY (product_id) REFERENCES product (id);