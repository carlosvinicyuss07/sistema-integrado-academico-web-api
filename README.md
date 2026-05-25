# 🎓 Sistema Integrado Acadêmico - Web API

> **Projeto Acadêmico** desenvolvido como requisito de avaliação para a disciplina de **Programação Web I**.

Este projeto consiste em uma API RESTful desenvolvida em Java com Spring Boot para simular um sistema de gestão acadêmica integrado (inspirado no SUAP). O grande diferencial do sistema é a comunicação fluida, oferecendo um módulo de **Chat por Turma** integrado diretamente no ambiente acadêmico.

---

## 🚀 Tecnologias Utilizadas

O projeto foi construído utilizando o que há de mais moderno no ecossistema Java, focando em código limpo, manutenibilidade e performance:

* **Java 17+**
* **Spring Boot 3+** (Web, Data JPA, Validation)
* **MapStruct** (Mapeamento performático entre Entidades e DTOs)
* **Lombok** (Redução de boilerplate e injeção de dependências via construtor)
* **Flyway** (Versionamento e migração de banco de dados)
* **PostgreSQL** (Banco de dados relacional)
* **Maven** (Gerenciamento de dependências)

---

## 🏗️ Arquitetura e Padrões de Projeto

A arquitetura da API foi pensada para simular um ambiente de produção real, adotando as seguintes premissas:

1. **Separação de Responsabilidades (DTO Pattern):** Uso estrito de DTOs (Data Transfer Objects) na camada de `Controllers`. Nenhuma entidade de banco de dados (`Model`) vaza para as respostas HTTP, garantindo segurança e controle sobre os dados expostos.
2. **Princípio YAGNI (You Aren't Gonna Need It):** Foco na entrega do escopo exigido. Foram implementadas rotas de `GET` e `POST` otimizadas. Operações de `DELETE` ou `PUT` desnecessárias e arriscadas (como deletar históricos de alunos) foram intencionalmente omitidas para preservar a integridade referencial.
3. **Tratamento Global de Exceções:** Implementação de um `ApiExceptionHandler` (Controller Advice) genérico, removendo a necessidade de blocos `try-catch` espalhados pelo código e padronizando as respostas de erro (ex: 404 Not Found, 400 Bad Request, 409 Conflict).
4. **Filtros via Query Parameters:** Uso de parâmetros na URL em métodos `GET` para criar rotas flexíveis que atendem a múltiplos requisitos (ex: filtrar notas por aluno e disciplina numa única chamada).

---

## 🗂️ Modelagem de Dados

O banco de dados foi estruturado em 12 entidades principais para suportar a lógica de negócio:

* **Infraestrutura:** `Curso`, `Disciplina`, `PeriodoLetivo`
* **Usuários:** `Usuario`, `Aluno`, `Professor`
* **Gestão Acadêmica:** `Turma`, `MatriculaTurma`, `Nota`, `Falta`
* **Comunicação:** `ChatTurma`, `ChatMensagem`

---

## 🎯 Principais Funcionalidades por Perfil

O sistema gerencia permissões e visualizações divididas em 3 perfis de acesso:

### 🛡️ Administrador
* Cadastros base (Cursos, Disciplinas, Períodos Letivos).
* Gestão de Usuários (Alunos e Professores).
* Simulação de integração de dados e abertura de novas Turmas.

### 👨‍🏫 Professor
* Consulta de turmas nas quais leciona.
* Visualização da lista de alunos matriculados em suas turmas.
* Acompanhamento e lançamento de **Notas** e **Faltas**.
* Interação via mensagens de texto no Chat exclusivo da turma.

### 👨‍🎓 Aluno
* Consulta das disciplinas em que está matriculado no semestre.
* Acompanhamento de seu próprio boletim (Notas e Faltas por disciplina).
* Interação e recebimento de avisos no Chat das turmas em que está ativo.

---

## 🛣️ Documentação da API (Endpoints Principais)

A API foi projetada de forma semântica. Abaixo estão os principais endpoints disponíveis:

### Cadastros e Usuários
* `GET /api/cursos` | `POST /api/cursos`
* `GET /api/disciplinas` | `POST /api/disciplinas`
* `GET /api/periodos-letivos` | `POST /api/periodos-letivos`
* `GET /api/usuarios` (Lista geral)
* `POST /api/alunos` | `POST /api/professores`

### Turmas e Matrículas
* `GET /api/turmas?professorId={id}&periodoLetivoId={id}`
* `POST /api/turmas`
* `GET /api/matriculas?alunoId={id}` (Turmas do aluno)
* `GET /api/matriculas?turmaId={id}` (Alunos da turma)
* `POST /api/matriculas`

### Avaliações e Assiduidade
* `GET /api/notas?alunoId={id}&disciplinaId={id}`
* `POST /api/notas`
* `GET /api/faltas?alunoId={id}&disciplinaId={id}`
* `POST /api/faltas`

### Módulo de Chat
* `GET /api/chats/turma/{turmaId}` (Busca o chat da turma)
* `POST /api/chats` (Inicializa o chat)
* `GET /api/mensagens/chat/{chatId}` (Histórico de mensagens)
* `POST /api/mensagens` (Envia mensagem - *Exige Header `X-Usuario-Id`*)
