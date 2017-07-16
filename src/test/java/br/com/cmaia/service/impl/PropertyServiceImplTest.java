package br.com.cmaia.service.impl;

import static org.gradle.internal.impldep.org.testng.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import br.com.cmaia.domain.filter.PropertyFilter;
import br.com.cmaia.domain.model.Property;
import br.com.cmaia.exception.ResourceNotFoundException;
import br.com.cmaia.exception.ValidationException;
import br.com.cmaia.repository.PropertyRepository;
import br.com.cmaia.repository.ProvinceRepository;
import br.com.cmaia.service.resource.property.PropertyResource;
import br.com.cmaia.service.resource.property.PropertySearchResource;
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
    }

//    @Test(expected = ValidationException.class)
//    public void testCreateWithIdShouldThrowValidationException() {
//
//    }

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
                .thenReturn(new PageImpl<>(Collections.singletonList(new Property())));

        Page<PropertyResource> result = this.propertyService.search(resource, pageable);

        assertNotNull(result);
        assertEquals(1L ,result.getTotalElements());
    }

    @Test
    public void testSearchWithoutResultShouldReturnEmptyPage() {
        PropertySearchResource resource = new PropertySearchResource(10, 30, 30, 10);
        Pageable pageable = mock(Pageable.class);

        when(this.propertyRepository.searchByPosition(any(PropertyFilter.class), any(Pageable.class)))
                .thenReturn(new PageImpl<>(Collections.emptyList()));

        Page<PropertyResource> result = this.propertyService.search(resource, pageable);

        assertNotNull(result);
        assertEquals(0L ,result.getTotalElements());
    }
}