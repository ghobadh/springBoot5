package ca.gforcesoftware.springboot5.bootstrap;

import ca.gforcesoftware.springboot5.domain.Author;
import ca.gforcesoftware.springboot5.domain.Book;
import ca.gforcesoftware.springboot5.repository.AuthorRepository;
import ca.gforcesoftware.springboot5.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author gavinhashemi on 2024-09-30
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthor().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Rudy");
        Book noEJB = new Book("No-EJB", "123124");
        rod.getBooks().add(noEJB);
        noEJB.getAuthor().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in BootStrapData");
        System.out.println("Number of Books:" + bookRepository.count());


    }
}
