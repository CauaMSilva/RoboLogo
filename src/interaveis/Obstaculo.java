package interaveis;

import robos.Robo;

public abstract class Obstaculo {
    protected int id;
    protected int x;
    protected int y;

    public Obstaculo(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public int getX() { 
    	return x;
    	}
    
    public int getY() { 
    	return y;
    	}

    public abstract void bater(Robo robo);
}
