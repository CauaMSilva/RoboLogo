package robos;

import interaveis.Obstaculo;
import java.util.*;

public class RoboInteligente extends Robo {
    private int ultimoMovimentoInvalido = -1;

    public RoboInteligente(String cor) {
        super(cor);
    }

    @Override
    public void moverAleatorio(Random rand, List<Obstaculo> obstaculos) {
        if (!ativo) 
        	return;

        int tentativa;
        
        do {
            tentativa = rand.nextInt(4) + 1;
        } while (tentativa == ultimoMovimentoInvalido);

        try {
            mover(tentativa, obstaculos);
            ultimoMovimentoInvalido = -1;
        } catch (Exception e) {
            System.out.println("⚠️ " + e.getMessage());
            ultimoMovimentoInvalido = tentativa;
        }
    }
}
