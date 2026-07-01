# Diário de Desenvolvimento

---

# Aula 1 - Estrutura do Projeto

## Objetivo

Criar a estrutura inicial do projeto.

## O que foi desenvolvido

- Organização dos pacotes.
- Classe Main.
- Classe GameWindow.
- Classe GamePanel.

## Conceitos estudados

- JFrame
- JPanel
- Organização de projetos Java
- Responsabilidade das classes

---

# Aula 2 - Thread e Game Loop

## Objetivo

Criar a estrutura principal responsável pelo funcionamento contínuo do jogo.

## Conceitos estudados

- Interfaces
- Runnable
- Thread
- Método run()

## O que foi desenvolvido

- Criação da Thread principal.
- Método startGameThread().
- Estrutura inicial do Game Loop.

## Decisões de arquitetura

- O GamePanel será responsável pelo Game Loop.
- O GameWindow inicia a Thread.
- O construtor apenas prepara os objetos.

---

# Aula 3 - Delta Time e Renderização

## Objetivo

Construir um Game Loop com controle de FPS e iniciar o sistema de renderização.

## Conceitos estudados

- Delta Time
- FPS
- repaint()
- paintComponent(Graphics)
- Graphics
- Sistema de coordenadas 2D

## O que foi desenvolvido

- Controle do Game Loop utilizando Delta Time.
- Método update().
- Integração entre update() e repaint().
- Implementação de paintComponent().
- Primeiro objeto desenhado na tela.

## Decisões de arquitetura

- O Game Loop apenas controla o fluxo.
- Toda lógica permanece em update().
- Toda renderização permanece em paintComponent().
- O Delta Time controla quando um novo frame deve ser processado.

## Próximos passos

- Criar a classe Player.
- Implementar o teclado.
- Movimentar o jogador.
- Organizar o sistema de entidades.