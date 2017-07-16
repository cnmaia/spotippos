package br.com.cmaia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cmaia.domain.model.Province;

public interface ProvinceRepository extends JpaRepository<Province, Long> {
}
