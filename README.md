# Projeto Barbearia API

API REST para gerenciamento de clientes e barbeiros de uma barbearia.

## 🚀 Tecnologias

- Java 21
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Spring Validation
- Flyway
- H2 Database (em memória)
- Maven

## 📁 Estrutura principal

- `src/main/java/com/api/barber_shop/controllers` → endpoints REST
- `src/main/java/com/api/barber_shop/services` → regras de negócio
- `src/main/java/com/api/barber_shop/domain` → entidades e repositórios
- `src/main/resources/db/migration` → scripts de migração Flyway

## ✅ Pré-requisitos

- Java 21 instalado
- Maven 3.9+ (ou uso do wrapper `./mvnw`)

## ▶️ Como executar localmente

1. Clone o repositório
2. Entre na pasta do projeto
3. Execute:

```bash
./mvnw spring-boot:run
```

A aplicação sobe por padrão em `http://localhost:8080`.

## 🧪 Executar testes

```bash
./mvnw test
```

## 🗄️ Banco de dados (H2)

A aplicação usa banco em memória para desenvolvimento.

- URL JDBC: `jdbc:h2:mem:barber_shop`
- Usuário: `sa`
- Senha: *(vazia)*
- Console H2: `http://localhost:8080/h2-console`

## 🧱 Migrações Flyway

As tabelas são criadas com Flyway em:

- `V1__create_table_customer.sql`
- `V2__create_table_barber.sql`
- `V3__create_table_service.sql`

## 📌 Endpoints disponíveis

### Cliente (`/customer`)

- `POST /customer` → cadastra cliente
- `GET /customer/email?email=...` → busca cliente por e-mail
- `PUT /customer/{id}` → atualiza cliente
- `DELETE /customer/{id}` → remove cliente

### Barbeiro (`/barber`)

- `POST /barber/cadastro` → cadastra barbeiro
- `GET /barber/nome?name=...` → busca barbeiros por nome
- `PUT /barber/{id}` → atualiza barbeiro
- `DELETE /barber/{id}` → remove barbeiro
