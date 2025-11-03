package main;

import interaveis.Alimento;
import interaveis.Obstaculo;
import robos.Robo;
import robos.RoboNormal;
import util.Tabuleiro;
import java.util.*;

public class MainDois {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Random rand = new Random();

        int ax = -1;
        int ay = -1;
        
        while (true) {
        	System.out.print("Posição do alimento X(0 a 3): ");
        	ax = ler.nextInt();
        	System.out.print("Posição do alimento Y(0 a 3): ");
        	ay = ler.nextInt();
        	ler.nextLine();
        	if (ax >= 0 && ax < 4 && ay >= 0 && ay < 4 && !(ax == 0 && ay == 0)) {
        		break;
        	}
        	System.out.print("Posição inválida\n");
        }
        
        Alimento alimento = new Alimento(ax, ay);


        RoboNormal robo1 = new RoboNormal("Vermelho");
        RoboNormal robo2 = new RoboNormal("Azul");
        
        List<Robo> robos = new ArrayList<>();
        robos.add(robo1);
        robos.add(robo2);
        
        List<Obstaculo> obstaculos = new ArrayList<>();

        Tabuleiro tabuleiro = new Tabuleiro(alimento, null);

        boolean fim = false;
        while (!fim) {
            tabuleiro.mostrar(robos, alimento, obstaculos);
            try {
                if (robo1.isAtivo()) robo1.mover(rand.nextInt(4) + 1);
                if (robo1.encontrou(alimento)) {
                    System.out.println("Robô 1 encontrou o alimento!");
                    fim = true;
                    break;
                }

                if (robo2.isAtivo()) robo2.mover(rand.nextInt(4) + 1);
                if (robo2.encontrou(alimento)) {
                    System.out.println("Robô 2 encontrou o alimento!");
                    fim = true;
                    break;
                }

                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("⚠️ " + e.getMessage());
            }
        }

        System.out.println("\n--- Resultados ---");
        System.out.format("Robô 1 (vermelho): válidos = %d | inválidos = %d\n", robo1.getMovimentosValidos(), robo1.getMovimentosInvalidos());
        System.out.format("Robô 2 (azul): válidos = %d | inválidos = %d", robo2.getMovimentosValidos(), robo2.getMovimentosInvalidos());
        ler.close();
    }
}
