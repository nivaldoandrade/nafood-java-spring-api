ALTER TABLE order_ ADD COLUMN payment_id bigint not null;

ALTER TABLE order_ ADD CONSTRAINT fk_payment_order
FOREIGN KEY (payment_id) REFERENCES payment (id);
