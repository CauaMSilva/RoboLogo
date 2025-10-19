package Robo;
import java.util.Random;
import java.util.Scanner;

public class MainInteligente {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Random rand = new Random();

        Robo roboNormal = new Robo("Amarelo");
        RoboInteligente roboInt = new RoboInteligente("Azul");

        int comidaX, comidaY;

        do {
            System.out.print("Digite a posição X da comida (0 a 3): ");
            comidaX = ler.nextInt();
        } while (comidaX < 0 || comidaX > 3);

        do {
            System.out.print("Digite a posição Y da comida (0 a 3): ");
            comidaY = ler.nextInt();
        } while (comidaY < 0 || comidaY > 3);

        int movimentosNormais = 0;
        int movimentosInteligente = 0;

        boolean normalAchou = false;
        boolean inteligenteAchou = false;

        System.out.println("\n--- Iniciando movimentação ---\n");

        while (!normalAchou || !inteligenteAchou) {

            if (!normalAchou) {
                int dir = rand.nextInt(4) + 1;

                try {
                    roboNormal.mover(dir);
                    movimentosNormais++;
                } catch (MovimentoInvalidoException e) {
                    System.out.println("[Normal] Movimento inválido: " + e.getMessage());
                }

                if (roboNormal.encontrouComida(comidaX, comidaY)) {
                    normalAchou = true;
                    System.out.println(">>> Robô Normal encontrou a comida!\n");
                }
            }

            if (!inteligenteAchou) {
                int dir = rand.nextInt(4) + 1;

                int antesX = roboInt.getX();
                int antesY = roboInt.getY();

                roboInt.mover(dir);

                if (roboInt.getX() != antesX || roboInt.getY() != antesY) {
                    movimentosInteligente++;
                }

                if (roboInt.encontrouComida(comidaX, comidaY)) {
                    inteligenteAchou = true;
                    System.out.println(">>> Robô Inteligente encontrou a comida!\n");
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {}
        }

        System.out.println("\n===== ESTATÍSTICAS =====");
        System.out.format("Robô Normal: %d movimentos", movimentosNormais);
        System.out.format("Robô Inteligente: %d movimentos", movimentosInteligente);

        ler.close();
    }
}
