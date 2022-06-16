package dan.rojas.epam.repository;

import dan.rojas.epam.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event,Long> {
}
