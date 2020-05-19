create schema if not exists users;

create table users.user (
    id bigserial primary key,
    nome varchar(100) not null,
    cpf varchar(100) not null,
    endereco varchar(100) not null,
	email varchar(100) not null
);