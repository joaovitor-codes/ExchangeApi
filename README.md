# 💱 ExchangeApi

**ExchangeApi** é uma API REST desenvolvida em **Spring Boot** para realizar conversões entre moedas em tempo real.  
A aplicação consome cotações da **AwesomeAPI** e está organizada em camadas (Controller → Service → Client → Mapper), com tratamento centralizado de exceções.

---

## ✨ Funcionalidades

- 🔄 Conversão entre pares de moedas dinâmicos (ex: USD → BRL, EUR → USD, etc.)
- 🌍 Uso de cotações em tempo real via AwesomeAPI
- 🧩 Arquitetura desacoplada: Controller, Service, Client, Mapper
- ⚠️ Tratamento global de exceções

---

## 🛠 Tecnologias

- Java 17+
- Spring Boot 3+
- Maven
- Jackson (manipulação JSON)
- Java HTTP Client (consumo da API externa)

---

## Estrutura do Projeto (correspondente ao repositório)

```

src/
├── main/
│   ├── java/
│   │   └── com.dev.brexchangeapi
│   │       ├── config
│   │       │   ├── impl
│   │       │   │   └── AwesomeApiImpl.java
│   │       │   ├── AwesomeApi.java
│   │       │   └── GlobalHandler.java
│   │       ├── controller
│   │       │   └── ConversionController.java
│   │       ├── dto
│   │       │   └── QuoteDetailsDto.java
│   │       ├── exceptions
│   │       │   ├── ExceptionResponse.java
│   │       │   ├── MethodArgumentNotValidException.java
│   │       │   └── ResourceNotFoundException.java
│   │       ├── mapper
│   │       │   ├── QuoteMapper.java
│   │       │   └── impl
│   │       │       └── QuoteMapperImpl.java
│   │       ├── service
│   │       │   ├── impl
│   │       │   │   ├── CurrencyConversionService.java
│   │       │   │   └── QuoteService.java
│   │       └── BRexchangeApiApplication.java
│   └── resources/
│       ├── db.migration/
│       ├── static/
│       └── application.properties
└── test/

## 🚀 Rodando a aplicação

### Pré-requisitos
- JDK 17+
- Maven

### Passos
1. Clone o repositório:
```bash
git clone https://github.com/joaovitor-codes/ExchangeApi.git
cd ExchangeApi
````

2. Configure a AwesomeAPI em `src/main/resources/application.properties`:

```properties
awesomeapi.baseurl=https://economia.awesomeapi.com.br/json/last/
awesomeapi.key=SUA_CHAVE_DE_API_AQUI
server.port=8080
```

3. Execute:

```bash
mvn spring-boot:run
```

A aplicação ficará disponível em `http://localhost:8080`.

---

## 🔁 Endpoint principal

Converte um valor entre duas moedas.

**GET**

```
/conversion/{originCurrency}/{destinationCurrency}/{amount}
```

* `originCurrency` — código da moeda de origem (ex: `USD`)
* `destinationCurrency` — código da moeda de destino (ex: `BRL`)
* `amount` — valor numérico a converter

**Exemplo**

```
GET http://localhost:8080/conversion/USD/BRL/150
```

**Resposta (200 OK)**
O corpo retorna o número (valor convertido), por exemplo:

```
817.0800
```

**Resposta de erro (404 Not Found)**
Retornado quando o par de moedas não é encontrado na AwesomeAPI ou se houver falha de comunicação. Exemplo de corpo:

```json
{
  "error": "Currency pair not found or external API unavailable."
}
```

---

## 🧭 Mapeamento das responsabilidades (onde fica o quê)

* `controller/ConversionController.java` — endpoints REST
* `service/impl/CurrencyConversionService.java` — lógica de conversão
* `service/impl/QuoteService.java` — orquestra chamada e parse de cotações
* `config/AwesomeApi.java` & `config/impl/AwesomeApiImpl.java` — cliente que consome a AwesomeAPI
* `mapper/QuoteMapper` & `mapper/impl/QuoteMapperImpl` — converte JSON/dtos para modelos internos
* `dto/QuoteDetailsDto` — estrutura dos dados extraídos da API externa
* `exceptions/*` — classes e handler global para tratamento de erros
* `BRexchangeApiApplication.java` — classe principal do Spring Boot
