package ca.gforcesoftware.springboot5.bootstrap;

import ca.gforcesoftware.springboot5.domain.Author;
import ca.gforcesoftware.springboot5.domain.Book;
import ca.gforcesoftware.springboot5.domain.Publisher;
import ca.gforcesoftware.springboot5.repository.AuthorRepository;
import ca.gforcesoftware.springboot5.repository.BookRepository;
import ca.gforcesoftware.springboot5.repository.PublishRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author gavinhashemi on 2024-09-30
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublishRepository publishRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublishRepository publishRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publishRepository = publishRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("Publisher 1");
        publisher.setCity("New York");
        publisher.setState("NY");

        publishRepository.save(publisher);



        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthor().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publishRepository.save(publisher);

        Author rod = new Author("Rod", "Rudy");
        Book noEJB = new Book("No-EJB", "123124");
        rod.getBooks().add(noEJB);
        noEJB.getAuthor().add(rod);
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publishRepository.save(publisher);

        System.out.println("Started in BootStrapData");
        System.out.println("Number of Books:" + bookRepository.count());
        System.out.println("Number of Authors:" + authorRepository.count());
        System.out.println("Number of Publishers:" + publishRepository.count());
        System.out.println("Publisher number of books:" + publisher.getBooks().size());


    }
}
