# ExchangeApi

Uma API REST desenvolvida em Spring Boot para realizar a conversão de valores entre diferentes moedas em tempo real. A aplicação consome os dados de cotação da AwesomeAPI para garantir que os cálculos de conversão utilizem as taxas mais recentes.

✨ Features
Conversão de valores entre pares de moedas dinâmicos (ex: USD para BRL, EUR para USD, etc.).

Utiliza cotações em tempo real de uma API externa.

Arquitetura limpa e desacoplada em camadas (Controller, Service, Mapper, Client).

Tratamento de respostas JSON com chaves dinâmicas, permitindo flexibilidade na consulta de moedas.

🛠️ Tecnologias Utilizadas
Java 17+

Spring Boot 3+

Maven como gerenciador de dependências.

Jackson Databind para manipulação avançada de JSON.

Java 11+ HTTP Client para comunicação com a API externa.

🚀 Começando
Siga os passos abaixo para clonar, configurar e executar a aplicação localmente.

Pré-requisitos
Certifique-se de ter o JDK 17 ou superior instalado.

Certifique-se de ter o Maven instalado e configurado no seu sistema.

1. Clone o repositório
Bash

git clone https://github.com/joaovitor-codes/ExchangeApi.git
cd BRexchangeAPI
2. Configure a API Externa
A aplicação precisa de uma chave de acesso para se comunicar com a AwesomeAPI.

Acesse o site da AwesomeAPI e obtenha sua chave de acesso (API Key).
https://docs.awesomeapi.com.br/

No projeto, encontre o arquivo src/main/resources/application.properties.

Configure as seguintes propriedades com a sua chave e a URL base:

Properties

# ===============================================
# CONFIGURAÇÃO DA AWESOME API
# ===============================================
# URL base da API de cotações
awesomeapi.baseurl=https://economia.awesomeapi.com.br/json/last/

# COLE A SUA CHAVE DA AWESOME API AQUI
awesomeapi.key=SUA_CHAVE_DE_API_AQUI
⚠️ Importante: A aplicação não funcionará sem uma chave de API válida.

3. Execute a Aplicação
A aplicação estará disponível em http://localhost:8080.

⚙️ Uso da API
A API expõe um endpoint principal para realizar as conversões, utilizando variáveis de caminho (path variables).

Endpoint de Conversão
Converte um valor de uma moeda de origem para uma moeda de destino.

URL: /conversion/{originCurrency}/{destinationCurrency}/{amount}

Método: GET

Parâmetros de Caminho:

originCurrency (obrigatório): Código da moeda de origem (ex: USD).

destinationCurrency (obrigatório): Código da moeda de destino (ex: BRL).

amount (obrigatório): O valor a ser convertido.

Exemplo de Requisição
Para converter 150 Dólares Americanos para Reais Brasileiros:

HTTP

GET http://localhost:8080/conversion/USD/BRL/150
Exemplo de Resposta de Sucesso (Status 200 OK)
A API retornará o valor final da conversão como um número puro no corpo da resposta.

817.0800
Exemplo de Resposta de Erro (Status 404 Not Found)
Se o par de moedas não for encontrado na API externa ou ocorrer um erro durante o processo, a API retornará uma resposta vazia com o status 404.
