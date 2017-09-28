package br.com.cmaia.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Pageable;

import br.com.cmaia.domain.filter.PropertyFilter;
import br.com.cmaia.domain.model.Property;
import br.com.cmaia.domain.model.Province;
import br.com.cmaia.exception.ResourceNotFoundException;
import br.com.cmaia.exception.ValidationException;
import br.com.cmaia.repository.PropertyRepository;
import br.com.cmaia.repository.ProvinceRepository;
import br.com.cmaia.service.resource.property.PropertyResource;
import br.com.cmaia.service.resource.property.PropertySearchResource;
import br.com.cmaia.service.resource.property.PropertySearchResultResource;
import java.util.Collections;

@RunWith(MockitoJUnitRunner.class)
public class PropertyServiceImplTest {

    @Mock
    private PropertyRepository propertyRepository;
    @Mock
    private ProvinceRepository provinceRepository;

    @InjectMocks
    private PropertyServiceImpl propertyService;

    @Test
    public void testCreateSuccess() {
        PropertyResource resource = new PropertyResource();
        when(propertyRepository.save(any(Property.class))).thenReturn(new Property());
        when(provinceRepository.findProvinceByPoint(anyInt(), anyInt())).thenReturn(Collections.singleton(new Province()));

        PropertyResource property = this.propertyService.create(resource);

        assertNotNull(property);
    }

    @Test(expected = ValidationException.class)
    public void testCreateWithIdShouldThrowValidationException() {
        PropertyResource resource = new PropertyResource();
        resource.setId(1L);

        when(provinceRepository.findProvinceByPoint(anyInt(), anyInt())).thenReturn(Collections.singleton(new Province()));

        this.propertyService.create(resource);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testFindByIdWithNotCreatedIdShouldThrowResourceNotFoundException() {
        when(propertyRepository.findOne(anyLong())).thenReturn(null);

        this.propertyService.findById(1L);
    }

    @Test
    public void testFindByIdSuccess() {
        when(propertyRepository.findOne(anyLong())).thenReturn(new Property());

        PropertyResource propertyResource = this.propertyService.findById(1L);

        assertNotNull(propertyResource);
        verify(propertyRepository, times(1)).findOne(anyLong());
    }

    @Test
    public void testSearchSuccess() {
        PropertySearchResource resource = new PropertySearchResource(10, 30, 30, 10);
        Pageable pageable = mock(Pageable.class);

        when(this.propertyRepository.searchByPosition(any(PropertyFilter.class), any(Pageable.class)))
                .thenReturn(Collections.singletonList(new Property()));

        PropertySearchResultResource result = this.propertyService.search(resource, pageable);

        assertNotNull(result);
        assertEquals(1, result.foundProperties());
        assertEquals(1, result.getProperties().size());
    }

    @Test
    public void testSearchWithoutResultShouldReturnEmptyPage() {
        PropertySearchResource resource = new PropertySearchResource(10, 30, 30, 10);
        Pageable pageable = mock(Pageable.class);

        when(this.propertyRepository.searchByPosition(any(PropertyFilter.class), any(Pageable.class)))
                .thenReturn(Collections.emptyList());

        PropertySearchResultResource result = this.propertyService.search(resource, pageable);

        assertNotNull(result);
        assertEquals(0, result.foundProperties());
        assertEquals(0, result.getProperties().size());
    }
}