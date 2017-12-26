package com.git.authorBook.GitAuthorBookPublisher.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;
    private String title;
    private String isbn;
    private String publisher;

    @ManyToMany
    @JoinTable(name = "Book_Author",
        joinColumns = @JoinColumn(name = "Book_ID"),
        inverseJoinColumns = @JoinColumn(name = "Author_ID"))
    private Set<Author> authors= new HashSet();

    public Book() {
    }

    public Book(Long bookId, String title, String isbn, String publisher) {
        this.bookId = bookId;
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    public Book(Long bookId, String title, String isbn, String publisher, Set<Author> authors) {
        this.bookId = bookId;
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.authors = authors;
    }

    public Long getId() {
        return bookId;
    }

    public void setId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void addAuthors(Author author) {
        this.authors.add(author);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return bookId != null ? bookId.equals(book.bookId) : book.bookId == null;
    }

    @Override
    public int hashCode() {
        return bookId != null ? bookId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + bookId +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", authors=" + authors +
                '}';
    }
}
