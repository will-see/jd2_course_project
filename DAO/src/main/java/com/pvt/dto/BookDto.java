package com.pvt.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class BookDto {

    private long bookId;
    private String title;
    private String ganr;
    private int pages;
    private String author;
    private int bookCount;


}
