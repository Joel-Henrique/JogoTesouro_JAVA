public class ImplementaJogo {
    private int tam= 8;
    private int[][] Tabuleiro = new int[tam][tam];
    private Jogador jogador1 = new Jogador();
    private int[] posicaojogador = new int[2];
    int qntdetesouros = 10;
    public ImplementaJogo(){
        for (int lin = 0; lin < Tabuleiro.length; lin++) {
            for (int col = 0; col < Tabuleiro[0].length; col++) {
                Tabuleiro[lin][col] = 0;
            }
        }
        for(int i= 0;i<=qntdetesouros;i++)
            GeraTesouro();

        adicionajogador();

    }
    private void GeraTesouro(){
        int lin = (int) (java.lang.Math.random() * 8);
        int col = (int) (java.lang.Math.random() * 8);

        EspalhaTesouro(lin,col);

    }
    private void EspalhaTesouro(int m,int n){
        Tabuleiro[m][n] = 7;
    }

    public void andar(char c){
        int lin,col;
        lin = this.posicaojogador[0];
        col = this.posicaojogador[1];

        switch (c) {
            case 'w' -> {

                if (Tabuleiro[lin][col] >= 0) {
                    if (lin >= 1) {
                        Tabuleiro[lin][col] = 0;
                        if (Tabuleiro[lin - 1][col] == 7) {
                            System.out.println("Parabens seu novo nivel eh: " + (jogador1.getexp()+1));
                            jogador1.adicionaexp();
                            this.qntdetesouros--;
                        }
                        Tabuleiro[lin - 1][col] = 9;
                        posicaojogador[0] = lin - 1;
                    } else
                        System.out.println("Você não pode ir nessa direção!!!");
                }
            }
            case 's' -> {
                if (Tabuleiro[lin][col] > 0) {
                    if (lin <= tam - 2) {
                        Tabuleiro[lin][col] = 0;
                        if (Tabuleiro[lin + 1][col] == 7) {
                            System.out.println("Parabens seu novo nivel eh: " + (jogador1.getexp()+1));
                            jogador1.adicionaexp();
                            qntdetesouros--;

                        }
                        Tabuleiro[lin + 1][col] = 9;
                        posicaojogador[0] = lin + 1;
                    } else
                        System.out.println("Você não pode ir nessa direção!!!");
                }
            }
            case 'a' -> {
                if (Tabuleiro[lin][col] > 0) {
                    if (col >= 1) {
                        Tabuleiro[lin][col] = 0;
                        if (Tabuleiro[lin][col - 1] == 7) {
                            System.out.println("Parabens seu novo nivel eh: " + (jogador1.getexp()+1));
                            jogador1.adicionaexp();
                            qntdetesouros--;
                        }
                        Tabuleiro[lin][col - 1] = 9;
                        posicaojogador[1] = col - 1;


                    } else
                        System.out.println("Você não pode ir nessa direção!!!");
                }
            }
            case 'd' -> {
                if (this.Tabuleiro[lin][col] >= 0) {
                    if (col <= (tam - 2)) {
                        this.Tabuleiro[lin][col] = 0;
                        if(this.Tabuleiro[lin][col+1] == 7) {
                            System.out.println("Parabens seu novo nivel eh: " + (jogador1.getexp()+1));
                            jogador1.adicionaexp();
                            qntdetesouros--;
                        }
                        this.Tabuleiro[lin][col+1] = 9;
                        this.posicaojogador[1] = col+1;

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
        int lin = (int) (java.lang.Math.random() * 8);
        int col = (int) (java.lang.Math.random() * 8);
        this.posicaojogador[0] = lin;
        this.posicaojogador[1] = col;
        this.Tabuleiro[lin][col] = 9;
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
