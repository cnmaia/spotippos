package br.com.cmaia.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.cmaia.domain.filter.PropertyFilter;
import br.com.cmaia.domain.model.Property;
import java.util.Set;

public interface PropertyRepository extends PagingAndSortingRepository<Property, Long> {
    @Query("select p from property p where (p.x >= :#{#filter.upperLeftBoundary.x} and p.x <= :#{#filter.upperLeftBoundary.y}) " +
            "and (p.y >= :#{#filter.bottomRightBoundary.x} and p.y <= :#{#filter.upperLeftBoundary.y})")
    Page<Property> searchByPosition(@Param("filter") PropertyFilter filter, final Pageable pageable);
}
