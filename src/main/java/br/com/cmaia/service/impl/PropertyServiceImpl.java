package br.com.cmaia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.cmaia.domain.filter.PropertyFilter;
import br.com.cmaia.domain.model.Property;
import br.com.cmaia.domain.model.Province;
import br.com.cmaia.domain.model.ProvinceBoundary;
import br.com.cmaia.domain.validator.Validator;
import br.com.cmaia.domain.validator.property.CreatePropertyValidator;
import br.com.cmaia.exception.ResourceNotFoundException;
import br.com.cmaia.repository.PropertyRepository;
import br.com.cmaia.repository.ProvinceRepository;
import br.com.cmaia.service.PropertyService;
import br.com.cmaia.service.resource.converter.PropertyResourceConverter;
import br.com.cmaia.service.resource.property.PagedPropertyResource;
import br.com.cmaia.service.resource.property.PropertyResource;
import br.com.cmaia.service.resource.property.PropertySearchResource;
import br.com.cmaia.service.resource.property.PropertySearchResultResource;
import java.util.HashSet;
import java.util.List;
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
    public PropertyResource create(final PropertyResource resource) {
        Property property = propertyResourceConverter.fromResource(resource);

        property.setProvinces(this.provinceRepository.findProvinceByPoint(property.getX(), property.getY()));

        if (property.getProvinces().isEmpty()) {
            System.out.println(property.toString());
        }

        new CreatePropertyValidator().validate(property).verify();

        return propertyResourceConverter.toResource(this.propertyRepository.save(property));
    }

    @Override
    public PropertyResource findById(final Long id) {
        Property property = this.propertyRepository.findOne(id);

        if (property != null)
            return this.propertyResourceConverter.toResource(property);

        throw new ResourceNotFoundException(String.format("Property with id [%d] not found.", id));
    }

    @Override
    public PropertySearchResultResource search(final PropertySearchResource resource, final Pageable pageable) {
        ProvinceBoundary upperLeft = new ProvinceBoundary(resource.getAx(), resource.getAy());
        ProvinceBoundary bottomRight = new ProvinceBoundary(resource.getBx(), resource.getBy());

        return new PropertySearchResultResource(this.propertyRepository.searchByPosition(new PropertyFilter(upperLeft, bottomRight), pageable)
                .stream()
                .map(propertyResourceConverter::toResource)
                .collect(Collectors.toSet()));
    }
}
