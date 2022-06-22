import java.util.Scanner;

public class ImplementaJogo {
    private int tam;
    private int qntdt;
    private Jogador jogador1 = new Jogador();
    private int[] posicaojogador = new int[2];

    public ImplementaJogo(int TamanhoDoTabuleiro,int qntdetesouros){
        settamanho(TamanhoDoTabuleiro);
        int[][] Tabuleiro = new int[tam][tam];
        setQntdt(qntdetesouros);

        for (int lin = 0; lin < Tabuleiro.length; lin++) {
            for (int col = 0; col < Tabuleiro[0].length; col++) {
                Tabuleiro[lin][col] = 0;
            }
        }


        for (int i = 0; i < this.qntdt; i++)
            GeraTesouro(Tabuleiro);

        adicionajogador(Tabuleiro);

        for (; jogador1.getexp() < this.qntdt ;){
            Scanner teclado = new Scanner(System.in);
            char anda;
            System.out.println("Digite: ");
            System.out.println("1 - Para movimentar o Jogador");
            System.out.println("2 - Para sair ");
            System.out.print("Informe a opção: ");
            int verifica = teclado.nextInt();
            switch (verifica) {
                case 1 -> {
                    System.out.println("Digite:");
                    System.out.println(" w - para mover o jogador para cima");
                    System.out.println(" s - para mover o jogador para baixo");
                    System.out.println(" a - para mover o jogador para esquerda");
                    System.out.println(" d - para mover o jogador para direita");
                    System.out.print("Informe a direção: ");
                    anda = teclado.next().charAt(0);
                    System.out.println(anda);
                    andar(anda, Tabuleiro);
                    System.out.println();
                    imprimejogo(Tabuleiro);
                }
                //imprimejogo(Tabuleiro);
                case 2 -> this.qntdt = -1;
                default -> System.out.println("Digite um numero valido!");
            }
        }
        if(qntdt>0)
            System.out.println("Parabens Você Ganhou UHULLLL");
    }

    private void GeraTesouro(int[][] Tabuleiro){
        int lin = (int) (java.lang.Math.random() * tam);
        int col = (int) (java.lang.Math.random() * tam);
        if((lin == 0) && (col ==0)){
            for (;(lin == 0)&& (col ==0);) {
                lin = (int) (java.lang.Math.random() * tam);
                col = (int) (java.lang.Math.random() * tam);
            }
        }
        EspalhaTesouro(lin,col,Tabuleiro);

    }
    private void EspalhaTesouro(int m, int n, int[][] Tabuleiro){
        Tabuleiro[m][n] = 7;
    }


    public void andar(char c, int[][] Tabuleiro){
        int lin,col;
        lin = this.posicaojogador[0];
        col = this.posicaojogador[1];

        switch (c) {
            case 'w' -> {

                if (Tabuleiro[lin][col] >= 0) {
                    if (lin >= 1) {
                        Tabuleiro[lin][col] = 0;
                        if (Tabuleiro[lin - 1][col] == 7) {
                            System.out.println("Parabéns, você encontrou um tesouro! Nova pontuação de experiência: "+ (jogador1.getexp()+1));
                            jogador1.adicionaexp();
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
                            System.out.println("Parabéns, você encontrou um tesouro! Nova pontuação de experiência: "+ (jogador1.getexp()+1));
                            jogador1.adicionaexp();
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
                            System.out.println("Parabéns, você encontrou um tesouro! Nova pontuação de experiência: "+ (jogador1.getexp()+1));
                            jogador1.adicionaexp();
                        }
                        Tabuleiro[lin][col - 1] = 9;
                        posicaojogador[1] = col - 1;


                    } else
                        System.out.println("Você não pode ir nessa direção!!!");
                }
            }
            case 'd' -> {
                if (Tabuleiro[lin][col] >= 0) {
                    if (col <= (tam - 2)) {
                        Tabuleiro[lin][col] = 0;
                        if(Tabuleiro[lin][col+1] == 7) {
                            System.out.println("Parabéns, você encontrou um tesouro! Nova pontuação de experiência: "+ (jogador1.getexp()+1));
                            jogador1.adicionaexp();
                        }
                        Tabuleiro[lin][col+1] = 9;
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

    private void adicionajogador(int[][] Tabuleiro){
        /*
        int lin = (int) (java.lang.Math.random() * tam);
        int col = (int) (java.lang.Math.random() * tam);
        this.posicaojogador[0] = lin;
        this.posicaojogador[1] = col;
        Tabuleiro[lin][col] = 9;
                    for (int i = 0; i <= this.qntdt; i++)
                GeraTesouro(Tabuleiro);
         */
        Tabuleiro[0][0] = 9;
    }


    public void imprimejogo(int[][] Tabuleiro){
        for (int[] ints : Tabuleiro) {
            for (int col = 0; col < Tabuleiro[0].length; col++) {
                System.out.print(ints[col] + " ");
            }
            System.out.println();
        }
    }

    private void setQntdt(int qntdetesouros) {

        if(qntdetesouros > 0) {
            this.qntdt = qntdetesouros;
            //System.out.println("qnt dd: "+ this.qntdt);
        }else
            System.out.println("Quantidade de tesouros invalidos!!");
    }
    private void settamanho(int TamanhoDoTabuleiro){
        if(TamanhoDoTabuleiro>=2){
            this.tam = TamanhoDoTabuleiro;
        }else
            System.out.println("Tamanho Invalido!!");
    }

}
