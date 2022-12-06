package thompson.yeon.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import thompson.yeon.spring5webapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{
    
}
