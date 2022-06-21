public class ImplementaJogo {
    private int[][] Tabuleiro = new int[8][8];
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
        int n = (int) (java.lang.Math.random() * 8);
        int m = (int) (java.lang.Math.random() * 8);
        EspalhaTesouro(m,n);

    }
    private void EspalhaTesouro(int m,int n){
        Tabuleiro[m][n] = 7;
    }

    public void andar(char c){

    }

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
