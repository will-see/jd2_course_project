package com.pvt.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "BOOKS")
public class Book {
    @Id
    @GeneratedValue
    @Column
    private Long bookId;

    @Column
    private String title;

    @Column
    private String ganr;

    @Column
    private int pages;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn (name = "AUTHOR_ID")
    private Author author;

    @Column
    private int bookCount;

    @OneToOne(mappedBy = "book", cascade = {CascadeType.ALL})
    private Item item;

    public Book(String title, String ganr, int pages, Author author, int bookCount) {
        this.title = title;
        this.ganr = ganr;
        this.pages = pages;
        this.author = author;
        this.bookCount = bookCount;
    }
}
