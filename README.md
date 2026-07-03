# 🎮 Randevu — Jogo 2D em Java

Randevu é um jogo 2D desenvolvido em Java utilizando Swing.

O projeto está sendo construído com foco em aprendizado, aplicando conceitos de Programação Orientada a Objetos, arquitetura de software, desenvolvimento de jogos e boas práticas de programação.

Todo o desenvolvimento é realizado de forma incremental, priorizando o entendimento dos conceitos antes da implementação das funcionalidades.

---

# Objetivos

- Aprender desenvolvimento de jogos em Java.
- Praticar Programação Orientada a Objetos.
- Aplicar boas práticas de arquitetura.
- Utilizar Git e GitHub profissionalmente.
- Construir um projeto para portfólio.

---

# Tecnologias

- Java
- Java Swing
- Git
- GitHub

---

# Estrutura do Projeto

```
Randevu
│
├── docs/
│   ├── arquitetura.md
│   ├── diario.md
│   └── roadmap.md
│
├── src/
│   └── main/
│       ├── java/
│       └── resources/
│
├── README.md
└── LICENSE
```

---

# Arquitetura

```
Main
│
└── GameWindow
        │
        └── GamePanel
                │
                ├── Thread
                ├── Game Loop
                ├── Update
                └── Renderização
```

---

# Status do Projeto

## ✅ Concluído

- Estrutura inicial do projeto
- Organização dos pacotes
- Configuração da janela principal
- Thread principal
- Game Loop baseado em Delta Time
- Sistema básico de renderização
- Primeiro objeto desenhado na tela
- Documentação do projeto

## 🚧 Em desenvolvimento

- Classe Player
- Entrada de teclado
- Sistema de entidades
- Sistema de Tiles

---

# Roadmap

- [x] Estrutura inicial
- [x] GameWindow
- [x] GamePanel
- [x] Thread
- [x] Game Loop
- [x] Delta Time
- [x] Renderização inicial
- [ ] Player
- [ ] Entrada de teclado
- [ ] Colisão
- [ ] Sistema de Tiles
- [ ] NPCs
- [ ] Inventário

---

# Filosofia do Projeto

O objetivo deste projeto não é apenas produzir um jogo funcional.

Cada etapa é desenvolvida após o estudo dos conceitos necessários, permitindo compreender o funcionamento interno das tecnologias utilizadas antes da implementação.

Além do código, o projeto mantém documentação da arquitetura, decisões técnicas e evolução do desenvolvimento.

---
## Status atual do desenvolvimento

O projeto já possui uma estrutura inicial funcional com:

- Janela principal do jogo criada com Java Swing;
- Game loop com atualização e renderização;
- Controle de movimento do jogador pelo teclado;
- Classe base `Entity` para organizar personagens e futuras entidades;
- Player com posição, velocidade, direção e limites de tela;
- Carregamento de sprites direcionais para o personagem jogável.

### Primeiro sprite do jogador

O player já é renderizado em tela utilizando sprite em pixel art:

![Player sprite](docs/screenshots/player-sprite.png)
--------------

# Autor

**Hélder Augusto Gonçalves Ferreira**

GitHub:
https://github.com/Helder654