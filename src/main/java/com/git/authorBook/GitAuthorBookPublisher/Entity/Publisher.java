package com.git.authorBook.GitAuthorBookPublisher.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pubId;
    private String pubName;
    private String address;


    @OneToOne(mappedBy = "publisher", fetch = FetchType.LAZY)
    private Book book;


    public Publisher() {
    }

    public Publisher(String pubName, String address) {
        this.pubName = pubName;
        this.address = address;
    }

    public Long getPubId() {
        return pubId;
    }

    public Book getBooks() {
        return book;
    }

    public void setBook(Book book) {
        this.book=book;
    }


    public void setPubId(Long pubId) {
        this.pubId = pubId;
    }

    public String getName() {
        return pubName;
    }

    public void setName(String pubName) {
        this.pubName = pubName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "pubId=" + pubId +
                ", name='" + pubName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

