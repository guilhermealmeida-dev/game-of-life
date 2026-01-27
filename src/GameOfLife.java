public class GameOfLife {

    public static void imprimirEstado(int[][] estadoParaImprimir,int linhas, int colunas){
        for (int linha=0;linha<linhas;linha++){
            for (int coluna=0;coluna<colunas;coluna++){
                System.out.print(estadoParaImprimir[linha][coluna]+"\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numeroLinhas=4;
        int numeroColunas=4;
        int numeroGeracoes=5;

        int[][] estado= new int[numeroLinhas][numeroColunas];

        for (int linha=0;linha<numeroLinhas;linha++){
            for (int coluna=0;coluna<numeroColunas;coluna++){
                estado[linha][coluna]=(int)(Math.random()*2);
            }
        }

        for (int geracao=1; geracao <= numeroGeracoes; geracao++ ){

            int [][] novoEstado= new int[numeroLinhas][numeroColunas];

            for (int linha=0;linha<numeroLinhas;linha++){
                for (int coluna=0;coluna<numeroColunas;coluna++){

                    int celula=estado[linha][coluna];

                    int acima= (linha - 1 >= 0)? estado[linha-1][coluna]: 0;
                    int abaixo= (linha + 1 < numeroLinhas)? estado[linha+1][coluna]: 0;

                    int esquerda=(coluna - 1 >= 0)? estado[linha][coluna-1]: 0;
                    int direita= (coluna + 1 < numeroColunas)?estado[linha][coluna+1]: 0;

                    int diagonalSuperiorEsquerda=(linha - 1 >= 0)&&(coluna-1 >= 0)? estado[linha-1][coluna-1] :0;
                    int diagonalSuperiorDireita= (linha - 1 >= 0)&&(coluna + 1 < numeroColunas)?estado[linha-1][coluna+1]: 0;

                    int diagonalInferiorEsquerda=(linha + 1 < numeroLinhas)&&(coluna - 1 >= 0)? estado[linha+1][coluna-1]: 0;
                    int diagonalInferiorDireita=(linha + 1 < numeroLinhas)&&(coluna + 1 < numeroColunas)? estado[linha+1][coluna+1]: 0;

                    int[] visinhos={
                            acima,
                            abaixo,
                            direita,
                            esquerda,
                            diagonalSuperiorEsquerda,
                            diagonalSuperiorDireita,
                            diagonalInferiorEsquerda,
                            diagonalInferiorDireita
                    };

                    if (celula==0){

                    }{

                    }

                }
            }

            imprimirEstado(novoEstado,numeroLinhas,numeroColunas);
            System.out.println("=================");

        }




    }
}