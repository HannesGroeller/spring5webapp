package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Hannes Groeller on 10/22/2022.
 */

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
