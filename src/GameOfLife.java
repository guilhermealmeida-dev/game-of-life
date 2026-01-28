public class GameOfLife {

    public static void imprimirEstado(int[][] estadoParaImprimir, int linhas, int colunas) {
        for (int linha = 0; linha < linhas; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                System.out.print(estadoParaImprimir[linha][coluna] + " ");
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

    // Definir a Matriz:
    // Definir o Estado Inicial:
    // Iniciar uma Nova Geração:
    // Criação do "Próximo Estado":
    // Avaliação Célula por Célula
    // Contagem de Vizinhança:
    // Aplicação das Regras: Com base no estado atual da célula e na contagem de
    // vizinhos vivos
    // Registro do Novo Estado:
    // Troca de Estado:
    // Visualização:
    // Repetição:

    /*
     * --------------------------------------------
     * REGRAS
     * --------------------------------------------
     * 
     * Pergunta: A célula está Morta ?
     * SE SIM: Vá para a Decisão de Nascimento (Próximo passo).
     * SE NÃO (Está Viva):
     * Vá para a Decisão de Sobrevivência/Solidão/Superpopulação.
     * 
     * Fluxo do "Morta":
     * Pergunta (Nascimento): vizinhos == 3?
     * SE SIM: O novo estado é VIVO (1). Terminar avaliação desta célula.
     * SE NÃO: O novo estado é MORTO (0). Terminar avaliação desta célula.
     * 
     * Fluxo do "Viva":
     * Pergunta (Sobrevivência/Solidão/Superpopulação): visinhos igual a 2 ou 3?
     * SE SIM (Sobrevive): O novo estado é VIVO (1). Terminar avaliação desta
     * célula.
     * SE NÃO (Morre): O novo estado é MORTO (0). Terminar avaliação desta célula.
     */

    public static void main(String[] args) {
        int numeroLinhas = 10;
        int numeroColunas = 10;
        int numeroGeracoes = 20;

        int[][] estado = new int[numeroLinhas][numeroColunas];

        for (int linha = 0; linha < numeroLinhas; linha++) {
            for (int coluna = 0; coluna < numeroColunas; coluna++) {
                estado[linha][coluna] = (int) (Math.random() * 2);
            }
        }

        for (int geracao = 1; geracao <= numeroGeracoes; geracao++) {

            int[][] novoEstado = new int[numeroLinhas][numeroColunas];

            for (int linha = 0; linha < numeroLinhas; linha++) {
                for (int coluna = 0; coluna < numeroColunas; coluna++) {

                    int celula = estado[linha][coluna];

                    int acima = (linha - 1 >= 0) ? estado[linha - 1][coluna] : 0;
                    int abaixo = (linha + 1 < numeroLinhas) ? estado[linha + 1][coluna] : 0;

                    int esquerda = (coluna - 1 >= 0) ? estado[linha][coluna - 1] : 0;
                    int direita = (coluna + 1 < numeroColunas) ? estado[linha][coluna + 1] : 0;

                    int diagonalSuperiorEsquerda = (linha - 1 >= 0) && (coluna - 1 >= 0) ? estado[linha - 1][coluna - 1]
                            : 0;
                    int diagonalSuperiorDireita = (linha - 1 >= 0) && (coluna + 1 < numeroColunas)
                            ? estado[linha - 1][coluna + 1]
                            : 0;

                    int diagonalInferiorEsquerda = (linha + 1 < numeroLinhas) && (coluna - 1 >= 0)
                            ? estado[linha + 1][coluna - 1]
                            : 0;
                    int diagonalInferiorDireita = (linha + 1 < numeroLinhas) && (coluna + 1 < numeroColunas)
                            ? estado[linha + 1][coluna + 1]
                            : 0;

                    int[] visinhos = new int[] {
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
                        if (visinhos[i] == 1) {
                            numeroVizinhosVivos++;
                        }
                    }

                    if (celula == 0) {
                        // Fluxo morta
                        celula = (numeroVizinhosVivos == 3) ? 1 : 0;
                    } else {
                        // Fluxo viva
                        celula = (numeroVizinhosVivos == 2) || (numeroVizinhosVivos == 3) ? 1 : 0;
                    }

                    novoEstado[linha][coluna] = celula;
                }
            }

            imprimirEstado(estado, numeroLinhas, numeroColunas);
            estado = novoEstado;
            clearConsole(1);
        }

    }
}