CREATE DATABASE eventoTicket -- Nombre de la BD
CHARSET utf8mb4  -- Juego de carcateres de la BD
COLLATE utf8mb4_spanish2_ci; -- Colación de la BD
-- Paso 2: Activar la BD
USE eventoTicket;

CREATE TABLE eventos
	(idEvento INT AUTO_INCREMENT,
    nombreEvento VARCHAR(45) NOT NULL,
    descripcionEvento VARCHAR(45) NOT NULL,
    horarioEvento VARCHAR(45) NOT NULL,
    ubicacionEvento VARCHAR(45) NOT NULL,
    PRIMARY KEY (idEvento)
);

CREATE TABLE categorias
	(idCategoria INT AUTO_INCREMENT,
    nombreCategoria  VARCHAR(45) NOT NULL,
    descripcionCategoria  VARCHAR(45) NOT NULL,
    precioCategoria DECIMAL (10,2) NOT NULL,
    PRIMARY KEY (idCategoria)
);

CREATE TABLE tickets
	(idTicket INT AUTO_INCREMENT,
    fechaCompraTicket DATE NOT NULL,
    cantidadTicket INT NOT NULL,
	totalPagadoTicket DECIMAL (10,2) NOT NULL,
    idEventoFK int not null,
    idCategoriaFK int not null,
    PRIMARY KEY (idTicket),
    foreign key(idEventoFK) references eventos(idEvento),
    foreign key(idCategoriaFK) references categorias(idCategoria)
);

describe eventos;
describe categorias;
describe tickets;

select* from eventos;
select* from categorias;
select* from tickets;

SELECT host, user FROM mysql.user;
CREATE USER 'entorno'@'localhost' IDENTIFIED BY 'Studium2025#';
GRANT SELECT, INSERT, DELETE, UPDATE ON eventoTicket.eventos TO 'entorno'@'localhost';
GRANT SELECT, INSERT, DELETE, UPDATE ON eventoTicket.categorias TO 'entorno'@'localhost';
GRANT SELECT, INSERT, DELETE, UPDATE ON eventoTicket.tickets TO 'entorno'@'localhost';