package hello;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by renatorfr on 07/09/15.
 */
public interface GreetingRepository extends CrudRepository<Greeting, Long> {
    List<Greeting> findByContent(String content);
}
