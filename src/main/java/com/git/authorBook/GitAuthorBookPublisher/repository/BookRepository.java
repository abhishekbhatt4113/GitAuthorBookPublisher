package com.git.authorBook.GitAuthorBookPublisher.repository;

import com.git.authorBook.GitAuthorBookPublisher.Entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{

}
