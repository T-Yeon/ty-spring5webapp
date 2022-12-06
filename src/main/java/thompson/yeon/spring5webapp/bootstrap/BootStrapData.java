package thompson.yeon.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import thompson.yeon.spring5webapp.domain.Author;
import thompson.yeon.spring5webapp.domain.Book;
import thompson.yeon.spring5webapp.domain.Publisher;
import thompson.yeon.spring5webapp.repositories.AuthorRepository;
import thompson.yeon.spring5webapp.repositories.BookRepository;
import thompson.yeon.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner{

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;



    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }



    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();

        publisher.setName("Chelsea Publishing");
        publisher.setAddressLine1("123 Book Lane");
        publisher.setCity("Narnia");
        publisher.setState("Imagination");
        publisher.setZip("12345");

        publisherRepository.save(publisher);
        
        System.out.println("Publisher count: " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);


        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "54325634566");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);
        
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);
        
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
    }
    
}
