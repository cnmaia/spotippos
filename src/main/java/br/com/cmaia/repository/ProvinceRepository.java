package br.com.cmaia.repository;

import br.com.cmaia.domain.model.Province;
import java.util.Set;

public interface ProvinceRepository {

    Set<Province> findAll();
}
