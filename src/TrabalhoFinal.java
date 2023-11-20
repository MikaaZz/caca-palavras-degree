import java.util.Scanner;

public class TrabalhoFinal {
    private TrabalhoFinal() {
        Scanner scanner = new Scanner(System.in);
        final int palavrasLinhasTamanho = 5, palavrasColunasTamanho = 2, mapaLinhasTamanho = 10, mapaColunasTamanho = 5;
        int[][] palavras = new int[palavrasLinhasTamanho][palavrasColunasTamanho],
                mapa = new int[mapaLinhasTamanho][mapaColunasTamanho];
        boolean usuarioEscolhendo = true;

        palavrasEntrada(palavras);

        do {
            System.out.println("_____ Menu: Caça Palavras _____");
            System.out.println("1. listar palavras");
            System.out.println("2. listar mapa");
            System.out.println("3. listar respostas");
            System.out.println("4. sair");
            int usuarioEscolha = scanner.nextInt();
            switch (usuarioEscolha) {
                case 1:
                    break;
                case 2:
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
    }

    private void palavrasEntrada(int[][] palavras) {
        for (int i = 0; i < palavras.length; i++) {
            
        }
    }

    private void mapaEntrada() {
    }

    private void mapaPesquisa() {
    }

    public static void main(String[] args) throws Exception {
        new TrabalhoFinal();
    }
}
