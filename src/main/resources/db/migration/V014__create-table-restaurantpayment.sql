CREATE TABLE restaurant_payment(
    restaurant_id BIGINT NOT NULL,
    payment_id BIGINT NOT NULL
    
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE restaurant_payment ADD CONSTRAINT fk_restaurant_rest_pay
FOREIGN KEY (restaurant_id) REFERENCES restaurant (id);

ALTER TABLE restaurant_payment ADD CONSTRAINT fk_payment_rest_pay
FOREIGN KEY (payment_id) REFERENCES payment (id);