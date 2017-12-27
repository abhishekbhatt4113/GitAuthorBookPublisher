package com.git.authorBook.GitAuthorBookPublisher.controller;


import com.git.authorBook.GitAuthorBookPublisher.Entity.Book;
import com.git.authorBook.GitAuthorBookPublisher.repository.BookRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping(value = "/books")
    public List<Book> getBook(){
        List<Book> books= new ArrayList<>();
        bookRepository.findAll()
                .forEach(
                        e -> books.add(e)
                );
        return books;
    }
/*
    @GetMapping(value = "/books/{id}")
    public Book getBook(@PathVariable Long id){

        bookRepository.findById(id)


        return book;
    }*/

}
