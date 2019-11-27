create schema if not exists users;

create table users.user (
    id bigserial primary key,
    user_identifier varchar not null,
    nome varchar(100) not null,
    cpf varchar(100) not null,
    endereco varchar(100) not null
);