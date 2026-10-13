# 📚 Sistema de Gerenciamento de Biblioteca

Sistema desenvolvido em **Java**, com foco no gerenciamento de livros, usuários e empréstimos, aplicando conceitos de Programação Orientada a Objetos, validação de dados, tratamento de exceções e organização em camadas.

---

# 📖 Sobre o Projeto

Este projeto foi desenvolvido como prática de estudos em **Java**, com o objetivo de aprofundar conhecimentos em orientação a objetos, regras de negócio, validação de informações e estruturação de aplicações.

A proposta é desenvolver um sistema de gerenciamento de biblioteca capaz de controlar o cadastro de livros e usuários, registrar empréstimos e devoluções, verificar a disponibilidade dos livros e calcular multas por atraso.

O desenvolvimento está sendo realizado de forma incremental, priorizando a implementação e validação das regras de negócio antes da integração das camadas de persistência e interação com o usuário.

---

# 🚀 Funcionalidades

### Implementadas

- Cadastro e representação de livros e usuários por meio de classes de modelo.
- Geração automática de identificadores únicos utilizando UUID.
- Validação de campos obrigatórios.
- Validação de ISBN-10 e ISBN-13.
- Validação de CPF por meio dos dígitos verificadores.
- Validação de e-mail e telefone.
- Registro de empréstimos associados a livros e usuários.
- Controle de disponibilidade dos livros.
- Definição automática do prazo de devolução de 14 dias.
- Cálculo de dias de atraso e multa de R$ 2,00 por dia.
- Registro de devolução e liberação do livro para novos empréstimos.
- Tratamento de exceções personalizadas para campos obrigatórios e livros indisponíveis.

### Em desenvolvimento

- Implementação das operações de cadastro, consulta, atualização e remoção.
- Criação dos repositórios para livros, usuários e empréstimos.
- Implementação da camada de serviços para centralizar as operações e regras de negócio.
- Persistência dos dados em JSON ou SQLite.
- Desenvolvimento da interface de linha de comando (CLI).
- Ampliação dos testes automatizados.

---

# 🛠️ Tecnologias Utilizadas

- **Java 24** — linguagem de programação.
- **Maven** — gerenciamento de dependências e build.
- **UUID** — geração de identificadores únicos.
- **LocalDate** — manipulação de datas de empréstimo e devolução.
- **BigDecimal** — representação e cálculo de valores monetários.
- **Java Time API** — operações relacionadas a datas e cálculo de atrasos.
- **Jackson** — dependência disponível para futura implementação da persistência em JSON.

---

# 🏛️ Arquitetura do Projeto

O sistema está sendo organizado em camadas, buscando separar as responsabilidades e facilitar a manutenção e a evolução do código.

- **Model** — representação das entidades e regras associadas aos livros, usuários e empréstimos.
- **Util** — métodos auxiliares para validação de dados, incluindo ISBN, CPF e campos obrigatórios.
- **Exception** — exceções personalizadas para situações inválidas durante a execução.
- **Repository** — camada planejada para armazenamento, consulta, atualização e remoção de dados.
- **Service** — camada planejada para coordenar as operações do sistema e aplicar as regras de negócio.
- **CLI** — interface planejada para interação com o usuário por meio de um menu.

O projeto também possui um diagrama UML para representar a estrutura das classes, seus relacionamentos e a arquitetura planejada.

---

# 📋 Regras de Negócio

- Cada livro, usuário e empréstimo possui um identificador único.
- Um livro precisa estar disponível para ser emprestado.
- O prazo padrão de empréstimo é de 14 dias.
- A multa por atraso é de R$ 2,00 por dia.
- A devolução deve registrar a data efetiva e atualizar a disponibilidade do livro.
- Os dados são validados antes de serem utilizados na criação das entidades.
- Um empréstimo já finalizado não pode ser devolvido novamente.

---

# 🗺️ Próximas Etapas

- Implementar os repositórios e as operações de CRUD.
- Integrar os modelos à camada de serviços.
- Implementar a persistência dos dados.
- Desenvolver o menu de interação com o usuário.
- Ampliar os testes de validação, empréstimo, devolução e multas.
- Atualizar a documentação conforme a evolução do sistema.

---

# 👩‍💻 Autora

**Júlia Agosti**

Projeto desenvolvido para fins de estudo e aprimoramento em desenvolvimento Java, Programação Orientada a Objetos, arquitetura em camadas e implementação de regras de negócio.
