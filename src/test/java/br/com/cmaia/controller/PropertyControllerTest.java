package br.com.cmaia.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import br.com.cmaia.service.PropertyService;
import br.com.cmaia.service.resource.property.PropertyResource;
import br.com.cmaia.service.resource.property.PropertySearchResource;

@RunWith(MockitoJUnitRunner.class)
public class PropertyControllerTest {
    @Mock
    private PropertyService propertyService;

    @InjectMocks
    private PropertyController propertyController;

    @Test
    public void testCreatePropertySuccess() {
        when(this.propertyService.create(any(PropertyResource.class))).thenReturn(null);

        ResponseEntity response = this.propertyController.createProperty(new PropertyResource());

        assertNotNull(response);
        assertEquals(201, response.getStatusCode().value());
    }

    @Test
    public void testSearchPropertySuccess() {
        when(this.propertyService.search(any(PropertySearchResource.class), any(Pageable.class))).thenReturn(null);
        Pageable pageable = mock(Pageable.class);

        ResponseEntity response = this.propertyController.searchProperty(10, 30, 30, 10, pageable);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    public void testFindPropertyByIdSuccess() {
        when(this.propertyService.findById(anyLong())).thenReturn(null);

        ResponseEntity response = this.propertyController.findPropertyById(1L);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
    }
}