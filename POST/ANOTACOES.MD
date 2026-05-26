- (existem mais anotações dentro dos .java em si :3)

- O HTTP possui varios verbos, cada um com um proposito
  - GET -> Receber um dado
  - POST -> Criar um dado
  - PUT/PATCH -> Atualizar um Dado Existente
  - DELETE -> Deletar um Dado

- o POST é usado para enviar um corpo de dados a um servidor; um login, produto, cadastro... etc
- Diferente do GET, o post carrega os dados no corpo da requisição, não na URL

- Fluxo (no Basics/):
  - Cliente envia um JSON - 1
  - Spring recebe a requisição - 2
  - Spring lê o header Content-Type: application/json - 3
  - O spring usa o jackson para converter o json em objeto - 4
  - O programa processa e retorna um ResponseEntity
  - Spring converte a resposta para json de volta
