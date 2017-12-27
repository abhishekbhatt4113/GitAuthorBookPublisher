package com.git.authorBook.GitAuthorBookPublisher.bootstrap;

import com.git.authorBook.GitAuthorBookPublisher.Entity.Author;
import com.git.authorBook.GitAuthorBookPublisher.Entity.Book;
import com.git.authorBook.GitAuthorBookPublisher.Entity.Publisher;
import com.git.authorBook.GitAuthorBookPublisher.repository.AuthorRepository;
import com.git.authorBook.GitAuthorBookPublisher.repository.BookRepository;
import com.git.authorBook.GitAuthorBookPublisher.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Publisher publisher1= new Publisher("Pearson","Delhi");
        publisherRepository.save(publisher1);


        Publisher publisher2= new Publisher("Apache","London");
        publisherRepository.save(publisher2);

        Author author1 = new Author("Abhishek", "Bhatt");
        Book book1= new Book("Java / J2EE", "1234", publisher1);
        book1.addAuthors(author1);
        author1.addBooks(book1);


        authorRepository.save(author1);
        bookRepository.save(book1);


        Author author2 = new Author("Pratik", "Kaneriya");
        Book book2= new Book("Oracle DBA", "12567",publisher2);
        book2.addAuthors(author2);

        authorRepository.save(author2);
        bookRepository.save(book2);

    }

}
