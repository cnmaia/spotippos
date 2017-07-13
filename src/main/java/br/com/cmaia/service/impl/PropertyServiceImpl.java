package br.com.cmaia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cmaia.repository.PropertyRepository;
import br.com.cmaia.service.PropertyService;
import br.com.cmaia.service.resource.converter.PropertyResourceConverter;
import br.com.cmaia.service.resource.property.PropertyResource;
import br.com.cmaia.service.resource.property.PropertySearchResource;

@Service
public class PropertyServiceImpl implements PropertyService {

    private PropertyResourceConverter propertyResourceConverter;
    private PropertyRepository propertyRepository;

    @Autowired
    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
        this.propertyResourceConverter = new PropertyResourceConverter();
    }

    @Override
    public void create(PropertyResource resource) {
    }

    @Override
    public PropertyResource findById(Long id) {

        return null;
    }

    @Override
    public List<PropertyResource> search(PropertySearchResource resource) {

        return null;
    }
}
