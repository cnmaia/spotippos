package br.com.cmaia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cmaia.domain.model.Province;
import br.com.cmaia.domain.model.ProvinceBoundary;
import java.util.Set;

public interface ProvinceRepository extends JpaRepository<Province, Long> {
    @Query("select p from Province p where (p.upperLeftBoundary.x <= ?1 and p.bottomRightBoundary.x >= ?1)" +
            " and (p.upperLeftBoundary.y >= ?2 and p.bottomRightBoundary.y <= ?2)")
    Set<Province> findProvinceByPoint(int x, int y);
}