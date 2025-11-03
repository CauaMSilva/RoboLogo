package util;

import interaveis.Alimento;
import interaveis.Obstaculo;
import robos.*;
import java.util.List;

public class Tabuleiro {
    private Alimento alimento;
    private List<Obstaculo> obstaculos;

    public Tabuleiro(Alimento alimento) {
        this.alimento = alimento;
        this.obstaculos = null;
    }

    public Tabuleiro(Alimento alimento, List<Obstaculo> obstaculos) {
        this.alimento = alimento;
        this.obstaculos = obstaculos;
    }

    public void mostrar(List<Robo> robos, Alimento alimento, List<Obstaculo> obstaculos) {
        System.out.format("\033[H\033[2J");
        System.out.flush();

        System.out.format("   ");
        for (int x = 0; x < 4; x++) {
            System.out.format(" %d  ", x);
        }
        System.out.format("%n");

        for (int y = 3; y >= 0; y--) {
            System.out.format("%d ", y);
            for (int x = 0; x < 4; x++) {
                String celula = " . ";

                if (alimento.getX() == x && alimento.getY() == y) {
                    celula = " 🍎 ";
                }

                for (Obstaculo o : obstaculos) {
                    if (o.getX() == x && o.getY() == y) {
                        if (o instanceof interaveis.Bomba)
                            celula = " 💣 ";
                        else if (o instanceof interaveis.Rocha)
                            celula = " 🪨 ";
                    }
                }

                for (Robo r : robos) {
                    if (r.getX() == x && r.getY() == y) {
                        if (!r.isAtivo())
                            celula = " ☠️ ";
                        else if (r instanceof RoboInteligente)
                            celula = " 🤖 ";
                        else
                            celula = " 👾 ";
                    }
                }

                System.out.format(" %s ", celula);
            }
            System.out.format("%n");
        }
        System.out.format("%n");
    }

    private boolean temObstaculo(int x, int y) {
        if (obstaculos == null) return false;
        return obstaculos.stream().anyMatch(o -> o.getX() == x && o.getY() == y);
    }
}
