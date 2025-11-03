package robos;

import interaveis.Obstaculo;
import java.util.List;
import java.util.Random;

public class RoboNormal extends Robo {

    public RoboNormal(String cor) {
        super(cor);
    }

    @Override
    public void moverAleatorio(Random rand, List<Obstaculo> obstaculos) {
        try {
            mover(rand.nextInt(4) + 1, obstaculos);
        } catch (Exception e) {
            System.out.println("ERRO!" + e.getMessage());
        }
    }
}
