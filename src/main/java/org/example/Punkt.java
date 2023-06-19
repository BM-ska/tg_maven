package org.example;

public class Punkt {
    private int x;
    private int y;

    public Punkt(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Punkt(int x){
        this.x = x;
        this.y = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return x + "aaaaaaaaaaaaaaa" + y;
    }
}
