package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Hannes Groeller on 09/29/2022.
 */

public interface BookRepository extends CrudRepository<Book, Long> {
}
