package com.pvt.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Book {
    private long bookId;
    private String name;
    private String ganr;
    private int pages;
    private long authorId;
    private int bookCount;


    public Book(String name, String ganr, int pages, long authorId, int bookCount) {
        this.name = name;
        this.ganr = ganr;
        this.pages = pages;
        this.authorId = authorId;
        this.bookCount = bookCount;
    }
}
