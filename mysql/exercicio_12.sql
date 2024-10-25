drop database if exists exercicio_resolvido_12;
create database exercicio_resolvido_12;

use exercicio_resolvido_12;

# A

# Criação da tabela paciente
create table paciente (
    id int primary key not null auto_increment,
    nome varchar(150) not null,
    cpf char(11) unique not null,
    doenca varchar(50) not null,
    horario_registro datetime not null default now(),
    index(nome)
);

# Criação da tabela médico
create table medico (
    id int primary key not null auto_increment,
    nome varchar(150) not null,
    matricula int unique not null,
    especialidade varchar(50) not null,
    salario decimal(6,2) not null,
    horario_registro datetime not null default now(),
    index(nome)
);

# Criação da tabela consulta
create table consulta (
    id_paciente int not null,
    id_medico int not null,
    horario datetime not null,
    valor decimal(5,2) not null,
    horario_registro datetime not null default now(),
    primary key(id_paciente, id_medico, horario),
    foreign key(id_paciente) references paciente(id) on update cascade on delete restrict,
    foreign key(id_medico) references medico(id) on update cascade on delete restrict,
    unique index(id_paciente, horario),
    unique index(id_medico, horario)
);

# B

# Adicionando os médicos
insert into medico (nome, matricula, especialidade, salario) values
    ('Anna Souza', 7777, 'Dermatologia', 7000),
    ('Arthur Barbosa', 2222, 'Cardiologia', 8000),
    ('Davi Leite', 3333, 'Cardiologia', 4000),
    ('Eduardo Henrique', 8888, 'Neurologia', 3000),
    ('Gabriel Souza', 4444, 'Anestegiologia', 3000),
    ('Maria Eduarda', 5555, 'Neurologia', 3000),
    ('Maria Paula', 9999, 'Oftalmologia', 2000),
    ('Miguel Leite', 1111, 'Infectologia', 2000),
    ('Nicolas Alves', 6666, 'Mastologia', 5000);

# Adicionando os pacientes
insert into paciente (nome, cpf, doenca) values
    ('Anna Gabriela', '55555555555', 'Catarata'),
    ('Davi Leite', '33333333333', 'Arritmia'),
    ('Eduardo Luiz', '77777777777', 'Conjuntivite'),
    ('João Paulo', '44444444444', 'Doença de Chagas'),
    ('Leonardo Alves', '11111111111', 'Epilepsia'),
    ('Nicolas Alves', '66666666666', 'Glaucoma'),
    ('Otávio Breno', '88888888888', 'Espasmo das Pálpebras'),
    ('Sara Souza', '99999999999', 'Pericardite'),
    ('Thiago Lucas', '22222222222', 'Doença de Huntington');

# Adicionando as consultas
insert into consulta (id_medico, id_paciente, horario, valor) values (
    (select id from medico where matricula = 2222),
    (select id from paciente where cpf = '22222222222'),
    '2021-10-25 20:00:00',
    200
);

insert into consulta (id_medico, id_paciente, horario, valor) values (
    (select id from medico where matricula = 2222),
    (select id from paciente where cpf = '44444444444'),
    '2021-10-24 20:00:00',
    200
);

insert into consulta (id_medico, id_paciente, horario, valor) values (
    (select id from medico where matricula = 5555),
    (select id from paciente where cpf = '11111111111'),
    '2021-10-22 09:00:00',
    300
);

insert into consulta (id_medico, id_paciente, horario, valor) values (
    (select id from medico where matricula = 9999),
    (select id from paciente where cpf = '33333333333'),
    '2021-10-21 08:00:00',
    150
);

insert into consulta (id_medico, id_paciente, horario, valor) values (
    (select id from medico where matricula = 1111),
    (select id from paciente where cpf = '88888888888'),
    '2021-10-20 16:30:00',
    200
);

insert into consulta (id_medico, id_paciente, horario, valor) values (
    (select id from medico where matricula = 4444),
    (select id from paciente where cpf = '44444444444'),
    '2021-10-16 20:00:00',
    200
);

insert into consulta (id_medico, id_paciente, horario, valor) values (
    (select id from medico where matricula = 6666),
    (select id from paciente where cpf = '77777777777'),
    '2021-10-16 20:00:00',
    250
);

insert into consulta (id_medico, id_paciente, horario, valor) values (
    (select id from medico where matricula = 6666),
    (select id from paciente where cpf = '11111111111'),
    '2021-10-16 19:00:00',
    150
);

insert into consulta (id_medico, id_paciente, horario, valor) values (
    (select id from medico where matricula = 1111),
    (select id from paciente where cpf = '77777777777'),
    '2021-10-16 17:00:00',
    300
);

insert into consulta (id_medico, id_paciente, horario, valor) values (
    (select id from medico where matricula = 3333),
    (select id from paciente where cpf = '99999999999'),
    '2021-10-13 13:00:00',
    300
);

insert into consulta (id_medico, id_paciente, horario, valor) values (
    (select id from medico where matricula = 9999),
    (select id from paciente where cpf = '66666666666'),
    '2021-10-12 14:30:00',
    250
);

insert into consulta (id_medico, id_paciente, horario, valor) values (
    (select id from medico where matricula = 4444),
    (select id from paciente where cpf = '55555555555'),
    '2021-10-12 14:00:00',
    200
);

# C

# Tabela médicos
select
    nome `Nome`,
    matricula `Matrícula`,
    especialidade `Especialidade`,
    concat('R$ ', salario) `Salário`
from
    medico
order by
    nome, matricula;

# Tabela pacientes
select
    nome `Nome`,
    concat(
        substring(cpf, 1, 3),
        '.',
        substring(cpf, 4, 3),
        '.',
        substring(cpf, 7, 3),
        '-',
        substring(cpf, 10, 2)
    ) `CPF`,
    doenca `Doença`
from
    paciente
order by
    nome, cpf;

# Tabela consultas
select
    m.nome `Nome do Médico`,
    m.matricula `Matrícula do Médico`,
    p.nome `Nome do Paciente`,
    concat(
        substring(p.cpf, 1, 3),
        '.',
        substring(p.cpf, 4, 3),
        '.',
        substring(p.cpf, 7, 3),
        '-',
        substring(cpf, 10, 2)
    ) `CPF do Paciente`,
    date_format(c.horario, '%d/%m/%Y %H:%i') `Horário da Consulta`,
    concat('R$ ', c.valor) `Valor da Consulta`
from
    consulta c inner join medico m on c.id_medico = m.id
    inner join paciente p on c.id_paciente = p.id
order by
    c.horario desc, m.matricula;

# D
select
    m.nome `Nome do Médico`,
    m.matricula `Matrícula do Médico`,
    date_format(c.horario, '%d/%m/%Y %H:%i') `Horário da Consulta`,
    concat('R$ ', c.valor) `Valor da Consulta`
from
    consulta c inner join medico m on c.id_medico = m.id
order by
    m.matricula, c.horario desc;

# E
select
    p.nome `Nome do Paciente`,
    concat(
        substring(p.cpf, 1, 3),
        '.',
        substring(p.cpf, 4, 3),
        '.',
        substring(p.cpf, 7, 3),
        '-',
        substring(cpf, 10, 2)
    ) `CPF do Paciente`,
    date_format(c.horario, '%d/%m/%Y %H:%i') `Horário da Consulta`,
    concat('R$ ', c.valor) `Valor da Consulta`
from
    consulta c inner join paciente p on c.id_paciente = p.id
order by
    p.cpf, c.horario desc;

# F

# Médicos sem consulta
select m.nome, m.matricula
from consulta c right join medico m on c.id_medico = m.id
where c.id_medico is null
order by nome, matricula;

# Pacientes sem consulta
select p.nome, p.cpf
from paciente p left join consulta c on c.id_medico = p.id
where c.id_paciente is null
order by nome, cpf;

# G
update consulta
set id_medico = (select id from medico where matricula = 9999)
where id_paciente = (select id from paciente where cpf = '11111111111');

# H
delete from consulta where id_medico = (select id from medico where matricula = 3333);
delete from medico where matricula = 3333;
