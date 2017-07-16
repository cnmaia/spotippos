package br.com.cmaia.domain.model;

import javax.persistence.Embeddable;

@Embeddable
public class ProvinceBoundary {
    private int x;
    private int y;

    public ProvinceBoundary() {

    }

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

    @Override
    public String toString() {
        return "ProvinceBoundary{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
