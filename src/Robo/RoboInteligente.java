package Robo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RoboInteligente extends Robo {

    public RoboInteligente(String cor) {
        super(cor);
    }

    @Override
    public void mover(int direcao) {
        Random rand = new Random();
        List<Integer> direcoesTentadas = new ArrayList<>();
        boolean movimentoFeito = false;

        while (!movimentoFeito && direcoesTentadas.size() < 4) {
            try {
                super.mover(direcao);
                movimentoFeito = true;
            } catch (MovimentoInvalidoException e) {
                direcoesTentadas.add(direcao);
                do {
                    direcao = rand.nextInt(4) + 1;
                } while (direcoesTentadas.contains(direcao));
            }
        }
    }
}
