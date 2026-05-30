# Lista de exercicios

## GET

1. Crie um endpoint que receba o peso (kg) e a altura (m) de uma pessoa via @RequestParam e retorne um objeto JSON com o peso, a altura, o IMC calculado e a classificação (Abaixo do peso, Normal, Sobrepeso, Obeso).

2. Crie uma lista estática de pelo menos 6 livros (título, autor, ano, gênero). Implemente os seguintes endpoints:
  - Listar todos os livros
  - Buscar um livro pelo título
  - Filtrar livros por gênero
  - Filtrar livros publicados a partir de um determinado ano

3. Crie uma lista estática de contatos (nome, telefone, email, cidade). Implemente:
  - Listar todos os contatos
  - Buscar contato por nome
  - Filtrar por cidade
  - Endpoint que retorne apenas os emails de todos os contatos (sem os outros dados)

## POST

1. Gerenciador de Tarefas Simples.
  - Permita adicionar Tarefa
  - Permita listar Tarefa
  - Pode melhorar no futuro quando chegarmos em put/patch e/ou delete :3

2. Crie um endpoint que receba um produto (nome, preço, categoria, quantidade em estoque) e o adicione a uma lista em memória. Tambem:
  - Um GET para listar todos os produtos cadastrados
  - Um GET para buscar por categoria

  - O endpoint POST deve retornar o produto cadastrado com um campo disponivel (true se quantidade > 0, false caso contrário), que deve ser calculado automaticamente

3. Refaça o exercicio anterior após ler ESTRUTURA/

4. Refaça o exercicio 2 do GET, mas agora permita adicionar novos livros. Use o estilo de pastas recém aprendido.

## PUT

1. Recrie o gerenciador de contatos dos exercicios GET, mas agora:
  - Adicione uma rota para adicionar um contato
  - Adicione uma rota para editar um contato
