# java-back-end-livro

Este repositório contém o código do livro Java Back End.

## Serviços

A aplicação é composta de três microserviços, a user-api, a product-api e a shopping-api.

A user-api possui os serviços para gerenciar os usuários da aplicação.

A product-api possui os serviços para gerenciar os produtos disponíveis para compras.

A shopping-api os serviços para que usuários realizem compras.


## Banco de dados

As aplicações criam as tabelas automaticamente quando são executadas pela primeira vez, porém o banco de dados deve ser criado no postgres.

As aplicações estão configuradas para se conectar ao banco de dados 'dev', por isso antes de rodar as aplicações, crie esse banco de dados. Se quiser alterar o nome do banco de dados, altere o arquivo application.properties de cada projeto. Utilizando o docker compose, esse banco de dados já é criado automaticamente.

Todos os projetos acessam o mesmo banco de dados, e criam schemas diferentes.


## Execução

A maneira mais simples de executar a aplicação é utilizando o docker-compose, para isto, basta executar o comando `docker-compose up`.

Eu desenvolvi a aplicação utilizando o Java 8, talvez exista algum problema de portabilidade para versões mais recentes do Java.