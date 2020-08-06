package team.bear.mockito;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BearRepository extends MongoRepository<Bear,String > {
    List<Bear> findByName(String Name);
}
