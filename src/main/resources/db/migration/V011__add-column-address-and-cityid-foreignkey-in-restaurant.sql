ALTER TABLE restaurant ADD COLUMN address_address VARCHAR(80) NOT NULL;
ALTER TABLE restaurant ADD COLUMN address_address2 VARCHAR(80);
ALTER TABLE restaurant ADD COLUMN address_number VARCHAR(20) NOT NULL;
ALTER TABLE restaurant ADD COLUMN address_district VARCHAR(40) NOT NULL;
ALTER TABLE restaurant ADD COLUMN city_id BIGINT NOT NULL;

ALTER TABLE restaurant ADD CONSTRAINT fk_city_restaurant
FOREIGN KEY (city_id) REFERENCES city (id);