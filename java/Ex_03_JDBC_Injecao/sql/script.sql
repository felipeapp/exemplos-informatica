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

insert into contato (nome, email, celular, nascimento) values
    ("Felipe", "felipe@gmail.com", 1111, "2000-12-11"),
    ("Maria", "maria@gmail.com", 2222, "1990-11-20"),
    ("Ana", "ana@gmail.com", 3333, "2000-05-12"),
    ("João", "joao@gmail.com", 4444, "2005-06-12");

select * from contato;
