package thompson.yeon.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import thompson.yeon.spring5webapp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
    
}
