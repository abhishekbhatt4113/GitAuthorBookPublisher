package com.git.authorBook.GitAuthorBookPublisher.repository;

import com.git.authorBook.GitAuthorBookPublisher.Entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
