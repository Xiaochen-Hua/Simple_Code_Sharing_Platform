package platform.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import platform.entities.Code;

@Repository
public interface CodeRepository extends CrudRepository<Code, String> {

}
