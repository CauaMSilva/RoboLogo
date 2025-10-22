package main;

import java.util.*;
import robos.*;
import interaveis.*;
import exceptions.*;
import util.Tabuleiro;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("=== 🐢 Jogo do Robô - Modo 1 (Manual) ===");

        RoboNormal robo = new RoboNormal("Azul");
        
        //criaçao do tabuleiro
        int ax = -1;
        int ay = -1;
        
        while (true) {
        	System.out.print("Posição do alimento X(0 a 3): ");
        	ax = ler.nextInt();
        	System.out.print("Posição do alimento Y(0 a 3): ");
        	ay = ler.nextInt();
        	ler.nextLine();
        	if (ax >= 0 && ax < 5 && ay >= 0 && ay < 5) {
        		break;
        	}
        	System.out.print("Posição inválida");
        }
        
        Alimento alimento = new Alimento(ax, ay);

        Tabuleiro tabuleiro = new Tabuleiro(alimento);

        List<Robo> robos = new ArrayList<>();
        robos.add(robo);

        List<Obstaculo> obstaculos = new ArrayList<>(); // vazio por enquanto

        tabuleiro.mostrar(robos, alimento, obstaculos);

        //inicio
        
        while (!robo.encontrou(alimento)) {
            System.out.print("Digite o movimento (up, down, left, right): ");
            String movimento = ler.next().toLowerCase();

            try {
                robo.mover(movimento, obstaculos);
            } catch (MovimentoInvalidoException e) {
                System.out.println("ERRO! " + e.getMessage());
            }

            tabuleiro.mostrar(robos, alimento, obstaculos);
        }

        System.out.format("O robô encontrou o alimento em %d movimentos válidos!", robo.getMovimentosValidos());
        ler.close();
    }
}
