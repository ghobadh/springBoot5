package ca.gforcesoftware.springboot5.repository;


import ca.gforcesoftware.springboot5.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * @author gavinhashemi on 2024-09-30
 */
public interface PublishRepository  extends CrudRepository<Publisher, Long> {
}
