CREATE DATABASE IF NOT EXISTS sistema_tarefas;
USE sistema_tarefas;

CREATE TABLE Categoria (
    idCategoria INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE Colaborador (
    idColaborador INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100)
);

CREATE TABLE Tarefa (
    idTarefa INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    descricao TEXT,
    status VARCHAR(50),
    dataCriacao DATE,
    dataConclusao DATE,
    categoria_id INT,
    colaborador_id INT,
    FOREIGN KEY (categoria_id) REFERENCES Categoria(idCategoria),
    FOREIGN KEY (colaborador_id) REFERENCES Colaborador(idColaborador)
);