package br.com.cmaia.domain.model;

public class ProvinceBoundary {
    private final int x;
    private final int y;

    public ProvinceBoundary(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
