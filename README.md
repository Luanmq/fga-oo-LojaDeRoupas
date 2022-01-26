# Trabalhos_O.O

Especificação do Trabalho Prático 1 (TP1)

Escreva um programa em Java que implemente o jogo da forca. O seu jogo deve exibir um menu
inicial com as opções: “1. Gerenciar Temas”, “2. Gerenciar Palavras”, “3. Jogar” e “4. Sair”. O
detalhamento de cada uma das opções é apresentada a seguir:

1. Gerenciar Temas: o programa deverá ser capaz de armazenar até 50 diferentes temas.
  (a) Cadastro: o usuário poderá cadastrar temas no programa. Não poderão existir temas com
  nomes iguais.
  (b) Exclusão: o usuário poderá excluir temas desde que não existam palavras associadas a ele.
  Caso não seja possível realizar exclusão, o programa deverá exibir e mensagem “Não foi
  possível excluir o tema. Verifique se existem palavras cadastradas nesse tema.”
  (c) Busca: o usuário poderá buscar por temas cadastrados no sistema.

2. Gerenciar Palavras: o programa deverá ser capaz de armazenar até 50 palavras para cada um
dos temas cadastrados.
  (a) Cadastro: o usuário poderá cadastrar palavras no programa. Para tanto, ele deve escolher
  um tema e só então realizar o cadastro. Atenção! não poderão existir palavras iguais dentro
  de um mesmo tema.
  (b) Exclusão: o usuário poderá excluir palavras cadastradas no programa.
  (c) Busca: o usuário deve ser capaz de buscar por uma palavra no conjunto de todas as palavras
  cadastradas no programa. Caso uma palavra não seja encontrada, deve ser retornada a
  mensagem “Palavra não encontrada”, caso contrário a mensagem a ser retornada é “Palavra
  encontrada no tema XYZ”, onde XYZ é o tema em que a palavra está.
  (d) Listagem: o usuário poderá selecionar um tema e ver todas as palavras cadastrada naquele
  tema.

3. Jogar
  (a) Seleção de tema: antes de iniciar um jogo, o usuário deverá selecionar um tema onde será
  buscada a palavra.
  (b) Jogo:
    i. Em cada rodada, o usuário deve escolher uma letra.
    ii. Caso a letra já tenha sido tentada, o programa deverá mostrar a mensagem: “Tente
    outra letra!”
    iii. Para cada letra tentada pelo usuário e não presente na palavra, deverá ser contabilizado
    um erro.
    iv. O usuário poderá ter no máximo cinco erro. Após a quinta tentativa errada, o programa
    deverá mostrar a mensagem “Você perdeu! Deseja Deseja jogar novamente?”. Não é
    necessário mostrar a palavra no final da partida.
    v. Caso o usuário acerte a palavra, o programa deverá mostrar a mensagem: “Parabéns!
    Você acertou a palavra! Deseja jogar novamente?”.
  (c) Jogar novamente: caso o usuário, ao final de um jogo, decida jogar novamente, deve ser
  mostrada novamente a opção de escolha de tema. Depois disso, um novo jogo é iniciado.
  (d) Sair: caso o usuário decida não jogar novamente, o programa deve mostrar o menu inicial.
4. Sair. O programa deverá imprimir o menu inicial até que essa opção seja escolhida. Caso a opção
“Sair” seja escolhida, o programa irá se encerrar.
