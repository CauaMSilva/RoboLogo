package interaveis;

import robos.Robo;

public class Rocha extends Obstaculo {
    public Rocha(int id, int x, int y) {
        super(id, x, y);
    }

    @Override
    public void bater(Robo robo) {
        System.out.printf("%s bateu na rocha e volta à posição anterior!%n", robo.getCor());
        robo.voltar();
    }
}
