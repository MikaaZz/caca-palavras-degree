import java.util.Scanner;

public class TrabalhoFinal {
    private TrabalhoFinal() {
        Scanner scanner = new Scanner(System.in);
        final int palavrasLinhasTamanho = 5, palavrasColunasTamanho = 2, mapaLinhasTamanho = 10, mapaColunasTamanho = 5;
        String[][] palavras = new String[palavrasLinhasTamanho][palavrasColunasTamanho];
        char[][] mapa = new char[mapaLinhasTamanho][mapaColunasTamanho];
        boolean usuarioEscolhendo = true;

        palavrasEntrada(palavras);
        mapaEntrada(mapa);
        mapaPesquisa(palavras, mapa, mapaLinhasTamanho, mapaColunasTamanho);

        do {
            System.out.println("_____ Menu: Caça Palavras _____");
            System.out.println("1. listar palavras");
            System.out.println("2. listar mapa");
            System.out.println("3. listar respostas");
            System.out.println("4. sair");
            int usuarioEscolha = scanner.nextInt();
            switch (usuarioEscolha) {
                case 1:
                    palavrasImprimir(palavras);
                    break;
                case 2:
                    mapaImprimir(palavras, mapa, mapaLinhasTamanho, mapaColunasTamanho);
                    break;
                case 3:
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

    private void palavrasResposta() {
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

    private void mapaPesquisa(String[][] palavras, char[][] mapa, int mapaLinhasTamanho,
            int mapaColunasTamanho) {

        for (int i = 0; i < palavras.length; i++) {
            char[] letras = palavras[i][0].toCharArray();
            boolean procurando = true;
            // Varrendo mapa na coluna
            for (int j = 0; j < mapa.length; j++) {
                // Varrendo mapa na linha
                for (int j2 = 0; j2 < mapa[j].length; j2++) {
                    if (letras[0] == mapa[j][j2] && procurando) {
                        for (int k = 1; k < letras.length; k++) {
                            pesquisa(letras, j, j2, mapa, k);
                            // palavras[i][1] = "[" + j + " , " + j2 + "]";
                            procurando = false;
                        }
                    }
                    if (!procurando)
                        break;
                }
                if (!procurando)
                    break;
            }
        }

    }

    private void pesquisa(char[] letras, int j, int j2, char[][] mapa, int k) {

        if (letras.length >= j2 + k) {
            if (j2 + k >= 0 && j2 + k < 5 && letras[j2 + k] == mapa[j][j2 + k]) {
                System.out.println("Achou a letra " + (k) + " : " + mapa[j][j2 + k]);
            } else if (j + k >= 0 && j2 + k < 10 && letras[j2 + k] == mapa[j + k][j2]) {
                System.out.println("Achou a letra " + (k) + " : " + mapa[j + k][j2]);
            } else if (j2 - k >= 0 && j2 + k < 5 && letras[j2 + k] == mapa[j][j2 - k]) {
                System.out.println("Achou a letra " + (k) + " : " + mapa[j + k][j2 - k]);
            } else if (j - k >= 0 && j2 + k < 10 && letras[j2 + k] == mapa[j - k][j2]) {
                System.out.println("Achou a letra " + (k) + " : " + mapa[j - k][j2]);
            }
        }

        // if (letras.length >= j2 + k) {
        // if ((j2 - k) <= (letras.length - 1) && letras[j2 + k] == mapa[j][j2 + k]) {
        // System.out.println("Achou a letra " + (k) + " : " + mapa[j][j2 + k]);
        // } else if ((j - k) <= (letras.length - 1) && letras[j2 + k] == mapa[j +
        // k][j2]) {
        // System.out.println("Achou a letra " + (k) + " : " + mapa[j + k][j2]);
        // } else if ((j2 - k) <= (letras.length - 1) && letras[j2 + k] == mapa[j][j2 -
        // k]) {
        // System.out.println("Achou a letra " + (k) + " : " + mapa[j + k][j2 - k]);
        // } else if ((j - k) <= (letras.length - 1) && letras[j2 + k] == mapa[j -
        // k][j2]) {
        // System.out.println("Achou a letra " + (k) + " : " + mapa[j - k][j2]);
        // }
        // }

    }

    private void mapaImprimir(String[][] palavras, char[][] mapa, int mapaLinhasTamanho, int mapaColunasTamanho) {
        // Escrever
        for (int i = 0; i < mapaColunasTamanho - 1; i++) {
            System.out.print("-------");
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
            System.out.print("-------");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        new TrabalhoFinal();
    }
}
