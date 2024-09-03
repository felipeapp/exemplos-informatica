drop schema if exists exercicio_slide_09;
create schema exercicio_slide_09;

use exercicio_slide_09;

create table produto (
    id int primary key not null auto_increment,
    nome varchar(20) unique not null,
    valor decimal(5, 2) not null,
    quantidade int not null,
    medida varchar(10) not null
);

insert into produto (nome, valor, quantidade, medida) values 
    ('Arroz',   1.90,  33,  'Kg'),
    ('Feijão',  3.85,  82,  'Kg'),
    ('Miojo',   1.20,  22,  'Unidade'),
    ('Tomate',  3.05,  128, 'Kg'),
    ('Cenoura', 2.50,  173, 'Kg'),
    ('Batata',  2.38,  74,  'Kg'),
    ('Pão',     10.25, 570, 'g'),
    ('Queijo',  12.50, 120, 'Kg'),
    ('Água',    2.21,  88,  'L');

select * from produto;

set sql_safe_updates = 0;

update produto set quantidade = 100 where medida = 'Kg';
delete from produto where valor <= 2 or quantidade < 90;
update produto set valor = 2 * valor;

set sql_safe_updates = 1;

select * from produto;
