package main;

import interaveis.*;
import robos.*;
import util.Tabuleiro;
import java.util.*;

public class MainObstaculo {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Random rand = new Random();

        int ax = -1, ay = -1;

        //Posição do alimento
        while (true) {
            System.out.print("Posição do alimento X (0 a 3): ");
            ax = ler.nextInt();
            System.out.print("Posição do alimento Y (0 a 3): ");
            ay = ler.nextInt();
            ler.nextLine();

            if (ax >= 0 && ax < 4 && ay >= 0 && ay < 4 && !(ax ==0 && ay ==0)) {
                break;
            }
            System.out.println("Posição inválida! Tente novamente.\n");
        }

        Alimento alimento = new Alimento(ax, ay);
        List<Obstaculo> obstaculos = new ArrayList<>();

        //Posição da bomba
        int bx, by;
        while (true) {
            System.out.print("Posição da bomba X (0 a 3): ");
            bx = ler.nextInt();
            System.out.print("Posição da bomba Y (0 a 3): ");
            by = ler.nextInt();
            ler.nextLine();

            if (bx >= 0 && bx < 4 && by >= 0 && by < 4 && !(bx == 0 && by == 0)) {
                break;
            }
            System.out.println("Posição inválida! Tente novamente.\n");
        }

        // --- Posição da rocha
        int rx, ry;
        while (true) {
            System.out.print("Posição da rocha X (0 a 3): ");
            rx = ler.nextInt();
            System.out.print("Posição da rocha Y (0 a 3): ");
            ry = ler.nextInt();
            ler.nextLine();

            if (rx >= 0 && rx < 4 && ry >= 0 && ry < 4 && !(rx == 0 && ry ==0)) {
                break;
            }
            System.out.println("Posição inválida! Tente novamente.\n");
        }

        obstaculos.add(new Bomba(1, bx, by));
        obstaculos.add(new Rocha(2, rx, ry));

        //Criação dos robôs
        
        RoboNormal robo1 = new RoboNormal("Vermelho");
        RoboInteligente robo2 = new RoboInteligente("Azul");

        List<Robo> robos = new ArrayList<>();
        robos.add(robo1);
        robos.add(robo2);

        Tabuleiro tabuleiro = new Tabuleiro(alimento, obstaculos);

        boolean fim = false;
        while (!fim) {
            tabuleiro.mostrar(robos, alimento, obstaculos);

            try {
                if (robo1.isAtivo()) robo1.mover(rand.nextInt(4) + 1, obstaculos);
                if (robo1.encontrou(alimento)) {
                    System.out.println("Robô normal encontrou o alimento!");
                    fim = true;
                    break;
                }

                if (robo2.isAtivo()) robo2.mover(rand.nextInt(4) + 1, obstaculos);
                if (robo2.encontrou(alimento)) {
                    System.out.println("Robô inteligente encontrou o alimento!");
                    fim = true;
                    break;
                }

                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            if (!robo1.isAtivo() && !robo2.isAtivo()) {
                System.out.println("Ambos explodiram!");
                fim = true;
            }
        }

        System.out.println("\n--- RESULTADOS ---");

        if (!robo1.isAtivo() && !robo2.isAtivo()) {
            System.out.format("Ambos explodiram!\n");
        } else if (!robo1.isAtivo()) {
            System.out.format("Robô normal explodiu!\n");
        } else if (!robo2.isAtivo()) {
            System.out.format("Robô inteligente explodiu!\n");
        } else {
            System.out.format("Ambos os robôs sobreviveram!\n");
        }

        System.out.format("Robô normal: %d movimentos válidos | %d inválidos\n",
                robo1.getMovimentosValidos(), robo1.getMovimentosInvalidos());
        System.out.format("Robô inteligente: %d movimentos válidos | %d inválidos\n",
                robo2.getMovimentosValidos(), robo2.getMovimentosInvalidos());

        ler.close();
    }
}
