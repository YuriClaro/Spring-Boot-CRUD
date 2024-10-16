INSERT INTO tb_user (username, password, first_name, last_name, email, phone_number, birth_date, role) VALUES
('joao_souza', 'password123', 'João', 'Souza', 'joao.souza@gmail.com', '123-456-7890', '1990-05-15', 'USER'),
('maria_guilherme', 'password456', 'Maria', 'Guilherme', 'maria.guilherme@example.com', '234-567-8901', '1992-08-22', 'USER'),
('milena_santana', 'password789', 'Milena', 'Santana', 'milena.santana@example.com', '345-678-9012', '1985-11-30', 'ADMIN');

INSERT INTO tb_address (street, number, city, state, postal_code, country, user_id) VALUES
('Rua 1', 'A1', 'Lordran', 'DS', '62701', 'Brasil', 1),
('Rua 2', '2B', 'Lisboa', 'PT', '10001', 'Portugal', 2),
('Rua 3', '3C', 'São José dos Campos', 'SP', '07001', 'Brasil', 3);
