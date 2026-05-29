- A requisição PUT atualiza todos os  dados de alguma coisa.

- É como "pegue este recurso e troque ele inteiramente por isso que estou enviando"

- Exemplo, imagine que você tem esse usuário:

```
{ "id": 1, "nome": "Carlos", "email": "carlos@email.com", "idade": 25 }
```

- Se fizer um PUT enviando:

```
{ "nome": "Carlos Silva", "email": "carlos.silva@email.com", "idade": 26 }
```

- Agora, o usuário terá:

```
{ "id": 1, "nome": "Carlos Silva", "email": "carlos.silva@email.com", "idade": 26 }
```

- O Objeto inteiro é substituido, se o campo email não fosse enviado, ele ficaria vazio/nulo. É diferente do PATCH (Veremos depois) que atualiza só os campos enviados na requisição
