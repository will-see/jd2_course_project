package com.pvt.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
public class FormularDto {
    private int formularId;
    private String name;
    private BigInteger bookId;
    private BigInteger userId;
    private String author;
}
