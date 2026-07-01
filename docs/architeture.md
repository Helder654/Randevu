# Arquitetura do Projeto

## Objetivo

O Randevu é um jogo 2D desenvolvido em Java utilizando Swing.

O projeto tem como objetivo principal o aprendizado de desenvolvimento de jogos, Programação Orientada a Objetos, arquitetura de software e boas práticas de programação.

Todo o desenvolvimento é realizado de forma incremental, buscando compreender cada conceito antes da implementação.

---

# Estrutura Atual

```
Main
│
└── GameWindow (JFrame)
        │
        └── GamePanel (JPanel)
                │
                ├── Thread principal
                ├── Game Loop
                ├── Update
                └── Renderização
```

---

# Responsabilidade das Classes

## Main

Responsável por iniciar a aplicação.

Funções:

- Iniciar o programa.
- Criar a janela principal.

---

## GameWindow

Responsável pela configuração da janela.

Funções:

- Configurar o JFrame.
- Criar o GamePanel.
- Adicionar o painel à janela.
- Tornar a janela visível.
- Iniciar o Game Loop.

---

## GamePanel

Representa o núcleo do jogo.

Funções:

- Executar o Game Loop.
- Atualizar a lógica do jogo.
- Controlar a renderização.
- Futuramente controlar:
    - jogador;
    - entidades;
    - colisões;
    - mapa;
    - câmera.

---

# Game Loop

O projeto utiliza um Game Loop baseado em Delta Time.

Fluxo de execução:

```
Thread
    │
    ▼
run()
    │
    ▼
while (running)
    │
    ├── calcular tempo decorrido
    ├── acumular delta
    ├── update()
    └── repaint()
            │
            ▼
paintComponent(Graphics)
```

---

# Variáveis do Game Loop

### drawInterval

Tempo ideal entre dois frames.

---

### lastTime

Armazena o instante da última atualização.

---

### currentTime

Armazena o instante atual.

---

### elapsedTime

Representa quanto tempo passou entre duas iterações.

---

### delta

Controla quando um novo frame deve ser atualizado.

Quando delta atinge o valor 1, um novo frame é processado.

---

# Princípios utilizados

- Separação de responsabilidades
- Encapsulamento
- Código limpo
- Evolução incremental
- Arquitetura simples e escalável