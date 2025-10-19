package Robo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Robo robo = new Robo("Azul");

        System.out.println("Digite a posição X do alimento (0 a 3):");
        int comidaX = ler.nextInt();

        System.out.println("Digite a posição Y do alimento (0 a 3):");
        int comidaY = ler.nextInt();

        ler.nextLine();

        while (!robo.encontrouComida(comidaX, comidaY)) {
            System.out.println("Digite o movimento (up, down, left, right): ");
            String direcao = ler.nextLine();

            try {
                robo.mover(direcao);
            } catch (MovimentoInvalidoException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        System.out.println("Parabéns! O robô encontrou a comida!");
        ler.close();
    }
}