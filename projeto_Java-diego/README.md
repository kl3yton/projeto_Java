
# Sistema de Controle de Tarefas

## Descrição
Sistema em Java para controle de tarefas de uma fábrica de software. Permite cadastro de colaboradores, categorias e tarefas, além de associar tarefas a colaboradores e filtrar por status, categoria ou colaborador.

## Tecnologias
- Java
- MySQL
- JDBC

## Como executar
1. Importe o script `database/script.sql` no seu MySQL.
2. Configure a conexão no arquivo `src/util/ConnectionFactory.java`.
3. Compile e execute a classe `App.java`.

## Funcionalidades
- CRUD de Colaboradores
- CRUD de Categorias
- CRUD de Tarefas
- Associação de tarefas a colaboradores
- Filtros de consulta por colaborador, categoria e status
