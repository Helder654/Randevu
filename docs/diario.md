# Diário de Desenvolvimento - Randevu

## Registro 01 - Estrutura inicial do jogo

Nesta etapa inicial, o projeto Randevu começou a ganhar sua base técnica. Foi criada a estrutura principal do jogo utilizando Java, com uma janela gráfica e um painel responsável pela renderização.

### O que foi feito

- Criação da janela principal do jogo;
- Criação do `GamePanel`;
- Implementação inicial do game loop;
- Separação das responsabilidades básicas entre janela, painel e execução principal;
- Primeiro desenho temporário em tela para validar a renderização.

### Aprendizados

Nesta fase, o foco foi entender como um jogo 2D simples pode funcionar em Java usando `JFrame`, `JPanel`, `Thread` e `Runnable`.

Também foi importante compreender a diferença entre:

- atualizar a lógica do jogo;
- redesenhar a tela;
- manter o jogo rodando em loop.

---

## Registro 02 - Movimento do jogador

Nesta etapa, o projeto passou a ter um jogador controlável pelo teclado.

### O que foi feito

- Criação da classe `Player`;
- Criação da classe `KeyHandler`;
- Implementação da movimentação do jogador;
- Leitura das teclas direcionais;
- Atualização da posição `x` e `y` do player;
- Limitação do movimento dentro da tela.

### Aprendizados

Foi possível entender melhor como a entrada do teclado se conecta com a lógica do jogo.

O `KeyHandler` ficou responsável por detectar as teclas pressionadas, enquanto o `Player` passou a usar essas informações para atualizar sua posição.

Também foi implementado o controle de limites da tela, impedindo que o personagem ultrapasse as bordas.

---

## Registro 03 - Direção do personagem

Nesta etapa, o player passou a armazenar a direção para onde está olhando.

### O que foi feito

- Adicionada a variável `direction`;
- A direção é atualizada conforme o movimento:
  - `up`;
  - `down`;
  - `left`;
  - `right`;
- Exibição temporária da direção na tela para testes.

### Aprendizados

A direção do personagem será importante para funcionalidades futuras, como:

- escolher o sprite correto;
- interagir com NPCs;
- abrir baús;
- entrar em portas;
- verificar objetos à frente do jogador.

Mesmo sendo uma mudança simples, ela prepara o jogo para sistemas mais complexos.

---

## Registro 04 - Classe base Entity

Nesta etapa, o projeto recebeu uma classe base para representar entidades do jogo.

### O que foi feito

- Criação da classe `Entity`;
- Atributos comuns foram movidos para essa classe:
  - `x`;
  - `y`;
  - `speed`;
  - `width`;
  - `height`;
  - `direction`;
- A classe `Player` passou a herdar de `Entity`.

### Aprendizados

A criação da classe `Entity` ajudou a organizar melhor a estrutura do projeto.

A ideia é que, futuramente, outras classes também possam herdar dela, como:

- NPCs;
- pets;
- inimigos;
- objetos interativos.

Essa mudança não alterou diretamente o comportamento visual do jogo, mas deixou o código mais preparado para crescer.

---

## Registro 05 - Sprite inicial do jogador

Nesta etapa, o player deixou de ser representado apenas por um retângulo e passou a ser renderizado com sprite em pixel art.

### O que foi feito

- Criação dos sprites direcionais do jogador;
- Adição dos arquivos de imagem na pasta de recursos;
- Carregamento das imagens com `ImageIO`;
- Implementação da escolha do sprite com base na direção atual;
- Renderização do sprite no método `draw()`;
- Mantido fallback visual com retângulo branco caso alguma imagem não carregue;
- Ajuste do tamanho do jogador para `64x64`.

### Aprendizados

Foi possível entender como carregar imagens externas em um projeto Java e desenhá-las na tela usando `Graphics2D`.

Também foi identificado um problema comum no Windows: arquivos com extensão duplicada, como `.png.png`, podem fazer o Java não encontrar a imagem corretamente.

O carregamento de imagens atualmente usa `File`, pois o projeto ainda está em uma estrutura Java simples, sem Maven ou Gradle configurado.

### Screenshot

![Player sprite](screenshots/player-sprite.png)

---

## Próximos estudos

Os próximos passos planejados são:

- melhorar o carregamento de recursos;
- criar animação de caminhada;
- separar tamanho visual do player e área de colisão;
- iniciar sistema de tiles/mapa;
- implementar colisão com cenário;
- criar NPC inicial;
- criar sistema simples de diálogo.