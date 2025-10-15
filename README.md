# 💱 ExchangeApi

**ExchangeApi** é uma API REST desenvolvida em **Spring Boot** para realizar a conversão de valores entre diferentes moedas em tempo real.  
A aplicação consome os dados de cotação da **AwesomeAPI**, garantindo que os cálculos de conversão utilizem as taxas mais recentes.

---

## ✨ Funcionalidades

- 🔄 Conversão de valores entre pares de moedas dinâmicos (ex: USD → BRL, EUR → USD, etc.)  
- 🌍 Utiliza cotações em tempo real de uma API externa  
- 🧩 Arquitetura limpa e desacoplada em camadas (**Controller**, **Service**, **Mapper**, **Client**)  
- ⚙️ Tratamento de respostas JSON com chaves dinâmicas, garantindo flexibilidade na consulta de moedas  

---

## 🛠️ Tecnologias Utilizadas

- ☕ **Java 17+**
- 🚀 **Spring Boot 3+**
- 📦 **Maven** (gerenciador de dependências)
- 🧠 **Jackson Databind** (manipulação avançada de JSON)
- 🌐 **Java HTTP Client** (para comunicação com a API externa)

---

## 🚀 Começando

Siga os passos abaixo para clonar, configurar e executar a aplicação localmente.

### 📋 Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- **JDK 17** ou superior  
- **Maven** configurado corretamente no seu sistema

---

### 🧩 1. Clonar o Repositório

```bash
git clone https://github.com/joaovitor-codes/ExchangeApi.git
cd ExchangeApi
````

---

### 🔑 2. Configurar a API Externa

A aplicação precisa de uma chave de acesso para se comunicar com a **AwesomeAPI**.

1. Acesse o site da AwesomeAPI e obtenha sua chave:
   👉 [https://docs.awesomeapi.com.br/](https://docs.awesomeapi.com.br/)
2. No projeto, abra o arquivo:
   `src/main/resources/application.properties`
3. Configure as seguintes propriedades:

```properties
awesomeapi.baseurl=https://economia.awesomeapi.com.br/json/last/
awesomeapi.key=SUA_CHAVE_DE_API_AQUI
```

> ⚠️ **Importante:** A aplicação **não funcionará** sem uma chave de API válida.

---

### ▶️ 3. Executar a Aplicação

Execute o comando abaixo para iniciar a aplicação:

```bash
mvn spring-boot:run
```

A API estará disponível em:
👉 [http://localhost:8080](http://localhost:8080)

---

## ⚙️ Uso da API

A API expõe um endpoint principal para realizar conversões monetárias dinâmicas, utilizando **path variables**.

### 🔁 Endpoint de Conversão

**URL:**

```
/conversion/{originCurrency}/{destinationCurrency}/{amount}
```

**Método:** `GET`

#### 🔧 Parâmetros de Caminho

| Parâmetro             | Tipo   | Obrigatório | Descrição                            |
| --------------------- | ------ | ----------- | ------------------------------------ |
| `originCurrency`      | String | ✅           | Código da moeda de origem (ex: USD)  |
| `destinationCurrency` | String | ✅           | Código da moeda de destino (ex: BRL) |
| `amount`              | Bigdecimal | ✅       | Valor a ser convertido               |

---

### 🧮 Exemplo de Requisição

Converter **150 Dólares Americanos (USD)** para **Reais Brasileiros (BRL):**

```http
GET http://localhost:8080/conversion/USD/BRL/150
```

---

### ✅ Exemplo de Resposta (200 OK)

```json
817.0800
```

---

### ❌ Exemplo de Resposta de Erro (404 Not Found)

```json
{
  "error": "Currency pair not found or external API unavailable."
}
```

> Se o par de moedas não for encontrado ou ocorrer um erro durante a comunicação com a API externa, será retornado **status 404**.

---

## 🧠 Estrutura do Projeto

```
src/
 ├── main/
 │   ├── java/com/example/exchangeapi/
 │   │   ├── controller/   → Endpoints REST
 │   │   ├── service/      → Regras de negócio
 │   │   ├── client/       → Comunicação com a API externa
 │   │   ├── mapper/       → Conversão de dados e modelos
 │   │   └── model/        → Classes de domínio
 │   └── resources/
 │       └── application.properties
 └── test/                 → Testes automatizados
```

---

Quer que eu adicione um **badge** (ex: Java version, Spring Boot version, licença, etc.) no topo do README para deixar mais profissional?
```
