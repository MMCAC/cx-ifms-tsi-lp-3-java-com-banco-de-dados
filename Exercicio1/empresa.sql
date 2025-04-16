create database empresa;
use empresa;

-- Tabela 1: pessoa
CREATE TABLE pessoa (
    id_pessoa INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100)
);

-- Tabela 2: endereco (relacionamento 1:1 com pessoa)
CREATE TABLE endereco (
    id_endereco INT PRIMARY KEY AUTO_INCREMENT,
    rua VARCHAR(100),
    cidade VARCHAR(50),
    estado VARCHAR(2),
    id_pessoa INT UNIQUE,
    FOREIGN KEY (id_pessoa) REFERENCES pessoa(id_pessoa)
);

-- Tabela 3: departamento (sem relacionamento direto)
CREATE TABLE departamento (
    id_departamento INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    responsavel VARCHAR(100)
);

-- Inserindo dados na tabela pessoa
INSERT INTO pessoa (nome, email) VALUES
('Ana Silva', 'ana@email.com'),
('Bruno Costa', 'bruno@email.com'),
('Clara Mendes', 'clara@email.com');

-- Inserindo dados na tabela endereco (1 para 1 com pessoa)
INSERT INTO endereco (rua, cidade, estado, id_pessoa) VALUES
('Rua das Flores', 'Campo Grande', 'MS', 1),
('Av. Brasil', 'São Paulo', 'SP', 2),
('Rua Central', 'Belo Horizonte', 'MG', 3);

-- Inserindo dados na tabela departamento
INSERT INTO departamento (nome, responsavel) VALUES
('Tecnologia da Informação', 'Carlos Henrique'),
('Recursos Humanos', 'Juliana Lima'),
('Financeiro', 'Marcos Dias');
