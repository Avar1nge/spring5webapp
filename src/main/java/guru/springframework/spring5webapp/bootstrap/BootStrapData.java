package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

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

        System.out.println("Strated bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("St pt");
        publisher.setCity("St petersburg");
        publisher.setState("Rus");

        publisherRepository.save(publisher);

        System.out.println("Publisher count " + publisherRepository.count());

        Author eric = new Author("Eric", "Cartman");
        Book ddd = new Book("Domain Driven Design", "1321414");
        eric.getBooks().add(ddd);
        ddd.getAuthor().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author todd = new Author("Todd", "Howard");
        Book fall = new Book("Fallout", "152614");
        todd.getBooks().add(fall);
        fall.getAuthor().add(todd);

        fall.setPublisher(publisher);
        publisher.getBooks().add(fall);

        authorRepository.save(todd);
        bookRepository.save(fall);
        publisherRepository.save(publisher);

        System.out.println("Number of Books " + bookRepository.count());
        System.out.println("Publisher's book " + publisher.getBooks().size());
    }
}
