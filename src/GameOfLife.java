import java.util.Random;

public class GameOfLife {

    public static void imprimirEstado(String[][] estadoParaImprimir, int linhas, int colunas) {
        for (int linha = 0; linha < linhas; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {

                String simbolo = estadoParaImprimir[linha][coluna].equals("1")
                        ? "❤️ "
                        : "⬜";

                System.out.print(simbolo + " ");
            }
            System.out.println();
        }
    }

    public static void clearConsole(int seconds) {

        try {
            Thread.sleep(seconds * 1000);

            String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {

                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {

            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    /*
     * --------------------------------------------
     * REGRAS
     * --------------------------------------------
     * 
     * Pergunta: A célula está Morta ?
        * SE SIM: Vá para a Decisão de Nascimento.
        * SE NÃO (Está Viva): Vá para a Decisão de Sobrevivência/Solidão/Superpopulação.
     * 
     * Fluxo do "Morta":
        * Pergunta (Nascimento): vizinhos == 3?
        * SE SIM: O novo estado é VIVO (1). Terminar avaliação desta célula.
        * SE NÃO: O novo estado é MORTO (0). Terminar avaliação desta célula.
     * 
     * Fluxo do "Viva":
        * Pergunta (Sobrevivência/Solidão/Superpopulação): vizinhos igual a 2 ou 3?
        * SE SIM (Sobrevive): O novo estado é VIVO (1). Terminar avaliação desta
        * célula.
        * SE NÃO (Morre): O novo estado é MORTO (0). Terminar avaliação desta célula.
     */

    public static void main(String[] args) {
        int numeroLinhas = 20;
        int numeroColunas = 30;
        int numeroGeracoes = 50;

        String[][] estado = new String[numeroLinhas][numeroColunas];

        for (int linha = 0; linha < numeroLinhas; linha++) {
            for (int coluna = 0; coluna < numeroColunas; coluna++) {
                Random random = new Random();
                estado[linha][coluna] = random.nextBoolean() ? "1" : "0";
            }
        }

        for (int geracao = 1; geracao <= numeroGeracoes; geracao++) {

            String[][] novoEstado = new String[numeroLinhas][numeroColunas];

            for (int linha = 0; linha < numeroLinhas; linha++) {
                for (int coluna = 0; coluna < numeroColunas; coluna++) {

                    String celula = estado[linha][coluna];

                    String acima = (linha - 1 >= 0) ? estado[linha - 1][coluna] : "0";
                    String abaixo = (linha + 1 < numeroLinhas) ? estado[linha + 1][coluna] : "0";

                    String esquerda = (coluna - 1 >= 0) ? estado[linha][coluna - 1] : "0";
                    String direita = (coluna + 1 < numeroColunas) ? estado[linha][coluna + 1] : "0";

                    String diagonalSuperiorEsquerda = (linha - 1 >= 0) && (coluna - 1 >= 0)
                            ? estado[linha - 1][coluna - 1]
                            : "0";
                    String diagonalSuperiorDireita = (linha - 1 >= 0) && (coluna + 1 < numeroColunas)
                            ? estado[linha - 1][coluna + 1]
                            : "0";

                    String diagonalInferiorEsquerda = (linha + 1 < numeroLinhas) && (coluna - 1 >= 0)
                            ? estado[linha + 1][coluna - 1]
                            : "0";
                    String diagonalInferiorDireita = (linha + 1 < numeroLinhas) && (coluna + 1 < numeroColunas)
                            ? estado[linha + 1][coluna + 1]
                            : "0";

                    String[] visinhos = new String[] {
                            acima,
                            abaixo,
                            direita,
                            esquerda,
                            diagonalSuperiorEsquerda,
                            diagonalSuperiorDireita,
                            diagonalInferiorEsquerda,
                            diagonalInferiorDireita
                    };

                    int numeroVizinhosVivos = 0;

                    for (int i = 0; i < 8; i++) {
                        if (visinhos[i].equals("1")) {
                            numeroVizinhosVivos++;
                        }
                    }

                    if (celula.equals("0")) {
                        // Fluxo morta
                        celula = (numeroVizinhosVivos == 3) ? "1" : "0";
                    } else {
                        // Fluxo viva
                        celula = (numeroVizinhosVivos == 2) || (numeroVizinhosVivos == 3) ? "1" : "0";
                    }

                    novoEstado[linha][coluna] = celula;
                }
            }

            imprimirEstado(estado, numeroLinhas, numeroColunas);
            estado = novoEstado;
            if(geracao==numeroGeracoes)break;
            clearConsole(1);
        }

    }
}