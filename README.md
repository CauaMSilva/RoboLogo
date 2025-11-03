## Trabalho de POO

## DESCRIÇÃO

- Este projeto foi inspirado na linguagem Logo, usada em escolas para introduzir lógica de programação.

- Nele, o usuário controla um robô (ou tartaruga) que se move em um plano cartesiano 4x4, em busca de um alimento posicionadoem uma coordenada fornecida pelo usuário.

## OBJETIVOS DO PROJETO

- Praticar orientação a objetos (POO) em Java

- Trabalhar com herança, polimorfismo, sobrecarga e exceções personalizadas

- Simular um ambiente de movimentação em um plano cartesiano

- Exercitar entrada de dados, tratamento de exceções e exibição de estados

## ESTRUTURA DO PROJETO

RoboLogo/
│
├── src/
│   ├── main/
│   │   ├── Main.java
│   │   ├── MainDois.java
│   │   ├── MainInteligente.java
│   │   └── MainComObstaculo.java
│   │
│   ├── robo/
│   │   ├── Robo.java
|   |   ├── RoboNormal.java
│   │   └── RoboInteligente.java
│   │
│   ├── interaveis/
│   │   ├── Obstaculo.java
|   |   ├── Alimento.java
│   │   ├── Bomba.java
│   │   └── Rocha.java
│   │
|   ├── util/
|   |   └── Tabuleiro.java
|   |   
│   └── exceptions/
│       └── MovimentoInvalidoException.java
│
└── bin/
    └── (arquivos compilados .class)

## RODANDO O CÓDIGO

* REQUISITOS

a) Java 8+

b) IDE como Eclipse ou IntelliJ IDEA

1. MainSimples

- Um único robô.

- Usuário define a posição do alimento.

- Robô se move até encontrar o alimento.

- Trata exceções de movimentos inválidos.

2. MainDupla

- Dois robôs se movem aleatoriamente.

- Contabiliza movimentos válidos e inválidos.

- Exibe qual robô encontrou o alimento primeiro.

3. MainInteligente

- Um robô normal e outro inteligente.

- O RoboInteligente evita repetir movimentos inválidos consecutivos.

- Ambos buscam o alimento até encontrá-lo.

4. MainComObstaculos

- Adiciona Bombas e Rochas no tabuleiro.

- A Bomba destrói o robô ao ser tocada.

- A Rocha faz o robô voltar à posição anterior.

- Simula o movimento até que um robô encontre o alimento ou ambos explodam.
