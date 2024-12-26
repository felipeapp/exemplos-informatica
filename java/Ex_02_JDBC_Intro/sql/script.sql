drop database if exists escola;
create database escola;

use escola;

create table aluno (
    id int primary key not null auto_increment,
    nome varchar(50) check(length(nome) >= 5) not null,
    matricula int check(matricula between 1000 and 9999) unique not null,
    ira decimal(4,2) check(ira between 0 and 10) not null,
    curso varchar(50) not null default 'Informática',
    sexo enum('M', 'F') not null,
    nascimento date not null,
    cadastro datetime not null default now()
);

select * from aluno;
