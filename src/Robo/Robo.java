package Robo;
public class Robo {

    private int x;
    private int y;
    private String cor;

    public Robo(String cor) {
        this.cor = cor;
        this.x = 0;
        this.y = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void mostrarPosicao() {
        System.out.format("Robô %s está na posição (%d, %d)\n\n", cor, x, y);
    }

    public void mover(String direcao) throws MovimentoInvalidoException {
        int novoX = this.x;
        int novoY = this.y;

        switch (direcao.toLowerCase()) {
            case "up":
                novoY += 1;
                break;
            case "down":
                novoY -= 1;
                break;
            case "right":
                novoX += 1;
                break;
            case "left":
                novoX -= 1;
                break;
            default:
                throw new MovimentoInvalidoException("Comando inválido: " + direcao);
        }

        if (novoX < 0 || novoY < 0 || novoX > 3 || novoY > 3) {
            throw new MovimentoInvalidoException("\n\nMovimento inválido: " + direcao +
                    " — posição fora dos limites permitidos!\n\n");
        }

        setX(novoX);
        setY(novoY);
        mostrarPosicao();
    }

    public void mover(int direcao) throws MovimentoInvalidoException {
        int novoX = x;
        int novoY = y;

        switch (direcao) {
            case 1:
                novoY += 1;
                break;
            case 2:
                novoY -= 1;
                break;
            case 3:
                novoX += 1;
                break;
            case 4:
                novoX -= 1;
                break;
            default:
                throw new MovimentoInvalidoException("Comando inválido: " + direcao);
        }

        if (novoX < 0 || novoY < 0 || novoX > 3 || novoY > 3) {
            throw new MovimentoInvalidoException("\n\nMovimento inválido: " + direcao +
                    " — posição fora dos limites permitidos!\n\n");
        }

        setX(novoX);
        setY(novoY);
        mostrarPosicao();
    }

    public boolean encontrouComida(int comidaX, int comidaY) {
        return comidaX == getX() && comidaY == getY();
    }
}
