drop database if exists exercicio_1_slide_08;
create database exercicio_1_slide_08;

use exercicio_1_slide_08;

create table setor (
    codigo int not null primary key auto_increment,
    nome varchar(100) not null
);

create table programador (
    cpf char(11) primary key not null,
    nome varchar(100) not null,
    data_nascimento date not null,
    codigo_setor int not null,
    foreign key(codigo_setor) references setor(codigo)
        on update cascade on delete restrict
);

create table projeto (
    codigo int not null primary key auto_increment,
    nome varchar(100) not null,
    cpf_programador char(11) not null unique,
    data_coordenacao datetime not null default now(),
    foreign key(cpf_programador) references programador(cpf)
        on update cascade on delete restrict
);

create table linguagem_programacao (
    nome varchar(20) primary key not null,
    multiplataforma boolean not null,
    aberta boolean not null
);

create table domina (
    nome_linguagem varchar(20) not null,
    cpf_programador char(11) not null,
    anos_experiencia tinyint not null,
    primary key(nome_linguagem, cpf_programador),
    foreign key(nome_linguagem) references linguagem_programacao(nome)
        on update cascade on delete restrict,
    foreign key(cpf_programador) references programador(cpf)
        on update cascade on delete restrict
);
