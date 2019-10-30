create schema if not exists products;

create table users.product (
    id bigserial primary key,
    nome varchar(100) not null,
    preco float not null,
);