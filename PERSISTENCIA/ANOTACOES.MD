```
Requisição HTTP -> Controller -> Service -> Repository -> Banco de Dados (.db)
```

- O JPA (Java Persistence API) é uma especificação, ela define como mapear objetos Java para tabelas
- O Hibernate é a implementação dessa especificação
- O Spring Data JPA é uma camada acima do Hibernate que elimina quase todo o código repetitivo

- Você pode acessar `http://localhost:8080/h2-console` no navegador para ver as tabelas e dados no banco
