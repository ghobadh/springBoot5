package ca.gforcesoftware.springboot5.repository;


import ca.gforcesoftware.springboot5.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository  extends CrudRepository<Book, Long> {
}
