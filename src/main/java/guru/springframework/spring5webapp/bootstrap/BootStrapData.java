package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        Author eric = new Author("Eric", "Cartman");
        Book ddd = new Book("Domain Driven Design", "1321414");
        eric.getBooks().add(ddd);
        ddd.getAuthor().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author todd = new Author("Todd", "Howard");
        Book fall = new Book("Fallout", "152614");
        todd.getBooks().add(fall);
        ddd.getAuthor().add(todd);

        authorRepository.save(todd);
        bookRepository.save(fall);

        System.out.println("Strated bootstrap");
        System.out.println("Number of Books " + bookRepository.count());

    }
}
