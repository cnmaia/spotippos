package br.com.cmaia.service.resource.converter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.cmaia.domain.model.Property;
import br.com.cmaia.service.resource.property.PropertyResource;

public class PropertyResourceConverterTest {

    private PropertyResourceConverter converter;

    @Before
    public void setUp() {
        converter = new PropertyResourceConverter();
    }

    @Test
    public void testFromResourceSuccess() {
        PropertyResource resource = new PropertyResource();
        resource.setId(1L);
        resource.setBaths(1);
        resource.setBeds(1);
        resource.setDescription("abc");
        resource.setSquareMeters(100);
        resource.setTitle("title");
        resource.setX(10);
        resource.setY(10);

        Property convertedProperty = converter.fromResource(resource);

        assertNotNull(convertedProperty);

        assertEquals(Long.valueOf(1), convertedProperty.getId());
        assertEquals(1, convertedProperty.getBaths());
        assertEquals(1, convertedProperty.getBeds());
        assertEquals("abc", convertedProperty.getDescription());
        assertEquals(100, convertedProperty.getSquareMeters(), 0.01);
        assertEquals("title", convertedProperty.getTitle());
        assertEquals(10, convertedProperty.getX());
        assertEquals(10, convertedProperty.getY());
    }

    @Test
    public void testFromResourceNullArgumentShouldReturnNull() {
        assertNull(converter.fromResource(null));
    }

    @Test
    public void testToResourceSuccess() {
        Property property = new Property();
        property.setId(1L);
        property.setBaths(1);
        property.setBeds(1);
        property.setDescription("abc");
        property.setSquareMeters(100);
        property.setTitle("title");
        property.setX(10);
        property.setY(10);

        PropertyResource convertedResource = converter.toResource(property);

        assertNotNull(convertedResource);

        assertEquals(Long.valueOf(1), convertedResource.getId());
        assertEquals(1, convertedResource.getBaths());
        assertEquals(1, convertedResource.getBeds());
        assertEquals("abc", convertedResource.getDescription());
        assertEquals(100, convertedResource.getSquareMeters(), 0.01);
        assertEquals("title", convertedResource.getTitle());
        assertEquals(10, convertedResource.getX());
        assertEquals(10, convertedResource.getY());
    }

    @Test
    public void testToResourceNullArgumentShouldReturnNull() {
        assertNull(converter.toResource(null));
    }
}