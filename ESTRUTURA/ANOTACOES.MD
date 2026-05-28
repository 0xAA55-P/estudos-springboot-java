- O Spring Boot (SpBoot daqui em diante) segue o padrão chamado Layered Architecture (arquitetura em camadas). A ideia é simples, cada camada tem sua responsabilidade.

- A estrutura tipica eh:

```
src/
└── main/
    └── java/
        └── com/seuprojeto/
            ├── controller/       < recebe as requisições HTTP
            ├── service/          < contém a lógica de negócio
            ├── repository/       < mexe com o banco (veremos depois)
            ├── model/            ← representa os dados (entidades/DTOs)
            └── SeuProjetoApplication.java
```
