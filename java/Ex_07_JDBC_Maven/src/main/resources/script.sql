drop database if exists acesso;
create database acesso;

use acesso;

create table usuario (
    id int primary key auto_increment not null,
    nome varchar(200) not null,
    cpf char(11) unique not null,
    tag int unique not null
);

create table sala (
    id int primary key auto_increment not null,
    numero int unique not null,
    nome varchar(200) unique not null
);

create table permissao (
    id_usuario int not null,
    id_sala int not null,
    horario datetime not null default now(),
    primary key(id_usuario, id_sala),
    foreign key(id_usuario) references usuario(id)
        on delete restrict on update cascade,
    foreign key(id_sala) references sala(id)
        on delete restrict on update cascade
);
