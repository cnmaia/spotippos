package br.com.cmaia.domain.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProvinceTest {
    @Test
    public void testGetUpperRightBoundarySuccess() {
        Province province = new Province();
        province.setUpperLeftBoundary(new ProvinceBoundary(10, 30)); // TODO Validate these values. HOW?
        province.setBottomRightBoundary(new ProvinceBoundary(20, 10));

        assertNotNull(province.getUpperRightBoundary());
        assertEquals(province.getUpperLeftBoundary().getX(), province.getUpperRightBoundary().getX());
        assertEquals(province.getBottomRightBoundary().getY(), province.getUpperRightBoundary().getY());
    }

    @Test
    public void testGetUpperRightBoundaryNullParamsShouldReturnNull() {
        Province province = new Province();

        assertNull(province.getUpperRightBoundary());

        province.setBottomRightBoundary(new ProvinceBoundary());

        assertNull(province.getUpperRightBoundary());

        province.setBottomRightBoundary(null);
        province.setUpperLeftBoundary(new ProvinceBoundary());

        assertNull(province.getUpperRightBoundary());
    }

    @Test
    public void testGetBottomLeftBoundarySuccess() {
        Province province = new Province();
        province.setUpperLeftBoundary(new ProvinceBoundary(10, 30)); // TODO Validate these values. HOW?
        province.setBottomRightBoundary(new ProvinceBoundary(20, 10));

        assertNotNull(province.getBottomLeftBoundary());
        assertEquals(province.getBottomRightBoundary().getX(), province.getBottomLeftBoundary().getX());
        assertEquals(province.getUpperLeftBoundary().getY(), province.getBottomLeftBoundary().getY());
    }

    @Test
    public void testGetBottomLeftBoundaryNullParamsShouldReturnNull() {
        Province province = new Province();

        assertNull(province.getBottomLeftBoundary());

        province.setBottomRightBoundary(new ProvinceBoundary());

        assertNull(province.getBottomLeftBoundary());

        province.setBottomRightBoundary(null);
        province.setUpperLeftBoundary(new ProvinceBoundary());

        assertNull(province.getBottomLeftBoundary());
    }
}