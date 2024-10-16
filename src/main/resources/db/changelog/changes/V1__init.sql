CREATE TABLE tb_user (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255),
    phone_number VARCHAR(20),
    birth_date DATE,
    role VARCHAR(50)
);

CREATE TABLE tb_address (
    id SERIAL PRIMARY KEY,
    street VARCHAR(255),
    number VARCHAR(20),
    city VARCHAR(255),
    state VARCHAR(255),
    postal_code VARCHAR(20),
    country VARCHAR(255),
    user_id INTEGER,
    FOREIGN KEY (user_id) REFERENCES tb_user (id) ON DELETE CASCADE
);