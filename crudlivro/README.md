# Projeto CRUD de Livros 📚

Este é um projeto básico para treinar operações CRUD (Create, Read, Update, Delete) usando Java com Spring Boot e banco de dados MySQL.

## 🔧 Tecnologias usadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL

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

## ⚙️ Configuração no `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> Lembre-se de criar manualmente o banco de dados no MySQL com o nome usado em seu_banco.

### ▶️ Como rodar o projeto

- Verifique se o MySQL está rodando e crie o banco com o nome definido.
- Abra o projeto no IntelliJ ou outra IDE.
- Execute a classe CrudDemoApplication.
- Use o Postman ou Insomnia para testar os endpoints.

---

### 💬 Agradecimentos

Agradeço por conferir meu primeiro projeto CRUD com Spring Boot!  
Esse repositório foi feito com muito empenho para reforçar meus conhecimentos em Java, API REST e banco de dados.  
Qualquer feedback ou sugestão será muito bem-vindo(a)! 🚀