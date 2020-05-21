package com.nikolai.webapptest.bootstrap;

import com.nikolai.webapptest.domain.Author;
import com.nikolai.webapptest.domain.Book;
import com.nikolai.webapptest.domain.Publisher;
import com.nikolai.webapptest.repositories.AuthorsRepository;
import com.nikolai.webapptest.repositories.BooksRepository;
import com.nikolai.webapptest.repositories.PublishersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private AuthorsRepository authorsRepository;
    private BooksRepository booksRepository;
    private PublishersRepository publishersRepository;

    public BootstrapData(
            AuthorsRepository authorsRepository,
            BooksRepository booksRepository,
            PublishersRepository publishersRepository
    ) {
        this.authorsRepository = authorsRepository;
        this.booksRepository = booksRepository;
        this.publishersRepository = publishersRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher artBook = new Publisher("ASTBook", "Address", "City", "Zip", "State");
        publishersRepository.save(artBook);

        Author bob = new Author("Martin", "Fauler");
        Book clean = new Book("Clean Code", " 212334");
        Book developer = new Book("How became a great developer", " 212334reree");

        bob.getBooks().add(clean);
        bob.getBooks().add(developer);

        clean.getAuthors().add(bob);
        developer.getAuthors().add(bob);

        artBook.getBooks().add(clean);
        artBook.getBooks().add(developer);

        clean.setPublisher(artBook);
        developer.setPublisher(artBook);

        authorsRepository.save(bob);

        booksRepository.save(clean);
        booksRepository.save(developer);
        publishersRepository.save(artBook);


        Author conly = new Author("Michael", "O'Connely");
        Book software = new Book("Sowftware development", "asasasassa");

        conly.getBooks().add(software);
        software.getAuthors().add(conly);

        artBook.getBooks().add(software);
        software.setPublisher(artBook);

        authorsRepository.save(conly);
        booksRepository.save(software);
        publishersRepository.save(artBook);


        System.out.println("Started bootstrap");
        System.out.println("Number of books : " + booksRepository.count());
        System.out.println("Number of authors : " + authorsRepository.count());
        System.out.println("Number of publishers : " + publishersRepository.count());

    }
}
