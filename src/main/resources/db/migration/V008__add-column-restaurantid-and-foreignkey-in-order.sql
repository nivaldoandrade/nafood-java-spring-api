ALTER TABLE order_ ADD COLUMN restaurant_id BIGINT NOT NULL;

ALTER TABLE order_ ADD CONSTRAINT fk_restaurant_order
FOREIGN KEY (restaurant_id) REFERENCES restaurant (id);