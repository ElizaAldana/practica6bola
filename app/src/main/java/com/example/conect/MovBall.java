package com.example.conect;

public class MovBall {
    private int posX, posY, r, g, b, tam;

    public MovBall(int posX, int posY, int r, int g, int b, int tam) {
        this.posX = posX;
        this.posY = posY;
        this.r = r;
        this.g = g;
        this.b = b;
        this.tam = tam;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

}
