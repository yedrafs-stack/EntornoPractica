create database eventosGaming
charset utf8mb4
collate utf8mb4_spanish2_ci;

use eventosGaming;

CREATE TABLE eventos (
    idEvento INT AUTO_INCREMENT,
    nombreEvento VARCHAR(45) NOT NULL,
    descripcionEvento VARCHAR(100),
    ubicacionEvento VARCHAR(45) NOT NULL,
    PRIMARY KEY (idEvento)
);

CREATE TABLE categorias (
    idCategoria INT AUTO_INCREMENT,
    nombreCategoria VARCHAR(45),
    PRIMARY KEY (idCategoria)
);

CREATE TABLE horarios (
    idHorario INT AUTO_INCREMENT,
    inicioHorario DATETIME NOT NULL,
    finHorario DATETIME NOT NULL,
    idEventoFK INT NOT NULL,
    PRIMARY KEY (idHorario),
    FOREIGN KEY (idEventoFK)
        REFERENCES eventos (idEvento)
);

CREATE TABLE tarifas (
    idTarifa INT AUTO_INCREMENT,
    descripcionTarifa VARCHAR(100),
    stockTarifa INT NOT NULL,
    precioTarifa DECIMAL(6 , 2 ) NOT NULL,
    idCategoriaFK INT NOT NULL,
    idHorarioFK INT NOT NULL,
    PRIMARY KEY (idTarifa),
    FOREIGN KEY (idCategoriaFK)
        REFERENCES categorias (idCategoria),
    FOREIGN KEY (idHorarioFK)
        REFERENCES horarios (idHorario)
);

CREATE TABLE entradas (
    idEntrada INT AUTO_INCREMENT,
    fechaCompraEntrada DATETIME NOT NULL,
    cantidadEntrada INT NOT NULL,
    precioTotalEntrada DECIMAL(8 , 2 ) NOT NULL,
    idTarifaFK INT NOT NULL,
    PRIMARY KEY (idEntrada),
    FOREIGN KEY (idTarifaFK)
        REFERENCES tarifas (idTarifa)
);

describe table eventos;
describe table categorias;
describe table horarios;
describe table tarifas;
describe table entradas;

select * from eventos;
select * from categorias;
select * from horarios;
select * from tarifas;
select * from entradas;

select * from eventos where idEvento = 1;
select nombreEvento, descripcionEvento, ubicacionEvento from eventos where idEvento = 1;
select date_format(inicioHorario, '%d/%m/%Y %H:%i:%s') as 'Inicio',  date_format(finHorario, '%d/%m/%Y %H:%i:%s') as 'Fin' from horarios where idEventoFK = 1;
select idHorarioFK, date_format(inicioHorario, '%d/%m/%Y %H:%i:%s') as 'Inicio',  date_format(finHorario, '%d/%m/%Y %H:%i:%s') as 'Fin', nombreCategoria, precioTarifa, stockTarifa from categorias join tarifas on tarifas.idCategoriaFK = categorias.idCategoria join horarios on tarifas.idHorarioFK = horarios.idHorario where idEventoFK = 1;

create user 'userEventosGaming'@'localhost' identified by 'Studium2025#';
grant insert, select, update, delete on eventosGaming.* to 'userEventosGaming'@'localhost';
show grants for 'userEventosGaming'@'localhost';