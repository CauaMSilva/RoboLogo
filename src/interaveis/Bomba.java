package interaveis;

import robos.Robo;

public class Bomba extends Obstaculo {
    public Bomba(int id, int x, int y) {
        super(id, x, y);
    }

    @Override
    public void bater(Robo robo) {
        System.out.printf("%s explodiu na posição (%d,%d)!%n", robo.getCor(), x, y);
        robo.explodir();
    }
}
