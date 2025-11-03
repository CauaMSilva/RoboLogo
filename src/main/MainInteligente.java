package main;

import interaveis.Alimento;
import interaveis.Obstaculo;
import robos.RoboNormal;
import robos.Robo;
import robos.RoboInteligente;
import util.Tabuleiro;
import java.util.*;

public class MainInteligente {
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
        RoboInteligente robo2 = new RoboInteligente("Azul");
        
        List<Robo> robos = new ArrayList<>();
        robos.add(robo1);
        robos.add(robo2);
        
        List<Obstaculo> obstaculos = new ArrayList();

        Tabuleiro tabuleiro = new Tabuleiro(alimento, null);

        boolean r1Fim = false, r2Fim = false;

        while (!r1Fim || !r2Fim) {
            tabuleiro.mostrar(robos, alimento, obstaculos);

            if (!r1Fim && robo1.isAtivo()) {
                try {
                    robo1.mover(rand.nextInt(4) + 1);
                } catch (Exception e) {
                    System.out.println("ERRO! " + e.getMessage());
                }
                if (robo1.encontrou(alimento)) {
                    System.out.println("Robô normal encontrou o alimento!");
                    r1Fim = true;
                }
            }

            if (!r2Fim && robo2.isAtivo()) {
                try {
                    robo2.mover(rand.nextInt(4) + 1);
                } catch (Exception e) {
                    System.out.println("ERRO! " + e.getMessage());
                }
                if (robo2.encontrou(alimento)) {
                    System.out.println("Robô inteligente encontrou o alimento!");
                    r2Fim = true;
                }
            }

            try {
            	Thread.sleep(1000);
            	} catch (InterruptedException ignored) {}
        }

        System.out.println("\n--- Resultados ---");
        System.out.format("Robô normal: %d válidos | %d invalidos\n", robo1.getMovimentosValidos(), robo1.getMovimentosInvalidos());
        System.out.format("Robô inteligente: %d válidos | %d invalidos", robo2.getMovimentosValidos(), robo2.getMovimentosInvalidos());
        ler.close();
    }
}
