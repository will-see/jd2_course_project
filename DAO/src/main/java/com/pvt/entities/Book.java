package com.pvt.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(of = "title")
@Table (name = "BOOKS")
public class Book {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
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

//    @ManyToOne
//    @JoinColumn(name = "FORMULAR_ID")
//    private Formular formular;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable (name = "formular_book", joinColumns = {@JoinColumn(name = "bookId")},
    inverseJoinColumns = {@JoinColumn(name = "FORMULAR_ID")}
    )
    private List<Formular> formulars =new ArrayList<>();

//    public Book(String title, String ganr, int pages, Author author, int bookCount) {
//        this.title = title;
//        this.ganr = ganr;
//        this.pages = pages;
//        this.author = author;
//        this.bookCount = bookCount;
//    }
}
