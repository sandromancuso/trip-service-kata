## Documentação do projeto

### 1. Objetivo geral do projeto

### 2. Definição dos módulos e classes

- Função
- Atributos
- Métodos

#### módulo TripDAO

- função: deve fornecer funcionalidades relacionadas ao acesso a dados para viagens (como busca em banco de dados ou com outra fonte de dados externa), visto que DAO faz referência a 'data access object'

- parâmetro: user

- usa o modo strict do JS que ajuda a escrever o código mais seguro, eliminando erros comuns e práticas propensas a erros

#### classe User

- função: deve fornecer funcionalidades relacionadas ao usuário do serviço, ainda não implementada

- usa o modo strict do JS que ajuda a escrever o código mais seguro, eliminando erros comuns e práticas propensas a erros

#### classe UserSession

- função: deve fornecer informações sobre a sessão do usuário logado

- métodos:

  - `getLoggedUser`: deve identificar o usuário que está logado, ainda não implementada

- usa o modo strict do JS que ajuda a escrever o código mais seguro, eliminando erros comuns e práticas propensas a erros

- `new UserSession()` usa o Singleton como padrão de design para garantir que a classe tenha apenas uma instância e fornecer um ponto global de acesso a ela

#### classe TripService

- função: fornece a lista de viagens associadas a um usuário específico (logado)

- métodos:

  - `getTripsByUser`: fornece a lista de viagem por usuário

- problemas identificados:
  - método muito longo
  - uso de variáveis não declaradas
