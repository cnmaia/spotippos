package br.com.cmaia.domain.filter;

import br.com.cmaia.domain.model.ProvinceBoundary;

public class PropertyFilter {

    private ProvinceBoundary upperLeftBoundary;
    private ProvinceBoundary bottomRightBoundary;

    public PropertyFilter(ProvinceBoundary upperLeftBoundary, ProvinceBoundary bottomRightBoundary) {
        this.upperLeftBoundary = upperLeftBoundary;
        this.bottomRightBoundary = bottomRightBoundary;
    }

    public ProvinceBoundary getUpperLeftBoundary() {
        return upperLeftBoundary;
    }

    public ProvinceBoundary getBottomRightBoundary() {
        return bottomRightBoundary;
    }
}
