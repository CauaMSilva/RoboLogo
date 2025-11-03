package robos;

import exceptions.MovimentoInvalidoException;
import interaveis.Obstaculo;
import java.util.List;

public abstract class Robo {
    protected int x;
    protected int y;
    protected String cor;
    protected boolean ativo = true;

    protected int movimentosValidos = 0;
    protected int movimentosInvalidos = 0;

    protected int xAnterior;
    protected int yAnterior;

    public Robo(String cor) {
        this.cor = cor;
        this.x = 0;
        this.y = 0;
    }

    public int getX() {
    	return x;
    }
    public int getY() { 
    	return y; 
    }
    public String getCor() {
    	return cor; 
    }
    public boolean isAtivo() { 
    	return ativo; 
    }
    public int getMovimentosValidos() { 
    	return movimentosValidos; 
    }
    public int getMovimentosInvalidos() { 
    	return movimentosInvalidos; 
    }

    public void explodir() {
        this.ativo = false;
    }

    public void voltar() {
        this.x = this.xAnterior;
        this.y = this.yAnterior;
    }

    public void mover(String direcao) throws MovimentoInvalidoException {
        switch (direcao.toLowerCase()) {
            case "up":
            	mover(1);
            	break;
            case "down":
            	mover(2);
            	break;
            case "right":
            	mover(3);
            	break;
            case "left":
            	mover(4);
            	break;
            default:
            	throw new MovimentoInvalidoException("Entrada invalida");
        }
    }
    
    public void mover(String direcao, List<Obstaculo> obstaculos) throws MovimentoInvalidoException {
        int movimento;

        switch (direcao.toLowerCase()) {
            case "up":
                movimento = 1;
                break;
            case "down":
                movimento = 2;
                break;
            case "right":
                movimento = 3;
                break;
            case "left":
                movimento = 4;
                break;
            default:
                throw new MovimentoInvalidoException("Entrada inválida: " + direcao);
        }

        mover(movimento, obstaculos);
    }


    public void mover(int direcao) throws MovimentoInvalidoException {
        mover(direcao, null);
    }

    public void mover(int direcao, List<Obstaculo> obstaculos) throws MovimentoInvalidoException {
        if (!ativo) 
        	return;

        xAnterior = x;
        yAnterior = y;

        int novoX = x;
        int novoY = y;

        switch (direcao) {
            case 1:
            	novoY++; // up
            	break;
            case 2:
            	novoY--; // down
            	break;
            case 3:
            	novoX++; // right
            	break;
            case 4:
            	novoX--; // left
            	break;
            default:
            	throw new MovimentoInvalidoException("Direção inválida: " + direcao);
        }

        if (novoX < 0 || novoY < 0) {
            movimentosInvalidos++;
            throw new MovimentoInvalidoException("Movimento inválido para " + cor + ": saiu da área!");
        }

        if (novoX >= 4 || novoY >= 4) {
            movimentosInvalidos++;
            throw new MovimentoInvalidoException("Movimento inválido: fora dos limites do tabuleiro!");
        }

        this.x = novoX;
        this.y = novoY;
        movimentosValidos++;

        if (obstaculos != null) {
            for (Obstaculo o : obstaculos) {
                if (o.getX() == x && o.getY() == y) {
                    o.bater(this);
                    break;
                }
            }
        }

        System.out.format("Robo %s está agora em ( %d, %d)\n", cor, x, y);
    }

    public abstract void moverAleatorio(java.util.Random rand, List<Obstaculo> obstaculos);

    public boolean encontrou(interaveis.Alimento alimento) {
        return ativo && x == alimento.getX() && y == alimento.getY();
    }
}