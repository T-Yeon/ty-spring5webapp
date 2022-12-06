package thompson.yeon.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import thompson.yeon.spring5webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{
    
}
