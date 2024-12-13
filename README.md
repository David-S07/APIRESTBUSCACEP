# API REST para realizar a consulta de CEP

    Backend:
        API REST para realizar a consulta de CEP, com endpoints específicos para consultar o CEP e registrar o log da consulta.
    Integração com API externa:
        A aplicação fará a consulta de CEP em uma API externa viaCEP
        Um banco de dados relacional (como H2) onde os logs das consultas serão armazenados.
        Tabela ou coleção de logs com os campos: cep, data_consulta, dados_retornados.

Diagrama de arquitetura:

plaintext

    +--------------------+      +-------------------------+
    |  Aplicação Cliente | ---> |  API REST de Consulta   |
    |  (Front-end)       |      |  de CEP                 |
    +--------------------+      +-------------------------+
    |
    +-------------+
    |  Serviço de |
    |  Consulta   | --> Consultar a API externa
    +-------------+
    |
    +-------------+
    |  Banco de   |  
    |  Dados de   |
    |  Logs       |
    +-------------+

## 2. Tecnologias Utilizadas

    Linguagem de Programação: Java 11.
    Framework API: Spring Boot, RESTful API.
    Banco de Dados:
        Relacional: H2, utilizando JPA para persistência.
    Docker: Para orquestrar a execução do banco de dados.

## 3. Estrutura do Código e Princípios SOLID

Single Responsibility Principle (SRP):

    A classe que consulta o CEP terá apenas a responsabilidade de realizar a consulta, e a classe que grava os logs terá apenas a responsabilidade de persistir os dados no banco.

Open/Closed Principle (OCP):

    As classes e métodos estarão abertos para extensão (ex. novos tipos de banco de dados ou diferentes fontes de APIs), mas fechados para modificação.

Liskov Substitution Principle (LSP):

    Implementação de interfaces que garantem que qualquer classe que herde uma interface (como ConsultaCepService) pode ser utilizada sem alterar o comportamento do sistema.

Interface Segregation Principle (ISP):

    Criar interfaces menores e mais específicas, como uma interface para consulta de CEP (ConsultaCepService) e outra para logging (LogService).

Dependency Inversion Principle (DIP):

    Dependência de abstrações, não de implementações concretas. Por exemplo, o serviço de consulta de CEP depende de uma interface, e não de uma implementação específica de consulta a API.

## 4 incluido documentação para API 

Para acessar a documentação é só rodar a app e acessar ->
    http://localhost:8080/swagger-ui/index.html#/correios-controller/getCep


## 5 Como Startar o Back-End

    Instalar as Dependências
    Para rodar a aplicação, você precisa ter o Java 11+ e o Maven instalados. Caso não tenha, instale-os:
        Java 11+
        Maven
    Configuração do Banco de Dados
    O back-end usa o banco de dados H2 por padrão para armazenar os logs das consultas. Você pode configurar um banco de dados relacional como MySQL ou PostgreSQL, caso necessário, no arquivo src/main/resources/application.properties.
    
Rodar a Aplicação
Após configurar o banco de dados, você pode rodar a aplicação usando o Maven:

bash

mvn spring-boot:run

Ou, se estiver usando um IDE como IntelliJ IDEA ou Eclipse, basta executar a classe principal da aplicação, 
que será algo como SpringApp.java.
A aplicação estará disponível em http://localhost:8080.
Testar a API com Swagger
A documentação da API gerada pelo Swagger pode ser acessada em:


http://localhost:8080/swagger-ui/index.html

A partir dessa interface, você pode testar todos os endpoints da API.
Testar a Consulta de CEP
Após iniciar o back-end, você pode testar o endpoint GET /cep/{cep} com o seguinte formato:

http://localhost:8080/cep/{cep}

Substitua {cep} pelo CEP que deseja consultar (ex: 12345678).
Exemplo de resposta JSON:

json

{
"cep": "Av. Interlagos,",
"logradouro": "Av. Interlagos,",
"bairro": "Vila Arriete",
"uf": "SP",
"estado": "São Paulo",
"regiao": "Sudeste",
"ddd": "11"
}

Consultar os Logs
A cada consulta realizada, a aplicação registra a consulta no banco de dados.
A tabela de logs pode ser acessada diretamente no banco de dados ou via API de consulta, se você implementar um endpoint para isso.
