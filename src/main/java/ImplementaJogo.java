public class ImplementaJogo {
    private int tam= 8;
    private int[][] Tabuleiro = new int[tam][tam];
    private Jogador jogador1 = new Jogador();
    private int[] posicaojogador = new int[2];
    public ImplementaJogo(){
        for (int lin = 0; lin < Tabuleiro.length; lin++) {
            for (int col = 0; col < Tabuleiro[0].length; col++) {
                Tabuleiro[lin][col] = 0;
            }
        }
        for(int i= 0;i<10;i++)
            GeraTesouro();

        adicionajogador();

    }
    private void GeraTesouro(){
        int lin = (int) (java.lang.Math.random() * 8);
        int col = (int) (java.lang.Math.random() * 8);
        posicaojogador[0] = lin;
        posicaojogador[1] = col;
        EspalhaTesouro(lin,col);

    }
    private void EspalhaTesouro(int m,int n){
        Tabuleiro[m][n] = 7;
    }

    public void andar(char c){
        int lin,col;
        switch (c) {
            case 'w' -> {
                lin = posicaojogador[0];
                col = posicaojogador[1];
                if (Tabuleiro[lin][col] > 0) {
                    if (lin >= 1) {
                        Tabuleiro[lin][col] = 0;
                        if (Tabuleiro[lin - 1][col] == 7) {
                            jogador1.adicionaexp();
                            Tabuleiro[lin - 1][col] = 9;
                            posicaojogador[0] = lin - 1;
                        }
                    } else
                        System.out.println("Você não pode ir nessa direção!!!");
                }
            }
            case 's' -> {
                lin = posicaojogador[0];
                col = posicaojogador[1];
                if (Tabuleiro[lin][col] > 0) {
                    if (lin <= tam - 2) {
                        Tabuleiro[lin][col] = 0;
                        if (Tabuleiro[lin + 1][col] == 7) {
                            jogador1.adicionaexp();
                            Tabuleiro[lin + 1][col] = 9;
                            posicaojogador[0] = lin + 1;
                        }
                    } else
                        System.out.println("Você não pode ir nessa direção!!!");
                }
            }
            case 'a' -> {
                lin = posicaojogador[0];
                col = posicaojogador[1];
                if (Tabuleiro[lin][col] > 0) {
                    if (col >= 1) {
                        Tabuleiro[lin][col] = 0;
                        if (Tabuleiro[lin][col - 1] == 7) {
                            jogador1.adicionaexp();
                            Tabuleiro[lin][col - 1] = 9;
                            posicaojogador[1] = col - 1;
                        }
                    } else
                        System.out.println("Você não pode ir nessa direção!!!");
                }
            }
            case 'd' -> {
                lin = posicaojogador[0];
                col = posicaojogador[1];
                if (Tabuleiro[lin][col] > 0) {
                    if (col <= tam - 2) {
                        Tabuleiro[lin][col] = 0;
                        if (Tabuleiro[lin][col + 1] == 7) {
                            jogador1.adicionaexp();
                            Tabuleiro[lin][col + 1] = 9;
                            posicaojogador[1] = col + 1;
                        }
                    } else
                        System.out.println("Você não pode ir nessa direção!!!");
                }
            }
            default -> System.out.println("Digite uma letra valida");
        }

    }
    /*                       0 1 2 3 4
                          0  0 0 0 0
                          1  0 0 0 0
                          2  0 0 0 0
                          3  0 0 0 0
                          4
     */

    private void adicionajogador(){
        int n = (int) (java.lang.Math.random() * 8);
        int m = (int) (java.lang.Math.random() * 8);
        Tabuleiro[m][n] = 9;
    }







    public void imprimejogo(){
        for (int[] ints : Tabuleiro) {
            for (int col = 0; col < Tabuleiro[0].length; col++) {
                System.out.print(ints[col] + " ");
            }
            System.out.println();
        }
    }


}
