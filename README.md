# 🛠️ API REST - Controle de Caixa Comercial

API REST desenvolvida em Java com Spring Boot para gerenciamento de fluxo de caixa comercial (entradas, saídas, consulta de saldo e extrato). Projeto focado em demonstrar boas práticas de Programação Orientada a Objetos, tratamento de exceções e arquitetura web.

---

## 🚀 Tecnologias Utilizadas

* **Linguagem:** Java 26
* **Framework:** Spring Boot 3
* **Gerenciador de Dependências:** Maven
* **Arquitetura:** REST API (HTTP GET, Request Parameters)
* **Controle de Versão:** Git & GitHub

---

## 📌 Funcionalidades e Regras de Negócio

- [x] **Registro de Entradas:** Adiciona valores positivos ao caixa e atualiza o histórico.
- [x] **Registro de Saídas:** Realiza saídas financeiras com validação de saldo (impede saídas superiores ao valor em caixa).
- [x] **Consulta de Saldo e Operações:** Exibe o saldo consolidado e o total de transações efetuadas no dia.
- [x] **Extrato Dinâmico:** Retorna o histórico de movimentações em formato estruturado (JSON).

---

## 🛠️ Endpoints da API

A aplicação roda localmente na porta `8080`.

| Método | Endpoint | Descrição | Parâmetros |
| :--- | :--- | :--- | :--- |
| `GET` | `/caixa/saldo` | Retorna o saldo consolidado do caixa | Nenhum |
| `GET` | `/caixa/entrada` | Registra uma entrada financeira | `valor` (double) |
| `GET` | `/caixa/saida` | Registra uma saída financeira | `valor` (double) |
| `GET` | `/caixa/extrato` | Devolve o histórico de transações | Nenhum |

---

## 💻 Como Rodar o Projeto Localmente

1. **Clonar o repositório:**
   ```bash
   git clone https://github.com/Tavobrandao/api-controle-caixa-spring.git