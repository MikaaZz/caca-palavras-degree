import java.util.Scanner;

public class GuilhermeJoaoMikhaelTrabalhoFinal {
    private GuilhermeJoaoMikhaelTrabalhoFinal() {
        Scanner scanner = new Scanner(System.in);
        final int palavrasLinhasTamanho = 5, palavrasColunasTamanho = 2, mapaLinhasTamanho = 10, mapaColunasTamanho = 5;
        String[][] palavras = new String[palavrasLinhasTamanho][palavrasColunasTamanho];
        char[][] mapa = new char[mapaLinhasTamanho][mapaColunasTamanho];
        boolean usuarioEscolhendo = true;

        palavrasEntrada(palavras);
        mapaEntrada(mapa);
        mapaPesquisa(palavras, mapa);

        do {
            System.out.println("_____ Menu: Caça Palavras _____");
            System.out.println("1. listar palavras");
            System.out.println("2. listar mapa");
            System.out.println("3. listar respostas");
            System.out.println("4. sair");
            System.out.print("__ opção: ");
            int usuarioEscolha = scanner.nextInt();
            switch (usuarioEscolha) {
                case 1:
                    palavrasImprimir(palavras);
                    break;
                case 2:
                    mapaImprimir(palavras, mapa, mapaLinhasTamanho, mapaColunasTamanho);
                    break;
                case 3:
                    palavrasResposta(palavras);
                    break;
                case 4:
                    usuarioEscolhendo = false;
                    break;
                default:
                    System.out.println("Opção ERRADA, tente novamente!...");
                    break;
            }
        } while (usuarioEscolhendo);

        scanner.close();
    }

    private void palavrasEntrada(String[][] palavras) {
        for (int i = 0; i < palavras.length; i++) {
            if (i == 0) {
                palavras[i][0] = "IFELSE";
            } else if (i == 1) {
                palavras[i][0] = "FORA";
            } else if (i == 2) {
                palavras[i][0] = "WHILE";
            } else if (i == 3) {
                palavras[i][0] = "OBJETO";
            } else if (i == 4) {
                palavras[i][0] = "VETOR";
            }
        }
    }

    private void palavrasImprimir(String[][] palavras) {
        for (int i = 0; i < palavras.length; i++) {
            System.out.println(palavras[i][0]);
        }
    }

    private void palavrasResposta(String[][] palavras) {
        for (int i = 0; i < palavras.length; i++) {
            String palavra = palavras[i][0];
            String resultado = palavras[i][1];

            if (resultado == null || resultado.equals("Palavra NÃO encontrada")) {
                System.out.println("Palavra NÃO encontrada: " + palavra);
            } else {
                System.out.println(resultado + " - " + palavra);
            }
        }
    }

    private void mapaEntrada(char[][] mapa) {
        mapa[0][0] = 'D';
        mapa[0][1] = 'C';
        mapa[0][2] = 'Q';
        mapa[0][3] = 'W';
        mapa[0][4] = 'E';
        mapa[1][0] = 'I';
        mapa[1][1] = 'X';
        mapa[1][2] = 'F';
        mapa[1][3] = 'O';
        mapa[1][4] = 'R';
        mapa[2][0] = 'F';
        mapa[2][1] = 'F';
        mapa[2][2] = 'R';
        mapa[2][3] = 'G';
        mapa[2][4] = 'F';
        mapa[3][0] = 'E';
        mapa[3][1] = 'L';
        mapa[3][2] = 'I';
        mapa[3][3] = 'H';
        mapa[3][4] = 'W';
        mapa[4][0] = 'L';
        mapa[4][1] = 'S';
        mapa[4][2] = 'F';
        mapa[4][3] = 'O';
        mapa[4][4] = 'U';
        mapa[5][0] = 'S';
        mapa[5][1] = 'D';
        mapa[5][2] = 'G';
        mapa[5][3] = 'T';
        mapa[5][4] = 'S';
        mapa[6][0] = 'E';
        mapa[6][1] = 'J';
        mapa[6][2] = 'H';
        mapa[6][3] = 'E';
        mapa[6][4] = 'T';
        mapa[7][0] = 'I';
        mapa[7][1] = 'I';
        mapa[7][2] = 'I';
        mapa[7][3] = 'J';
        mapa[7][4] = 'M';
        mapa[8][0] = 'X';
        mapa[8][1] = 'C';
        mapa[8][2] = 'K';
        mapa[8][3] = 'B';
        mapa[8][4] = 'G';
        mapa[9][0] = 'V';
        mapa[9][1] = 'E';
        mapa[9][2] = 'T';
        mapa[9][3] = 'O';
        mapa[9][4] = 'R';
    }

    private void mapaPesquisa(String[][] palavras, char[][] mapa) {
        for (int i = 0; i < palavras.length; i++) {
            // Pegando a palavra da vez, nao foi preciso destruir em varias letras
            String palavra = palavras[i][0];
            // Aqui segui com a mesma logica do encontrada, mas aplicando de outro jeito no
            // codigo
            boolean encontrada = false;

            // Em vez de fazer o IF, adicionei a validação aqui dentro do for ( !encontrada
            // )
            // Usei o nome linha ao inves de j para ficar mais facil de entender o codigo
            for (int linha = 0; linha < mapa.length && !encontrada; linha++) {
                // Em vez de fazer o IF, adicionei a validação aqui dentro do for ( !encontrada
                // )
                // Usei o nome coluna ao inves de j2 para ficar mais facil de entender o codigo
                for (int coluna = 0; coluna < mapa[linha].length && !encontrada; coluna++) {
                    encontrada = buscaHorizontalEsquerdaDireita(palavra, mapa, linha, coluna) ||
                            buscaHorizontalDireitaEsquerda(palavra, mapa, linha, coluna) ||
                            buscaVerticalCimaBaixo(palavra, mapa, linha, coluna) ||
                            buscaVerticalBaixoCima(palavra, mapa, linha, coluna);

                    if (encontrada) {
                        palavras[i][1] = "[" + linha + ", " + coluna + "]";
                    }
                }
            }

            if (!encontrada) {
                palavras[i][1] = "Palavra NÃO encontrada";
            }
        }
    }

    private boolean buscaHorizontalEsquerdaDireita(String palavra, char[][] mapa, int linha, int colunaInicial) {
        // Aqui fiz aquela validação que voce havia sugerido, de verificar o tamanho da
        // palavra com o espaco de sobra
        // se tiver menos espacos do que a palavra, manda um false
        if (colunaInicial + palavra.length() > mapa[linha].length)
            return false;
        // Aqui usei a mesma logica de percorrer a linha ou coluna ( ... + i )
        for (int i = 0; i < palavra.length(); i++) {
            // Nesse if, ele pega a celula do mapa + 1 e compara com o a letra i da String,
            // se nao "bater" ele retorna false
            if (mapa[linha][colunaInicial + i] != palavra.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean buscaHorizontalDireitaEsquerda(String palavra, char[][] mapa, int linha, int colunaFinal) {
        // Aqui faz o mesmo, mas de tras para frente
        if (colunaFinal < palavra.length() - 1)
            return false;

        for (int i = 0; i < palavra.length(); i++) {
            if (mapa[linha][colunaFinal - i] != palavra.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean buscaVerticalCimaBaixo(String palavra, char[][] mapa, int linhaInicial, int coluna) {
        // Aqui ele ta somando a linha inicial com o tamanho da palavra e vendo se cabe
        // no mapa
        if (linhaInicial + palavra.length() > mapa.length)
            return false;

        for (int i = 0; i < palavra.length(); i++) {
            if (mapa[linhaInicial + i][coluna] != palavra.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean buscaVerticalBaixoCima(String palavra, char[][] mapa, int linhaFinal, int coluna) {
        if (linhaFinal < palavra.length() - 1)
            return false;

        for (int i = 0; i < palavra.length(); i++) {
            if (mapa[linhaFinal - i][coluna] != palavra.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private void mapaImprimir(String[][] palavras, char[][] mapa, int mapaLinhasTamanho, int mapaColunasTamanho) {
        // Escrever
        for (int i = 0; i < mapaColunasTamanho - 1; i++) {
            System.out.print("---------------------");
        }
        System.out.println();
        for (int l = 0; l < mapaLinhasTamanho; l++) {
            for (int c = 0; c < mapaColunasTamanho; c++) {

                if (mapa[l][c] < 10) { // _1
                    System.out.print("|  " + mapa[l][c] + " ");
                } else { // 10
                    System.out.print("| " + mapa[l][c] + " ");
                }
            }
            System.out.println("|");
        }
        for (int i = 0; i < mapaColunasTamanho - 1; i++) {
            System.out.print("---------------------");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        new GuilhermeJoaoMikhaelTrabalhoFinal();
    }
}
