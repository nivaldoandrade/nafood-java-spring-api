CREATE TABLE restaurant(
	id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(80) NOT NULL,
    fee DECIMAL(10,2) NOT NULL,
    active BOOLEAN NOT NULL,
    opened BOOLEAN NOT NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL,
    
    PRIMARY KEY (id)
)ENGINE=InnoDb DEFAULT CHARSET=utf8;
