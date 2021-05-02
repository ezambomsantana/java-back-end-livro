# java-back-end-livro

Este repositório contém o código do livro Java Back End.

## Serviços

A aplicação é composta de três microserviços, a user-api, a product-api e a shopping-api.

A user-api possui os serviços para gerenciar os usuários da aplicação.

A product-api possui os serviços para gerenciar os produtos disponíveis para compras.

A shopping-api os serviços para que usuários realizem compras.

## Banco de dados

As aplicações criam as tabelas automaticamente quando são executadas pela primeira vez, porém o banco de dados deve ser criado no postgres.

As aplicações estão configuradas para se conectar ao banco de dados `dev`, por isso antes de rodar as aplicações, crie esse banco de dados. Se quiser alterar o nome do banco de dados, altere o arquivo application.properties de cada projeto. Utilizando o docker compose, esse banco de dados já é criado automaticamente.

Todos os projetos acessam o mesmo banco de dados, apenas criam schemas diferentes.

## Postman

o arquivo `livro-back-end-java.postman_collection.json` é uma collection do Postman que possui as chamadas para os serviços da aplicação. A collection está configurada para chamar os serviços já no Kubernetes. Para chamar na execução local, basta trocar o shopping.com para localhost:808x.

## Execução

A maneira mais simples de executar a aplicação é utilizando o docker-compose, para isto, basta executar o comando `docker-compose up` depois que a imagem docker dos microserviços forem criadas.

## Versções

Eu utilizei a versão 2.3.0.RELEASE do Spring Boot para desenvolver a aplicação, pois ela era a versão mais recente quando escrevi o livro, quando for atualizar o livro vou atualizar a aplicação para a versão mais recente do Spring Boot.

Eu desenvolvi a aplicação utilizando o Java 8, não deve haver grandes problemas na utilização de versões mais recentes do Java, mas talvez exista alguns pequenos problemas na portabilidade.