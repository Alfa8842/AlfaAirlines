CREATE DATABASE AlfaAirlines;

USE AlfaAirlines;

CREATE TABLE pacotes (
id INT PRIMARY KEY AUTO_INCREMENT,
destino VARCHAR(25),
preco DECIMAL(10,1),
promocao BOOLEAN,
data DATETIME,
origem VARCHAR(25)
);

CREATE TABLE usuarios (
id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(50),
telefone VARCHAR(15),
cpf VARCHAR(20) UNIQUE,
email VARCHAR(35),
senha VARCHAR(20)
);

CREATE TABLE compras (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    id_pacote INT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    FOREIGN KEY (id_pacote) REFERENCES pacotes(id)
);