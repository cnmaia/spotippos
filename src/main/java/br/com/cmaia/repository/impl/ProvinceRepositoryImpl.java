package br.com.cmaia.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.cmaia.domain.model.Province;
import br.com.cmaia.repository.ProvinceRepository;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;

// TODO: THIS SHOULD BE DELETED -- TEST ONLY PURPOSE
public class ProvinceRepositoryImpl implements ProvinceRepository {
    private final static String FILE_NAME = "provinces.json";

    @Override
    public Set<Province> findAll() {
        ClassLoader classloader = getClass().getClassLoader();
        File file = new File(classloader.getResource(FILE_NAME).getFile());

        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(Set.class, Province.class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Collections.emptySet();
    }
}
