package com.git.authorBook.GitAuthorBookPublisher.controller;


import com.git.authorBook.GitAuthorBookPublisher.Entity.Author;
import com.git.authorBook.GitAuthorBookPublisher.repository.AuthorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping(value = "/authors")
    public List<Author> getAuthors(){
        List<Author> authors=null;
        for(Author author:authorRepository.findAll()){
            authors.add(author);
        }

        if(authors != null)
            return authors;

        throw new RuntimeException("No Author available");
    }

}
