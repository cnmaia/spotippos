package br.com.cmaia.repository.impl;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.cmaia.domain.filter.PropertyFilter;
import br.com.cmaia.domain.model.Property;
import br.com.cmaia.domain.model.Province;
import br.com.cmaia.repository.PropertyRepository;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@Repository
public class PropertyRepositoryImpl implements PropertyRepository {
    private final static String FILE_NAME = "properties.json";

    @Override
    public Optional<Property> find(Long id) {
        ClassLoader classloader = getClass().getClassLoader();
        File file = new File(classloader.getResource(FILE_NAME).getFile());

        ObjectMapper mapper = new ObjectMapper();

        try {
            return Optional.of(mapper.readValue(file, Property.class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Property create(Property property) {
        return new Property();
    }

    @Override
    public Set<Property> search(PropertyFilter filter) {
        return Collections.emptySet();
    }
}
