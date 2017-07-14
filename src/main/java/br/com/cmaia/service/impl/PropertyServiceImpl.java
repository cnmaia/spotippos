package br.com.cmaia.service.impl;

import br.com.cmaia.domain.filter.PropertyFilter;
import br.com.cmaia.domain.model.Property;
import br.com.cmaia.domain.model.Province;
import br.com.cmaia.domain.model.ProvinceBoundary;
import br.com.cmaia.exception.ResourceNotFoundException;
import br.com.cmaia.repository.ProvinceRepository;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cmaia.repository.PropertyRepository;
import br.com.cmaia.service.PropertyService;
import br.com.cmaia.service.resource.converter.PropertyResourceConverter;
import br.com.cmaia.service.resource.property.PropertyResource;
import br.com.cmaia.service.resource.property.PropertySearchResource;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService {

    private PropertyRepository propertyRepository;
    private ProvinceRepository provinceRepository;

    private PropertyResourceConverter propertyResourceConverter;

    @Autowired
    public PropertyServiceImpl(PropertyRepository propertyRepository,
                               ProvinceRepository provinceRepository) {
        this.propertyRepository = propertyRepository;
        this.provinceRepository = provinceRepository;

        this.propertyResourceConverter = new PropertyResourceConverter();
    }

    @Override
    public void create(PropertyResource resource) {
        Property property = propertyResourceConverter.fromResource(resource);

        // calculate provinces
        property.setProvinces(this.calculateProvinces(property.getX(), property.getY()));


        this.propertyRepository.create(property);
    }

    @Override
    public PropertyResource findById(Long id) {
        Optional<Property> optProperty = this.propertyRepository.find(id);

        if (optProperty.isPresent())
            return this.propertyResourceConverter.toResource(optProperty.get());

        throw new ResourceNotFoundException("Change this exception");
    }

    @Override
    public List<PropertyResource> search(PropertySearchResource resource) {
        ProvinceBoundary upperLeft = new ProvinceBoundary(resource.getAx(), resource.getAy());
        ProvinceBoundary bottomRight = new ProvinceBoundary(resource.getBx(), resource.getBy());

        Set<Property> propertiesFiltered = this.propertyRepository.search(new PropertyFilter(upperLeft, bottomRight));

        return propertiesFiltered.stream().map(propertyResourceConverter::toResource).collect(Collectors.toList());
    }

    private Set<Province> calculateProvinces(int x, int y) {
        return new HashSet<>(this.provinceRepository.findAll().stream()
                .filter(p -> x >= p.getUpperLeftBoundary().getX() &&
                        x <= p.getUpperLeftBoundary().getY() &&
                        y <= p.getBottomRightBoundary().getX() &&
                        y >= p.getBottomRightBoundary().getY())
                .collect(Collectors.toList()));
    }
}
