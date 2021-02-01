
CREATE DATABASE locadora;
USE locadora;

CREATE TABLE cliente (
  idCliente int(11) NOT NULL,
  cpf varchar(11) NOT NULL,
  idade int(11) NOT NULL,
  nomecompleto varchar(100) NOT NULL,
  email varchar(100) NOT NULL
);

CREATE TABLE filme (
  idFilme int(11) NOT NULL,
  titulo varchar(100) NOT NULL,
  duracao int(11) NOT NULL,
  sinopse varchar(500) NOT NULL,
  categoria varchar(100) NOT NULL,
  dublado tinyint(1) NOT NULL
) ;

ALTER TABLE cliente
  ADD PRIMARY KEY (idCliente);

ALTER TABLE filme
  ADD PRIMARY KEY (idFilme);

ALTER TABLE cliente
  MODIFY idCliente int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE filme
  MODIFY idFilme int(11) NOT NULL AUTO_INCREMENT;
