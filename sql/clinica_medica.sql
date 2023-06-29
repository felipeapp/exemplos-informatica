drop database if exists clinica_medica;
create database clinica_medica;

use clinica_medica;

create table pessoa (
    cpf char(11) primary key not null,
    nome varchar(150) not null
);

create table motorista (
    cpf char(11) primary key not null,
    cnh int unique not null,
    foreign key(cpf) references pessoa(cpf) on update cascade on delete restrict
);

create table paciente (
    cpf char(11) primary key not null,
    endereco varchar(200) not null,
    foreign key(cpf) references pessoa(cpf) on update cascade on delete restrict
);

create table sala (
    codigo int primary key not null,
    endereco varchar(200) not null
);

create table medico (
    cpf char(11) primary key not null,
    crm int unique not null,
    codigo_sala int not null unique,
    foreign key(cpf) references pessoa(cpf) on update cascade on delete restrict,
    foreign key(codigo_sala) references sala(codigo) on update cascade on delete restrict
);

create table consulta (
    cpf_medico char(11) not null,
    cpf_paciente char(11) not null,
    horario datetime not null,
    primary key(cpf_medico, cpf_paciente, horario),
    unique index(cpf_medico, horario),
    unique index(cpf_paciente, horario),
    foreign key(cpf_medico) references medico(cpf) on update cascade on delete restrict,
    foreign key(cpf_paciente) references paciente(cpf) on update cascade on delete restrict
);

create table doenca (
    nome varchar(50) primary key not null,
    causador varchar(50) not null
);

create table diagnostico (
    cpf_paciente char(11) not null,
    nome_doenca varchar(50) not null,
    data_diagnostico date not null,
    primary key(cpf_paciente, nome_doenca, data_diagnostico),
    foreign key(cpf_paciente) references paciente(cpf) on update cascade on delete restrict,
    foreign key(nome_doenca) references doenca(nome) on update cascade on delete restrict
);

create table especialidade (
    nome varchar(50) primary key not null
);

create table domina (
    cpf_medico char(11) not null,
    nome_especialidade varchar(50) not null,
    anos_experiencia tinyint not null,
    primary key(cpf_medico, nome_especialidade),
    foreign key(cpf_medico) references medico(cpf) on update cascade on delete restrict,
    foreign key(nome_especialidade) references especialidade(nome) on update cascade on delete restrict
);
