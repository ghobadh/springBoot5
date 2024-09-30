package ca.gforcesoftware.springboot5.repository;


import ca.gforcesoftware.springboot5.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long > {
}
