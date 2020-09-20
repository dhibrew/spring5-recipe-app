package guru.springframework.repositories;

import guru.springframework.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnifOfMeasureRepository extends CrudRepository<UnitOfMeasure,Integer> {
}
