# Projeto CRUD de Livros 📚

Este é um projeto simples de uma API REST para gerenciar livros. Ele permite criar, listar, atualizar e deletar livros, utilizando Java, Spring Boot, JPA e MySQL. O projeto também inclui testes unitários e de integração com JUnit e Mockito.

## 🚀 Funcionalidades

- ✅ Cadastrar um novo livro
- 📖 Listar todos os livros
- 🔍 Buscar livro por ID
- ✏️ Atualizar um livro existente
- ❌ Deletar um livro

---

## 🧪 Testes

O projeto possui:

- **Testes unitários** com Mockito (ex: camada `Service`)
- **Testes de integração** com MockMvc (ex: camada `Controller`)

Para rodar os testes:

```bash
mvn test
```

---

## 🖥️ Como rodar localmente

### Pré-requisitos

- Java 17+
- Maven
- MySQL

### Banco de dados

Crie o banco:

```sql
CREATE DATABASE crud_db;
```

### `application.properties`

```properties
spring.datasource.url=${SPRING_DATASOURCE_URL}
spring.datasource.username=${SPRING_DATASOURCE_USERNAME}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}
spring.jpa.hibernate.ddl-auto=${SPRING_JPA_HIBERNATE_DDL_AUTO}
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

### Rodando o projeto

```bash
mvn spring-boot:run
```

---

## 📬 Como testar no Postman

### Criar livro (POST)
```
POST http://localhost:8080/livro
```
Body (JSON):

```json
{
  "titulo": "1984",
  "autor": "George Orwell",
  "isbn": "987654321"
}
```

### Listar todos (GET)
```
GET http://localhost:8080/livro
```

### Buscar por ID (GET)
```
GET http://localhost:8080/livro/{id}
```

### Atualizar livro (PUT)
```
PUT http://localhost:8080/livro/{id}
```
Body (JSON):

```json
{
  "titulo": "Novo Título",
  "autor": "Novo Autor",
  "isbn": "123456789"
}
```

### Deletar (DELETE)
```
DELETE http://localhost:8080/livro/{id}
```

---

## 🐳 Rodando com Docker

### 1. Build do JAR

```bash
mvn clean package
```

### 2. Criar o container com Docker Compose

```bash
docker-compose up --build
```

### Estrutura usada:

#### 📄 `Dockerfile`

```dockerfile
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/*.jar app.jar
COPY wait-for-it.sh wait-for-it.sh

RUN chmod +x wait-for-it.sh

EXPOSE 8080

ENTRYPOINT ["./wait-for-it.sh", "mysql:3306", "--", "java", "-jar", "app.jar"]
```


## 📌 Observações

- A API utiliza anotações como `@NotBlank` para validação dos campos.
- Em testes, o status de criação correto para POST é `201 Created`.
- As entidades possuem campos privados e foram criados os construtores e métodos getters/setters necessários.
- O projeto foi empacotado com Maven e usa `pom.xml`.


## 📁 Estrutura da aplicação

- `entity/Livro.java` → representa a entidade Livro (id, título, autor, isbn)
- `repository/LivroRepository.java` → interface que estende JpaRepository
- `service/LivroService.java` → classe de serviço com a lógica de negócio
- `controller/LivroController.java` → define os endpoints REST da API

## 🧪 Endpoints disponíveis

| Método | Endpoint         | Descrição                 |
|--------|------------------|---------------------------|
| GET    | /livros          | Lista todos os livros     |
| GET    | /livros/{id}     | Busca um livro por ID     |
| POST   | /livros          | Cadastra um novo livro    |
| PUT    | /livros/{id}     | Atualiza um livro         |
| DELETE | /livros/{id}     | Deleta um livro pelo ID   |

---

### 💬 Agradecimentos

Agradeço por conferir meu primeiro projeto CRUD com Spring Boot!  
Esse repositório foi feito com muito empenho para reforçar meus conhecimentos em Java, API REST e banco de dados.  
Qualquer feedback ou sugestão será muito bem-vindo(a)! 🚀
