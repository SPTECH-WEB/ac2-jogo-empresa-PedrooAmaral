[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/PzSTEYQK)
### Avaliação continuada 2 - Linguagem de Programação

Você deve implementar as classes **Jogo** e **Empresa** de acordo com as especificações a seguir. As classes estão
vazias e já possuem testes prontos que validarão o seu código. O objetivo é implementar as classes de modo que todos os
testes passem.

#### 1. Classe **Jogo**

A classe `Jogo` deve representar um jogo de videogame com as seguintes características:

- **Atributos**:
    - `String codigo`: Código único que identifica o jogo.
    - `String nome`: Nome do jogo.
    - `String genero`: Gênero do jogo (ex: Ação, Aventura, RPG).
    - `Double preco`: Preço do jogo.
    - `Double avaliacao`: Avaliação do jogo em uma escala de 0 a 5.
    - `LocalDate dataLancamento`: Data de lançamento do jogo.

- **Construtores**:
    - Um **construtor sem argumentos**.

- **Getters e Setters**:
    - **Getter** e **Setter** para todos os atributos: `codigo`, `nome`, `genero`, `preco`, `avaliacao` e `dataLancamento`.

- **Métodos**:
    - `String getAvaliacaoDescricao()`: Esse método deve retornar uma descrição baseada na avaliação do jogo:
        - Se a avaliação for maior ou igual a 4.5, retornar `"EXCELENTE"`.
        - Se a avaliação for maior ou igual a 3.5, retornar `"BOM"`.
        - Se a avaliação for maior ou igual a 2.5, retornar `"REGULAR"`.
        - Caso contrário, retornar `"RUIM"`.

  > **Exceções**: Não há necessidade de lançar exceções nessa classe.

---

#### 2. Classe **Empresa**

A classe `Empresa` deve representar uma empresa de jogos que gerencia uma lista de jogos.

- **Atributos**:
    - `String nome`: Nome da empresa.
    - `List<Jogo> jogos`: Lista de jogos que a empresa gerencia.

- **Construtores**:
    - Um **construtor sem argumentos**.

- **Getters**:
    - **Getter e Setter** para o atributo `nome`.
    - **Getter** para o atributo `jogos` (não deve haver um setter para `jogos`).

  - **Métodos**:
      - `void adicionarJogo(Jogo jogo)`: Adiciona um jogo à lista de jogos da empresa.

        - **Comportamento esperado**:
          - jogo: O jogo a ser adicionado não pode ser nulo. Se o jogo for nulo, lançar uma `JogoInvalidoException`.
          - código: O código do jogo deve ser válido (não nulo e não vazio). Se o código for inválido, lançar
            uma `JogoInvalidoException`.
          - nome: O nome do jogo deve ser válido (não nulo e não vazio). Se o nome for inválido, lançar
            uma `JogoInvalidoException`.
          - gênero: O gênero do jogo deve ser válido (não nulo e não vazio). Se o gênero for inválido, lançar
            uma `JogoInvalidoException`.
          - preço:  O preço do jogo deve ser maior que zero e não nulo. Se o preço for inválido (por exemplo, valor menor ou igual a zero ), lançar a exceção `JogoInvalidoException`.
          - avaliação: A avaliação do jogo deve estar dentro do intervalo de 0 a 5. Se a avaliação estiver fora desse
            intervalo, lançar uma `JogoInvalidoException`.
          - data de lançamento: A data de lançamento do jogo deve ser válida (não nula e não pode ser uma data futura). Sea data de lançamento for inválida ou estiver no futuro, lançar a exceção `JogoInvalidoException`.

      - `Jogo buscarJogoPorCodigo(String codigo)`: Busca um jogo na lista de jogos pelo seu código.
          - **Comportamento esperado**:
              - Deve validar se o código fornecido não é nulo, vazio ou em branco.
              - Se o código for inválido, deve lançar uma `ArgumentoInvalidoException`.
              - Se o jogo não for encontrado, deve lançar uma `JogoNaoEncontradoException`.
    
      - `void removerJogoPorCodigo(String codigo)`: Remove um jogo da lista com base no seu código.
          - **Comportamento esperado**:
              - Se o jogo não for encontrado, deve lançar uma `JogoNaoEncontradoException`.
              - Se o código fornecido for nulo, vazio ou em branco, deve lançar uma `ArgumentoInvalidoException`.

      - `Jogo buscarJogoComMelhorAvaliacao()`: Busca o jogo com a melhor avaliação.
          - **Comportamento esperado**:
              - Se dois ou mais jogos tiverem a mesma avaliação, deve-se retornar o mais recente (com a data de lançamento
                mais recente).
              - Se não houver jogos na lista, deve lançar uma `JogoNaoEncontradoException`.
          
              - **Observação**: Considere que nos cenários a serem testados, não existe a possibilidade de dois jogos terem a mesma avaliação e a mesma data de lançamento. 

      - `List<Jogo> buscarJogoPorPeriodo(LocalDate dataInicio, LocalDate dataFim)`: Retorna uma lista de jogos cujo
        lançamento esteja entre as datas de início e fim fornecidas.
          - **Comportamento esperado**:
              - Se as datas de início ou fim forem nulas, ou se a data de início for maior que a data de fim, deve lançar
                uma `ArgumentoInvalidoException`.
              - Deve retornar uma lista de jogos cuja data de lançamento esteja dentro do intervalo fornecido (inclusive).

> **Observação**: O foco da atividade é implementar a lógica dos métodos e suas validações de acordo com as
> especificações, sem alterar os testes.

#### Instruções Adicionais

- As exceções `ArgumentoInvalidoException`, `JogoInvalidoException` e `JogoNaoEncontradoException` já estão definidas no
  projeto. Utilize-as conforme especificado.
- Todos os métodos e construtores devem ter visibilidade pública (`public`).
- A lista de jogos (`jogos`) deve ser inicializada nos construtores, e não deve haver um setter para este atributo.

> **Dica**: Teste frequentemente seu código. O objetivo é que todos os testes fornecidos passem corretamente.
