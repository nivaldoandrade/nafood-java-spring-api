ALTER TABLE restaurant ADD COLUMN cookery_id BIGINT NOT NULL;

ALTER TABLE restaurant ADD CONSTRAINT fk_cookery_restaurant
FOREIGN KEY (cookery_id) REFERENCES cookery (id);