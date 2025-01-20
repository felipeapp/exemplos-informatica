drop database if exists agenda;
create database agenda;

use agenda;

create table contato (
    id int primary key auto_increment not null,
    nome varchar(250) not null,
    email varchar(250) unique not null,
    celular int not null,
    nascimento date not null,
    cadastro datetime not null default now()
);

select * from contato;
