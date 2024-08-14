drop database if exists exercicio_2_slide_08;
create database exercicio_2_slide_08;

use exercicio_2_slide_08;

-- Clínica(Número, nome)
create table clinica (
    numero int primary key not null,
    nome varchar(200) not null
);

-- Médico(CRM, nome, especialidade, CPF, NumClínica)
--    NumClínica referencia Clínica
create table medico (
    crm int primary key not null,
    nome varchar(100) not null,
    especialidade varchar(50) not null,
    cpf char(11) not null unique,
    numero_clinica int not null,
    foreign key(numero_clinica) references clinica(numero) on update cascade on delete restrict
);

-- Conta(ID, número, agência, saldo, CRM)
--    CRM referencia Médico
create table conta (
    id int primary key not null auto_increment,
    numero int not null,
    agencia int not null,
    saldo decimal(10, 2) not null,
    crm int not null,
    foreign key(crm) references medico(crm) on update cascade on delete restrict
);

-- Chave primária para CPF
alter table medico add unique(crm);
alter table medico drop primary key;
alter table medico add primary key(cpf);
alter table medico drop index cpf;

-- Índice composto e exclusivo
alter table conta add unique index idx_numero_agencia(numero, agencia);

-- Índice simples
alter table clinica add index idx_nome(nome);

-- Índice simples
alter table medico add index idx_nome(nome);
