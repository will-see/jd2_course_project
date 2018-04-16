package com.pvt.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class BookDto {

    private long bookId;
    private String name;
    private String ganr;
    private int pages;
    private String author;
    private int bookCount;


}
