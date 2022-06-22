import java.util.Scanner;

public class JogoTesouro {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.print("Informe a ordem da matriz (N x N): ");
        int TamanhoDoTabuleiro = teclado.nextInt();
        System.out.print("Informe a quantidade de tesouros: ");
        int QuantdTesouros = teclado.nextInt();
        //System.out.print("Informe o nome do jogador: ");
        ImplementaJogo jogo = new ImplementaJogo(TamanhoDoTabuleiro,QuantdTesouros);

    }
}
