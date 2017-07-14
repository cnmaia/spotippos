package br.com.cmaia.domain.model;

public class Province {
    private final String name;
    private final ProvinceBoundary upperLeftBoundary;
    private final ProvinceBoundary bottomRightBoundary;
    private final ProvinceBoundary upperRightBoundary;
    private final ProvinceBoundary bottomLeftBoundary;

    public Province(String name, ProvinceBoundary upperLeftBoundary, ProvinceBoundary bottomRightBoundary) {
        this.name = name;
        this.upperLeftBoundary = upperLeftBoundary;
        this.bottomRightBoundary = bottomRightBoundary;
        this.upperRightBoundary = new ProvinceBoundary(this.upperLeftBoundary.getX(), this.bottomRightBoundary.getY());
        this.bottomLeftBoundary = new ProvinceBoundary(this.bottomRightBoundary.getX(), this.upperLeftBoundary.getY());
    }

    public String getName() {
        return name;
    }

    public ProvinceBoundary getUpperLeftBoundary() {
        return upperLeftBoundary;
    }

    public ProvinceBoundary getBottomRightBoundary() {
        return bottomRightBoundary;
    }

    public ProvinceBoundary getUpperRightBoundary() {
        return upperRightBoundary;
    }

    public ProvinceBoundary getBottomLeftBoundary() {
        return bottomLeftBoundary;
    }
}