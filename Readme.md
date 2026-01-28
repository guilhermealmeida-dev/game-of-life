# 🧬 Game of Life (Conway)

Este projeto é uma implementação do **Jogo da Vida (Game of Life)**, um autômato celular criado pelo matemático **John Conway**.

O jogo simula a evolução de células em uma grade bidimensional, onde cada célula pode estar **viva** ou **morta**, e seu estado muda a cada geração seguindo regras simples.

---

## ⚙️ Regras do Jogo

A cada rodada (geração):

- Uma célula viva com **menos de 2 vizinhos vivos** morre (solidão)
- Uma célula viva com **2 ou 3 vizinhos vivos** continua viva
- Uma célula viva com **mais de 3 vizinhos vivos** morre (superpopulação)
- Uma célula morta com **exatamente 3 vizinhos vivos** nasce (reprodução)

---

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Terminal ou IDE (VS Code / IntelliJ)

---

## 📂 Estrutura do Projeto

O arquivo principal do projeto está localizado em:

```bash
src/main/java/com/guilherme/almeida/GameOfLife.java
```

## ▶️ Como Executar o Projeto

### 💻 Executar manualmente pelo Terminal

Dentro da pasta do projeto, compile o código com:

```bash
javac -d target/classes src/main/java/com/guilherme/almeida/GameOfLife.java
```
Em seguida, execute o programa com:
```bash
java -cp target/classes com.guilherme.almeida.GameOfLife
```
### 🖥️ Executar pela IDE (IntelliJ ou VS Code)

1. Abra o projeto na IDE  
2. Acesse o arquivo principal:

```bash
src/main/java/com/guilherme/almeida/GameOfLife.java
```
Clique no botão Run ▶ na função main()