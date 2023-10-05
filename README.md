
# Documentação do Projeto Controle de Aluguéis

## Visão Geral

Este projeto em Java, desenvolvido com o framework Spring Boot, tem como objetivo criar um sistema de controle de aluguéis. O sistema permite o cadastro de moradores por nome e número de apartamento, além de oferecer funcionalidades adicionais para gerenciar aluguéis, pagamentos e informações sobre os apartamentos.

## Tecnologias Utilizadas

- Java
- Spring Boot
- MySQL
- jQuery
- JavaScript

## Configuração do Ambiente de Desenvolvimento

### Pré-requisitos

Certifique-se de que você possui as seguintes ferramentas instaladas em seu sistema:

- [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [MySQL](https://dev.mysql.com/downloads/installer/)

### Configuração do Banco de Dados

- Crie um banco de dados MySQL para armazenar os dados do sistema.

### Configuração do Projeto

- Clone este repositório em sua máquina local:

  ```
  git clone https://github.com/seu-usuario/controle-alugueis.git
  ```

- Acesse o diretório do projeto:

  ```
  cd controle-alugueis
  ```

- Abra o arquivo `application.properties` e configure as propriedades do banco de dados:

  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco_de_dados
  spring.datasource.username=seu_usuario
  spring.datasource.password=sua_senha
  ```

### Executando o Projeto

- Execute o projeto usando o Maven:

  ```
  mvn spring-boot:run
  ```

  O servidor será iniciado na porta padrão 8080.

### Acessando o Sistema

Abra um navegador da web e acesse o seguinte URL para acessar o sistema:

```
http://localhost:8080
```

## Funcionalidades do Sistema

O sistema oferece as seguintes funcionalidades:

- **Cadastro de Moradores:** Permite cadastrar moradores informando nome e número de apartamento.

- **Gerenciamento de Aluguéis:** Permite registrar informações sobre os aluguéis, incluindo datas de início e término, valores e status de pagamento.

- **Consulta de Moradores:** Permite buscar informações sobre os moradores cadastrados no sistema.

- **Consulta de Aluguéis:** Permite buscar informações sobre os aluguéis registrados.

- **Pagamentos:** Possibilita registrar pagamentos efetuados pelos moradores.

- **Relatórios:** Gera relatórios com informações sobre os aluguéis, moradores e pagamentos realizados.


