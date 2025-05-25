
# Sistema de Controle de Tarefas

## 📄 Descrição
Este é um sistema simples de controle de tarefas desenvolvido em Java, utilizando os princípios da Programação Orientada a Objetos (POO). O objetivo do projeto é auxiliar uma fábrica de software na organização das tarefas dos times de desenvolvimento.

O sistema permite o cadastro de categorias, colaboradores e tarefas, além de possibilitar a associação de tarefas a colaboradores, alteração de status e aplicação de filtros para listagem.

## 🎯 Funcionalidades
✔️ Gerenciar Categorias de Tarefas:
- Cadastrar novas categorias.
- Listar categorias cadastradas.
- Alterar nome das categorias.

✔️ Gerenciar Colaboradores:
- Cadastrar colaboradores.
- Listar colaboradores.
- Alterar nome dos colaboradores.
- Excluir colaboradores (desassociando suas tarefas).

✔️ Gerenciar Tarefas:
- Cadastrar tarefas vinculadas a uma categoria.
- Listar todas as tarefas.
- Filtrar tarefas por:
  - Colaborador
  - Categoria
  - Status (Pendente, Em Andamento, Concluída)
- Alterar status das tarefas.
- Associar ou alterar colaborador responsável por uma tarefa.
- Excluir tarefas.

## 🚀 Tecnologias Utilizadas
- 💻 Java (linguagem principal)
- ☕ JDK 17 ou superior (recomendado)
- 🏗️ IDE (Eclipse, IntelliJ IDEA, VSCode ou qualquer de sua preferência)
- 💡 Programação Orientada a Objetos (POO)
- 📜 Execução via terminal (linha de comando) ou pela própria IDE

## ⚙️ Como Executar o Projeto

### 🔧 Pré-requisitos:
- Java JDK instalado na máquina (versão 11, 17 ou superior)
- Editor ou IDE de sua preferência (VSCode, Eclipse, IntelliJ, NetBeans, etc.)

### 🚀 Passo a passo:

1️⃣ Clone ou baixe o projeto no seu computador.

2️⃣ Abra sua IDE e crie um projeto Java.

3️⃣ No projeto, crie um arquivo chamado:
```
SistemaTarefas.java
```

4️⃣ Copie e cole todo o código fonte dentro deste arquivo.

5️⃣ Compile e execute:

✔️ Se estiver usando terminal ou CMD:
```bash
javac SistemaTarefas.java
java SistemaTarefas
```

✔️ Se estiver usando uma IDE, basta clicar no botão de "Run" (executar).

6️⃣ Utilize o menu exibido no console para acessar as funcionalidades do sistema.

## 🏗️ Estrutura do Projeto
```
SistemaDeTarefas/
├── SistemaTarefas.java   (arquivo principal com toda a lógica)
├── README.md             (documentação do projeto)
```

## 💡 Observações
- Todos os dados são armazenados temporariamente na memória (ArrayList). Ao fechar o programa, os dados são perdidos.
- O objetivo do projeto é prático, para fins de aprendizado em lógica de programação, POO e manipulação de dados na memória.

## 👨‍💻 Autor
Desenvolvido por [Seu Nome].
