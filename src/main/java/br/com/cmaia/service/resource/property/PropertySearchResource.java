package br.com.cmaia.service.resource.property;

public class PropertySearchResource {
    private int ax;
    private int ay;
    private int bx;
    private int by;

    public PropertySearchResource(int ax, int ay, int bx, int by) {
        this.ax = ax;
        this.ay = ay;
        this.bx = bx;
        this.by = by;
    }

    public int getAx() {
        return ax;
    }

    public int getAy() {
        return ay;
    }

    public int getBx() {
        return bx;
    }

    public int getBy() {
        return by;
    }
}
