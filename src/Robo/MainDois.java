package Robo;
import java.util.Random;
import java.util.Scanner;

public class MainDois {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Random random = new Random();

        Robo robo1 = new Robo("Vermelho");
        Robo robo2 = new Robo("Verde");

        int comidaX, comidaY;

        System.out.print("Digite a posição X da comida (0 a 3): ");
        comidaX = ler.nextInt();
        System.out.print("Digite a posição Y da comida (0 a 3): ");
        comidaY = ler.nextInt();

        int movimentosValidos1 = 0;
        int movimentosInvalidos1 = 0;

        int movimentosValidos2 = 0;
        int movimentosInvalidos2 = 0;

        boolean encontrou = false;

        while (!encontrou) {
            int direcao1 = random.nextInt(4) + 1;
            try {
                robo1.mover(direcao1);
                movimentosValidos1++;
            } catch (MovimentoInvalidoException e) {
                System.out.println("\n\n[Robô Vermelho] Movimento inválido: \n\n" + e.getMessage());
                movimentosInvalidos1++;
            }

            if (robo1.encontrouComida(comidaX, comidaY)) {
                System.out.println("\nRobô Vermelho encontrou a comida!");
                encontrou = true;
                break;
            }

            int direcao2 = random.nextInt(4) + 1;
            try {
                robo2.mover(direcao2);
                movimentosValidos2++;
            } catch (MovimentoInvalidoException e) {
                System.out.println("[Robô Verde] Movimento inválido: " + e.getMessage());
                movimentosInvalidos2++;
            }

            if (robo2.encontrouComida(comidaX, comidaY)) {
                System.out.println("\nRobô Verde encontrou a comida!");
                encontrou = true;
                break;
            }

            try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        }

        System.out.println("\n===== ESTATÍSTICAS =====");
        System.out.printf("Robô Vermelho — Válidos: %d | Inválidos: %d%n", movimentosValidos1, movimentosInvalidos1);
        System.out.printf("Robô Verde    — Válidos: %d | Inválidos: %d%n", movimentosValidos2, movimentosInvalidos2);

        ler.close();
    }
}
