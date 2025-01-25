drop database if exists 1812384_agenda;
create database 1812384_agenda;

use 1812384_agenda;

create table contato (
    id int primary key auto_increment not null,
    nome varchar(250) not null,
    email varchar(250) unique not null,
    celular int not null,
    nascimento date not null,
    cadastro datetime not null default now()
);

select * from contato;
