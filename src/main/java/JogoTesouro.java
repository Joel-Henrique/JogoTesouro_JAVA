import java.util.Scanner;

public class JogoTesouro {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ImplementaJogo jogo = new ImplementaJogo();
        jogo.imprimejogo();
        System.out.println(jogo.qntdetesouros);


        for (;jogo.qntdetesouros> 0;){
            char anda;
            System.out.print("Digite uma letra para andar: ");
            anda = teclado.next().charAt(0);
            System.out.println(anda);
            jogo.andar(anda);
            System.out.println("Quantidade de Tesouros restantes: "+ jogo.qntdetesouros);
            System.out.println();
            jogo.imprimejogo();
        }

        jogo.imprimejogo();


    }
}
